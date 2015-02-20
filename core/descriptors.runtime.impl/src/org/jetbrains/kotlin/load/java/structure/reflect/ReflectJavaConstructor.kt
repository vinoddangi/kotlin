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

package org.jetbrains.kotlin.load.java.structure.reflect

import java.lang.reflect.Constructor
import org.jetbrains.kotlin.load.java.structure.*
import org.jetbrains.kotlin.name.FqName
import java.util.ArrayList
import java.util.Arrays
import java.lang.reflect.Modifier

public class ReflectJavaConstructor(constructor: Constructor<*>) : ReflectJavaMember(constructor), JavaConstructor {
    private val constructor: Constructor<*>
        get() = member as Constructor<*>

    override fun getAnnotations() = getAnnotations(constructor.getDeclaredAnnotations())

    override fun findAnnotation(fqName: FqName) = findAnnotation(constructor.getDeclaredAnnotations(), fqName)

    override fun getValueParameters(): List<JavaValueParameter> {
        // TODO: test this code with annotations on constructor parameters of enums and inner classes
        val types = dropSynthetic(constructor.getGenericParameterTypes()!!)
        val annotations = dropSynthetic(constructor.getParameterAnnotations())
        val result = ArrayList<JavaValueParameter>()
        val methodIsVararg = constructor.isVarArgs()
        for (i in types.indices) {
            val isVararg = methodIsVararg && i == types.lastIndex
            result.add(ReflectJavaValueParameter(ReflectJavaType.create(types[i]), annotations[i]!!, isVararg))
        }
        return result
    }

    // Constructors of inner classes have one additional synthetic parameter
    private fun <T> dropSynthetic(array: Array<T>): List<T> {
        val list = Arrays.asList(*array)
        val klass = constructor.getDeclaringClass()
        return if (klass.getDeclaringClass() != null && !Modifier.isStatic(klass.getModifiers())) {
            list.subList(1, array.size)
        }
        else list
    }

    override fun getTypeParameters(): List<JavaTypeParameter> {
        // TODO
        return listOf()
    }
}
