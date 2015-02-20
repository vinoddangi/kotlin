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

import java.lang.reflect.Type
import org.jetbrains.kotlin.load.java.structure.*
import java.lang.reflect.TypeVariable
import java.lang.reflect.ParameterizedType

public class ReflectJavaClassifierType(val classifierType: Type) : ReflectJavaType(), JavaClassifierType {
    override fun getClassifier(): JavaClassifier? {
        return when (classifierType) {
            is Class<*> -> ReflectJavaClass(classifierType)
            is TypeVariable<*> -> ReflectJavaTypeParameter(classifierType)
            is ParameterizedType -> ReflectJavaClass(classifierType.getRawType() as Class<*>)
            else -> throw IllegalStateException("Not a classifier type (${classifierType.javaClass}): $classifierType")
        }
    }

    override fun getSubstitutor(): JavaTypeSubstitutor {
        // TODO
        return JavaTypeSubstitutor.EMPTY
    }

    override fun getSupertypes(): Collection<JavaClassifierType> {
        // TODO
        return (getClassifier() as JavaClass).getSupertypes()
    }

    override fun getPresentableText(): String {
        // TODO
        throw UnsupportedOperationException()
    }

    override fun isRaw(): Boolean {
        // TODO
        return false
    }

    override fun getTypeArguments(): List<JavaType> {
        if (classifierType is ParameterizedType) {
            return classifierType.getActualTypeArguments()!!.map { ReflectJavaType.create(it) }
        }
        return listOf()
    }
}
