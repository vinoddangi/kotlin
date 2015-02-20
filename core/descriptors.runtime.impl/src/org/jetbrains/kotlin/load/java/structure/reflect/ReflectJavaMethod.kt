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

import java.lang.reflect.Method
import java.util.ArrayList
import org.jetbrains.kotlin.load.java.structure.JavaMethod
import org.jetbrains.kotlin.load.java.structure.JavaAnnotation
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.load.java.structure.JavaValueParameter
import org.jetbrains.kotlin.load.java.structure.JavaType

public class ReflectJavaMethod(method: Method) : ReflectJavaMember(method), JavaMethod {
    private val method: Method
        get() = member as Method

    override fun getAnnotations(): Collection<JavaAnnotation> {
        // TODO
        return listOf()
    }

    override fun findAnnotation(fqName: FqName): JavaAnnotation? {
        // TODO
        return null
    }

    override fun getValueParameters(): List<JavaValueParameter> {
        val types = method.getGenericParameterTypes()!!
        val annotations = method.getParameterAnnotations()
        val result = ArrayList<JavaValueParameter>()
        val methodIsVararg = method.isVarArgs()
        for (i in types.indices) {
            val isVararg = methodIsVararg && i == types.lastIndex
            result.add(ReflectJavaValueParameter(ReflectJavaType.create(types[i]), annotations[i], isVararg))
        }
        return result
    }

    override fun getReturnType(): JavaType? {
        // TODO
        return ReflectJavaType.create(method.getGenericReturnType()!!)
    }

    override fun hasAnnotationParameterDefaultValue() = method.getDefaultValue() != null

    override fun getTypeParameters() = method.getTypeParameters().map { ReflectJavaTypeParameter(it!!) }
}
