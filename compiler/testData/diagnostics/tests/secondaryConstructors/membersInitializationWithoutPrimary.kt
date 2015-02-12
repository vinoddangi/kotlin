// !DIAGNOSTICS: -UNUSED_PARAMETER
class A {
    val x: Int
    var y: Int
    val z: Int
    val v = -1

    <!MUST_BE_INITIALIZED_OR_BE_ABSTRACT!>val uninitialized: Int<!>
    val overinitialized: Int

    constructor() {
        x = 1
        y = 2
        <!VAL_REASSIGNMENT!>overinitialized<!> = 1
        uninitialized = 2
    }
    constructor(a: Int, b: Int = 3) {
        x = a
        y = x
    }

    //anonymous
    constructor {
        z = 8
        overinitialized = 1
    }

    constructor(a: String, b: Int = 4): this() {
        y = 5
    }
    constructor(a: Double, b: Int = 6): this(a.toInt()) {
        y = 7
    }

    // anonymous
    constructor {
        y = 9
    }
}
