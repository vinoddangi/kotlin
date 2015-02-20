/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.load.kotlin.reflect

import org.jetbrains.kotlin.load.kotlin.KotlinJvmBinaryClass
import org.jetbrains.kotlin.load.kotlin.header.KotlinClassHeader
import org.jetbrains.kotlin.load.java.structure.reflect.classId
import org.jetbrains.kotlin.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor
import org.jetbrains.kotlin.name.Name
import java.lang.reflect.Method
import java.lang.reflect.Field
import java.lang.reflect.Constructor

suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
private val TYPES_ELIGIBLE_FOR_SIMPLE_VISIT = setOf(
        // Primitives
        javaClass<java.lang.Integer>(), javaClass<java.lang.Character>(), javaClass<java.lang.Byte>(), javaClass<java.lang.Long>(),
        javaClass<java.lang.Short>(), javaClass<java.lang.Boolean>(), javaClass<java.lang.Double>(), javaClass<java.lang.Float>(),
        // Arrays of primitives
        javaClass<IntArray>(), javaClass<CharArray>(), javaClass<ByteArray>(), javaClass<LongArray>(),
        javaClass<ShortArray>(), javaClass<BooleanArray>(), javaClass<DoubleArray>(), javaClass<FloatArray>(),
        // Others
        javaClass<Class<*>>(), javaClass<String>()
)

public class ReflectKotlinClass(
        private val klass: Class<*>,
        private val classHeader: KotlinClassHeader
) : KotlinJvmBinaryClass {
    class object {
        public fun create(klass: Class<*>): ReflectKotlinClass? {
            val headerReader = ReadKotlinClassHeaderAnnotationVisitor()
            ReflectClassStructure.loadClassAnnotations(klass, headerReader)
            val header = headerReader.createHeader()
            return if (header == null) null else ReflectKotlinClass(klass, header)
        }
    }

    override fun getClassId() = klass.classId

    override fun getClassHeader() = classHeader

    override fun loadClassAnnotations(visitor: KotlinJvmBinaryClass.AnnotationVisitor) {
        ReflectClassStructure.loadClassAnnotations(klass, visitor)
    }

    override fun visitMembers(visitor: KotlinJvmBinaryClass.MemberVisitor) {
        ReflectClassStructure.visitMembers(klass, visitor)
    }
}

private object ReflectClassStructure {
    fun loadClassAnnotations(klass: Class<*>, visitor: KotlinJvmBinaryClass.AnnotationVisitor) {
        for (annotation in klass.getDeclaredAnnotations()) {
            processAnnotation(visitor, annotation)
        }
        visitor.visitEnd()
    }

    fun visitMembers(klass: Class<*>, memberVisitor: KotlinJvmBinaryClass.MemberVisitor) {
        for (method in klass.getDeclaredMethods()) {
            val visitor = memberVisitor.visitMethod(Name.identifier(method.getName()), SignatureSerializer.methodDesc(method))
            if (visitor == null) continue

            for (annotation in method.getDeclaredAnnotations()) {
                processAnnotation(visitor, annotation)
            }

            for ((index, annotations) in method.getParameterAnnotations().withIndices()) {
                for (annotation in annotations) {
                    val argumentVisitor = visitor.visitParameterAnnotation(index, annotation.annotationType().classId)
                    if (argumentVisitor != null) {
                        processAnnotationArguments(argumentVisitor, annotation)
                    }
                }
            }

            visitor.visitEnd()
        }

        for (constructor in klass.getDeclaredConstructors()) {
            // TODO: load annotations on constructors
            val visitor = memberVisitor.visitMethod(Name.special("<init>"), SignatureSerializer.constructorDesc(constructor))
            if (visitor == null) continue

            // Constructors of enums have 2 additional synthetic parameters
            // TODO: the similar logic should probably be present for annotations on parameters of inner class constructors
            var index = if (klass.isEnum()) 2 else 0
            for (annotations in constructor.getParameterAnnotations()) {
                for (annotation in annotations) {
                    val argumentVisitor = visitor.visitParameterAnnotation(index, annotation.annotationType().classId)
                    if (argumentVisitor != null) {
                        processAnnotationArguments(argumentVisitor, annotation)
                    }
                }
                index++
            }
        }

        for (field in klass.getDeclaredFields()) {
            val visitor = memberVisitor.visitField(Name.identifier(field.getName()), SignatureSerializer.fieldDesc(field), null)
            if (visitor == null) continue

            for (annotation in field.getDeclaredAnnotations()) {
                processAnnotation(visitor, annotation)
            }

            visitor.visitEnd()
        }
    }

