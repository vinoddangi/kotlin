import java.util.ArrayList

class C(p: Int, p2: Int)

fun foo(pr: Int){
    val result = ArrayList<String>()
    C(1, <caret>result.size())
}

// CHAR: '\t'
// ELEMENT: pr
