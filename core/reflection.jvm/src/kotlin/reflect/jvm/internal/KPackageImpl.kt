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

package kotlin.reflect.jvm.internal

import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.descriptors.PackageViewDescriptor
import org.jetbrains.kotlin.load.java.structure.reflect.classId
import org.jetbrains.kotlin.platform.JavaToKotlinClassMap
import org.jetbrains.kotlin.resolve.scopes.JetScope
import org.jetbrains.kotlin.types.JetType
import org.jetbrains.kotlin.types.Variance
import kotlin.jvm.internal.KotlinPackage
import kotlin.reflect.*
import kotlin.reflect.jvm.kotlin

class KPackageImpl(override val jClass: Class<*>) : KCallableContainerImpl(), KPackage {
    val descriptor by ReflectProperties.lazySoft {(): PackageViewDescriptor ->
        val moduleData = jClass.getOrCreateModule()
        val fqName = jClass.classId.getPackageFqName()

        val found = moduleData.module.getPackage(fqName)
        if (found != null) return@lazySoft found

        throw KotlinReflectionInternalError("Package not resolved: $fqName")
    }

    override val scope: JetScope get() = descriptor.getMemberScope()

    fun topLevelVariable(name: String): KTopLevelVariable<*> {
        val descriptor = findPropertyDescriptor(name)
        return KTopLevelVariableImpl(this, descriptor)
    }

    fun mutableTopLevelVariable(name: String): KMutableTopLevelVariable<*> {
        val descriptor = findPropertyDescriptor(name)
        return KMutableTopLevelVariableImpl(this, descriptor)
    }

    fun <T> topLevelExtensionProperty(name: String, receiver: Class<T>): KTopLevelExtensionProperty<T, *> {
        val descriptor = findPropertyDescriptor(name, receiver.defaultType)
        return KTopLevelExtensionPropertyImpl(this, descriptor)
    }

    fun <T> mutableTopLevelExtensionProperty(name: String, receiver: Class<T>): KMutableTopLevelExtensionProperty<T, *> {
        val descriptor = findPropertyDescriptor(name, receiver.defaultType)
        return KMutableTopLevelExtensionPropertyImpl(this, descriptor)
    }

    override fun equals(other: Any?): Boolean =
            other is KPackageImpl && jClass == other.jClass

    override fun hashCode(): Int =
            jClass.hashCode()

    override fun toString(): String {
        val name = jClass.getName()
        return "package " + if (jClass.isAnnotationPresent(javaClass<KotlinPackage>())) {
            if (name == "_DefaultPackage") "<default>" else name.substringBeforeLast(".")
        }
        else name
    }
}

// Constructs generic JetType for array types and erased for all other types (non-reified classes and primitives)
private val Class<*>.defaultType: JetType
    get() {
        return if (isArray()) {
            val componentType = getComponentType()
            if (componentType.isPrimitive()) {
                JavaToKotlinClassMap.INSTANCE.mapPrimitiveKotlinClass("[${componentType.getName()}")!!
            }
            else {
                KotlinBuiltIns.getInstance().getArrayType(Variance.INVARIANT, componentType.defaultType)
            }
        }
        else if (isPrimitive()) {
            JavaToKotlinClassMap.INSTANCE.mapPrimitiveKotlinClass(getName())!!
        }
        else {
            val descriptor = (this@defaultType.kotlin as KClassImpl<*>).descriptor
            val classes = JavaToKotlinClassMap.INSTANCE.mapPlatformClass(descriptor)
            // TODO: what should be done if there's more than one?
            (classes.firstOrNull() ?: descriptor).getDefaultType()
        }
    }
