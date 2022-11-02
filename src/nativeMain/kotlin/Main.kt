import org.kobjects.ktxml.api.EventType
import org.kobjects.ktxml.mini.MiniXmlPullParser

fun main() {
    println("Hello, Kotlin/Native!")
    val parser = MiniXmlPullParser("<text>Hello World</text>".iterator())
}