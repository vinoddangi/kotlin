fun test() {
    fun bar() {
        val <!UNUSED_VARIABLE!>bas<!> = fun() {
            <!RETURN_NOT_ALLOWED!>return@bar<!>
        }
    }

    val <!UNUSED_VARIABLE!>bar<!> = fun() {
        <!RETURN_NOT_ALLOWED!>return@test<!>
    }
}

fun foo() {
    val <!UNUSED_VARIABLE!>bal<!> = @bag fun () {
        val <!UNUSED_VARIABLE!>bar<!> = fun() {
            <!RETURN_NOT_ALLOWED!>return@bag<!>
        }
        return@bag
    }
}