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

import kotlin.jvm.internal.KotlinPackage
import kotlin.reflect.*
import org.jetbrains.kotlin.descriptors.PackageViewDescriptor
import org.jetbrains.kotlin.load.java.structure.reflect.classId
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.resolve.scopes.JetScope

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
        return KTopLevelExtensionPropertyImpl(name, this, receiver)
    }

    fun <T> mutableTopLevelExtensionProperty(name: String, receiver: Class<T>): KMutableTopLevelExtensionProperty<T, *> {
        return KMutableTopLevelExtensionPropertyImpl(name, this, receiver)
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
