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

import org.jetbrains.kotlin.load.java.structure.JavaType
import org.jetbrains.kotlin.load.java.structure.JavaArrayType
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable
import java.lang.reflect.ParameterizedType
import java.lang.reflect.GenericArrayType
import java.lang.reflect.WildcardType

private val PRIMITIVE_TYPES = setOf(
        java.lang.Integer.TYPE, java.lang.Character.TYPE, java.lang.Byte.TYPE, java.lang.Long.TYPE,
        java.lang.Short.TYPE, java.lang.Boolean.TYPE, java.lang.Double.TYPE, java.lang.Float.TYPE,
        java.lang.Void.TYPE
)

public abstract class ReflectJavaType : JavaType {
    override fun createArrayType(): JavaArrayType {
        // TODO
        throw UnsupportedOperationException()
    }

    class object {
        fun create(reflectType: Type): ReflectJavaType {
            return when (reflectType) {
                in PRIMITIVE_TYPES -> ReflectJavaPrimitiveType(reflectType as Class<*>)
                is Class<*>, is TypeVariable<*>, is ParameterizedType -> ReflectJavaClassifierType(reflectType)
                is GenericArrayType -> ReflectJavaArrayType(reflectType)
                is WildcardType -> ReflectJavaWildcardType(reflectType)
                else -> throw UnsupportedOperationException("Unsupported type (${reflectType.javaClass}): $reflectType")
            }
        }
    }
}
