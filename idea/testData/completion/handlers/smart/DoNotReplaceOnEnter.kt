fun foo(p: Int): Int = p

fun f(pb: Int): Int {
    return <caret>foo(1)
}

//ELEMENT: pb
