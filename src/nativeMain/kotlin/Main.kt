import okio.*
import okio.Path.Companion.toPath
import org.kobjects.ktxml.api.EventType
import org.kobjects.ktxml.mini.MiniXmlPullParser


fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println("Sorry, you need to pass as first parameter the iTunes exported XML file.")
    } else {
        parse(args[0])
    }
}


private fun parse(filename: String) {
    println("Reading '$filename'")
    val input = FileSystem.SYSTEM.read(filename.toPath()) { readUtf8() }

    val parser = MiniXmlPullParser(input.iterator())
    while (true) {
        when (parser.eventType) {
            EventType.START_DOCUMENT -> println("Got start")
            EventType.END_DOCUMENT -> {
                println("got end")
                break
            }
            EventType.START_TAG -> println("start tag ${parser.name} at line ${parser.lineNumber}")
            EventType.END_TAG -> println("end tag ${parser.name}")
            EventType.TEXT -> println("text")
            EventType.CDSECT -> println("cdsect")
            EventType.ENTITY_REF -> println("entity ref")
            EventType.IGNORABLE_WHITESPACE -> println("ignorebale whitespace")
            EventType.PROCESSING_INSTRUCTION -> println("processing ")
            EventType.COMMENT -> println("comment")
            EventType.DOCDECL -> println("docdecl")
            EventType.XML_DECL -> println("xml decl")
        }
        parser.next()
    }
}