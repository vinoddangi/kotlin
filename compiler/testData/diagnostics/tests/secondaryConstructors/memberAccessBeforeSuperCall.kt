// !DIAGNOSTICS: -UNUSED_PARAMETER
open class B(open val parentProperty: Int)
class A : <!SUPERTYPE_NOT_INITIALIZED!>B<!> {
    val myProp: Int = 1
    override val parentProperty: Int = 2
    constructor(arg: Int = <!UNRESOLVED_REFERENCE!>myProp<!>): super(<!UNRESOLVED_REFERENCE!>myProp<!>) {}
    constructor(x1: Int, arg: Int = <!NO_THIS!>this<!>.<!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>myProp<!>): super(<!NO_THIS!>this<!>.<!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>myProp<!>) {}
    constructor(x1: Int, x2: Int, arg: Int = <!UNRESOLVED_REFERENCE!>parentProperty<!>): super(<!UNRESOLVED_REFERENCE!>parentProperty<!>) {}
    constructor(x1: Int, x2: Int, x3: Int, arg: Int = <!SUPER_NOT_AVAILABLE!>super<!>.<!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>parentProperty<!>): super(<!SUPER_NOT_AVAILABLE!>super<!>.<!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>parentProperty<!>) {}
    constructor(x1: Int, x2: Int, x3: Int, x4: Int, arg: Int = foo(<!NO_THIS!>this<!>)): super(foo(<!NO_THIS!>this<!>)) {}
    constructor(x1: Int, x2: Int, x3: Int, x4: Int, x5: Int, arg: Int = foo(this<!UNRESOLVED_REFERENCE!>@A<!>)): super(foo(this<!UNRESOLVED_REFERENCE!>@A<!>)) {}
}
fun foo(x: A) = 1
