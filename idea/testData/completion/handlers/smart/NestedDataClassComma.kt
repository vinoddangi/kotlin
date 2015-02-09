class Outer {
    private data class Nested(val v: Int, val v2: Int)

    fun foo(pr: Int): Inner {
        return Outer.Nested(<caret>)
    }
}

// ELEMENT: pr
