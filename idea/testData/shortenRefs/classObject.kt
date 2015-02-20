package p.q

<selection>fun foo(myC: p.q.MyClass, def: p.q.MyClass.Default, nes: p.q.MyClass.Default.Nested) {
    p.q.MyClass.Default.foo()
    p.q.MyClass.Default.coProp
    p.q.MyClass.Default
    p.q.MyClass
    p.q.MyClass.coProp
    p.q.MyClass.foo()
}</selection>

class MyClass {
    class object {
        val coProp = 1

        class Nested

        fun foo() {

        }
    }
}