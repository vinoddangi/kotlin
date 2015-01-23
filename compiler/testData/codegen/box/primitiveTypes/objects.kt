fun box(): String {
    try {
        val i = Int
        val d = Double

        test(Int)
        test(Double)
    }
    catch (e: Throwable) {
        return "Error: \n" + e
    }

    return "OK"
}

fun test(a: Any) {

}


