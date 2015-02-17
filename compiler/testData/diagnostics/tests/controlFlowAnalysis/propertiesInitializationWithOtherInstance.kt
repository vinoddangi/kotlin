class A(val next: A? = null) {
    <!MUST_BE_INITIALIZED_OR_BE_ABSTRACT!>val x: String<!> // should be mark as uninitialized?
    {
        <!VAL_REASSIGNMENT!>next?.x<!> = "a" // should not let re-assignment here?
    }
}

class A1(val next: A1? = null) {
    val x: String // should be mark as uninitialized?
    {
        <!VAL_REASSIGNMENT!>next?.x<!> = "a" // should not let re-assignment here?
        x = "b"
        this.x = "c"
    }
}

class B(val next: B? = null) {
    var x: String = next?.x ?: "default" // doesn't let to use `x` of next
}
