// !DIAGNOSTICS: -UNUSED_PARAMETER
class A(x: Int) {
    constructor(x: Double) {}
    constructor(x: String) {}
}
val x1: A = A(1)
val x2: A = A(1.0)
val x3: A = A("abc")
