import kotlin.platform.platformName

var state: String = "value"
    [platformName("getter")]
    get
    [platformName("setter")]
    set

fun box(): String {
    val p = ::state

    if (p.name != "state") return "Fail name: ${p.name}"
    if (p.get() != "value") return "Fail get: ${p.get()}"
    p.set("OK")

    return p.get()
}
