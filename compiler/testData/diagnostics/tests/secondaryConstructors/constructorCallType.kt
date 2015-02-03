// !DIAGNOSTICS: -UNUSED_PARAMETER
class A(x: Int) {
    constructor(x: Double): this(1) {}
    constructor(x: String): this(1) {}
}
val x1: A = A(1)
val x2: A = A(1.0)
val x3: A = A("abc")
