class A {
    constructor {}

    private constructor {}

    val x = f()
    constructor {
        x = 1
    }

    val y = f()
    {
        x = 2
    }
    {
        x = 3
    }
}
