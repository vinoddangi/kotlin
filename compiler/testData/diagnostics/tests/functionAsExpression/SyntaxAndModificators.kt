// !DIAGNOSTICS: -UNUSED_PARAMETER

annotation class ann(val name: String)
val ok = "OK"

class A

val withName = fun name() {}
val extensionWithName = fun A.name() {}
val withoutName = fun () {}
val extensionWithoutName = fun A.() {}

val withoutBody = <!NON_MEMBER_FUNCTION_NO_BODY!>fun ()<!>

val public_fun = <!UNRESOLVED_REFERENCE!>public<!> <!SYNTAX!>fun () {}<!>
val open_fun = <!UNRESOLVED_REFERENCE!>open<!> <!SYNTAX!>fun () {}<!>
val final_fun = <!UNRESOLVED_REFERENCE!>final<!> <!SYNTAX!>fun () {}<!>

val generic_fun = fun<!TYPE_PARAMETERS_NOT_ALLOWED!><T><!>(t: T): T = null!!
val extension_generic_fun = fun<!TYPE_PARAMETERS_NOT_ALLOWED!><T><!><!UNRESOLVED_REFERENCE!>T<!>.(t: T): T = null!!

fun <T> fun_with_where() = fun () <!SYNTAX!>where <!DEBUG_INFO_MISSING_UNRESOLVED!>T<!>: <!DEBUG_INFO_MISSING_UNRESOLVED!>A<!><!> {}

val withAnnotation = [ann(ok)] fun () {}

val withReturn = fun (): Int { return 5}
val withExpression = fun() = 5
val funfun = fun() = fun() = 5

val defaultParam = fun(i: Int = <!FUNCTION_EXPRESSION_WITH_DEFAULT_VALUE!>4<!>) {}

val vararg_fun = fun name(<!USELESS_VARARG_ON_PARAMETER!>vararg par: Int<!>) {}