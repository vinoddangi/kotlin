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

package kotlin.jvm

public val IntDefaultObject.MAX_INT: Int
    get() = java.lang.Integer.MAX_VALUE

public val IntDefaultObject.MIN_INT: Int
    get() = java.lang.Integer.MIN_VALUE

public val DoubleDefaultObject.MIN_VALUE: Double
    get() = java.lang.Double.MIN_VALUE

public val DoubleDefaultObject.MAX_VALUE: Double
    get() = java.lang.Double.MAX_VALUE

public val DoubleDefaultObject.POSITIVE_INFINITY: Double get() = java.lang.Double.POSITIVE_INFINITY
public val DoubleDefaultObject.NEGATIVE_INFINITY: Double get() = java.lang.Double.NEGATIVE_INFINITY
public val DoubleDefaultObject.NaN: Double get() = java.lang.Double.NaN