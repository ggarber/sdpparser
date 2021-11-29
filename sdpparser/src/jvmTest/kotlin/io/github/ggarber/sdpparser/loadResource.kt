package io.github.ggarber.sdpparser

actual fun loadResource(name: String): String {
    return Loader.load(name)
}

private object Loader {
    fun load(name: String): String {
        return javaClass.getResource(name)!!.readText()
    }
}