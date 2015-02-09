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

package kotlin.js

object IntDefaultObjectImpl : IntDefaultObject, Parsable<Int> {
    // TODO: Should behaviour be same to JVM function
    override fun parse(str: String) = parseInt(str)
}

library
val POSITIVE_INFINITY_Double : Double = noImpl

library
val NEGATIVE_INFINITY_Double : Double = noImpl

library
private val NaN_Double : Double = noImpl

library
private fun parseDouble(s: String) : Double = noImpl

object DoubleDefaultObjectImpl : DoubleDefaultObject, Parsable<Double> {
    val POSITIVE_INFINITY : Double = POSITIVE_INFINITY_Double
    val NEGATIVE_INFINITY : Double = NEGATIVE_INFINITY_Double
    val NaN : Double = NaN_Double

    override fun parse(str: String) = parseDouble(str)
}