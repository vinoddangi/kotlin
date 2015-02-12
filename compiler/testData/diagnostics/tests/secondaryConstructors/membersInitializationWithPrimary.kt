// !DIAGNOSTICS: -UNUSED_PARAMETER
class A(val w: Char) {
    val x: Int
    var y: Int
    val z: Int
    val v = -1

    <!MUST_BE_INITIALIZED_OR_BE_ABSTRACT!>val uninitialized: Int<!>
    val overinitialized: Int

    constructor(): this('a') {
        y = 2
        <!VAL_REASSIGNMENT!>overinitialized<!> = 1
        uninitialized = 2
    }

    // anonymous
    constructor {
        x = w.toInt()
        z = 8
        overinitialized = 1
    }

    constructor(a: Int, b: Int = 3): this(b.toChar()) {
        y = x
    }

    // anonymous
    constructor {
        y = 9
    }
}