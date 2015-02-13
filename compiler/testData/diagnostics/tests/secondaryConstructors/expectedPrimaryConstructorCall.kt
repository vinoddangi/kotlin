// !DIAGNOSTICS: -UNUSED_PARAMETER
class A(x: Int) {
    constructor() <!EXPECTED_PRIMARY_CONSTRUCTOR_DELEGATION_CALL!><!>{}
}
open class B(x: Int)
class C(x: Int) : B(x) {
    constructor(): <!EXPECTED_PRIMARY_CONSTRUCTOR_DELEGATION_CALL!>super(1)<!> {}
}
