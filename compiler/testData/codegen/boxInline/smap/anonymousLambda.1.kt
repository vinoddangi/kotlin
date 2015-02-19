import builders.*
import kotlin.InlineOption.*

fun test(): String {
    var res = "Fail"

    call {
        res = "OK"
    }

    return res
}


fun box(): String {
    return test()
}


//SMAP
//anonymousLambda.1.kt
//Kotlin
//*S Kotlin
//*F
//+ 1 anonymousLambda.1.kt
//_DefaultPackage
//+ 2 anonymousLambda.2.kt
//builders/BuildersPackage
//*L
//1#1,46:1
//4#2:47
//*E
//
//SMAP
//anonymousLambda.2.kt
//Kotlin
//*S Kotlin
//*F
//+ 1 anonymousLambda.2.kt
//builders/BuildersPackage$anonymousLambda_2$HASH$call$1
//+ 2 anonymousLambda.1.kt
//_DefaultPackage$anonymousLambda_1$HASH
//*L
//1#1,18:1
//8#2:19
//*E