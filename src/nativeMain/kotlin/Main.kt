import org.kobjects.ktxml.mini.MiniXmlPullParser

fun main() {
    println("Hello, Kotlin/Native!")

    val parser = MiniXmlPullParser("<text>Hello World</text>".iterator())
    println("${parser.eventType}")
    println("${parser.next()}")
    println("${parser.nextText()}")
    println("${parser.eventType}")
    println("${parser.next()}")
}