    private fun processAnnotation(visitor: KotlinJvmBinaryClass.AnnotationVisitor, annotation: Annotation) {
        val argumentVisitor = visitor.visitAnnotation(annotation.annotationType().classId)
        if (argumentVisitor != null) {
            processAnnotationArguments(argumentVisitor, annotation)
        }
    }

    private fun processAnnotationArguments(visitor: KotlinJvmBinaryClass.AnnotationArgumentVisitor, annotation: Annotation) {
        for (method in annotation.annotationType().getDeclaredMethods()) {
            processAnnotationArgumentValue(visitor, Name.identifier(method.getName()), method(annotation))
        }
        visitor.visitEnd()
    }

    private fun processAnnotationArgumentValue(visitor: KotlinJvmBinaryClass.AnnotationArgumentVisitor, name: Name?, value: Any) {
        val clazz = value.javaClass
        when {
            clazz in TYPES_ELIGIBLE_FOR_SIMPLE_VISIT -> {
                visitor.visit(name, value)
            }
            javaClass<Enum<*>>().isAssignableFrom(clazz) -> {
                visitor.visitEnum(name!!, clazz.classId, Name.identifier(value.toString()))
            }
            javaClass<Annotation>().isAssignableFrom(clazz) -> {
                // TODO: support values of annotation types
                throw UnsupportedOperationException("Values of annotation types are not yet supported in Kotlin reflection: $value")
            }
            clazz.isArray() -> {
                val elementVisitor = visitor.visitArray(name!!) ?: return
                val componentType = clazz.getComponentType()
                if (javaClass<Enum<*>>().isAssignableFrom(componentType)) {
                    val componentClassName = componentType.classId
                    for (element in value as Array<*>) {
                        elementVisitor.visitEnum(componentClassName, Name.identifier(element.toString()))
                    }
                }
                else {
                    for (element in value as Array<*>) {
                        elementVisitor.visit(element)
                    }
                }
                elementVisitor.visitEnd()
            }
            else -> {
                throw UnsupportedOperationException("Unsupported annotation argument value ($clazz): $value")
            }
        }
    }
}

private object SignatureSerializer {
    fun methodDesc(method: Method): String {
        val sb = StringBuilder()
        sb.append("(")
        for (parameterType in method.getParameterTypes()) {
            sb.append(typeDesc(parameterType))
        }
        sb.append(")")
        sb.append(typeDesc(method.getReturnType()))
        return sb.toString()
    }

    fun constructorDesc(constructor: Constructor<*>): String {
        val sb = StringBuilder()
        sb.append("(")
        for (parameterType in constructor.getParameterTypes()) {
            sb.append(typeDesc(parameterType))
        }
        sb.append(")V")
        return sb.toString()
    }

    fun fieldDesc(field: Field): String {
        return typeDesc(field.getType())
    }

    suppress("UNCHECKED_CAST")
    fun typeDesc(clazz: Class<*>): String {
        if (clazz == Void.TYPE) return "V";
        // This is a clever exploitation of a format returned by Class.getName(): for arrays, it's almost an internal name,
        // but with '.' instead of '/'
        // TODO: ensure there are tests on arrays of nested classes, multi-dimensional arrays, etc.
        val arrayClass = java.lang.reflect.Array.newInstance(clazz as Class<Any>, 0).javaClass
        return arrayClass.getName().substring(1).replace('.', '/')
    }
}
