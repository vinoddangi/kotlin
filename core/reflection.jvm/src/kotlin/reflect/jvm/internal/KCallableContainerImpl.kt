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

import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.renderer.DescriptorRenderer
import org.jetbrains.kotlin.resolve.scopes.JetScope
import org.jetbrains.kotlin.types.JetType
import kotlin.reflect.KotlinReflectionInternalError

abstract class KCallableContainerImpl {
    abstract val jClass: Class<*>

    abstract val scope: JetScope

    protected fun findPropertyDescriptor(name: String, receiverParameter: JetType? = null): () -> PropertyDescriptor = {
        val properties = scope
                .getProperties(Name.guess(name))
                .filter { descriptor ->
                    descriptor is PropertyDescriptor &&
                    descriptor.getName().asString() == name &&
                    typeErasuresEqual(descriptor.getExtensionReceiverParameter()?.getType(), receiverParameter)
                }

        if (properties.size() != 1) {
            val debugText =
                    if (receiverParameter == null) name
                    else "${DescriptorRenderer.SHORT_NAMES_IN_TYPES.renderType(receiverParameter)}.$name"
            throw KotlinReflectionInternalError(
                    if (properties.isEmpty()) "Property '$debugText' not resolved in $this"
                    else "${properties.size()} properties '$debugText' resolved in $this"
            )
        }

        properties.iterator().next() as PropertyDescriptor
    }
}

// TODO: this is wrong on many levels. Support generic type arguments somehow instead
private fun typeErasuresEqual(t1: JetType?, t2: JetType?): Boolean {
    if (t1 == null || t2 == null) {
        return t1 == t2
    }

    fun mapType(type: JetType): Any {
        // TODO: List vs MutableList
        return type.getConstructor().getDeclarationDescriptor() as? ClassDescriptor ?: type
    }

    return mapType(t1) == mapType(t2)
}
