package io.github.ggarber.sdpparser

external fun require(name: String): dynamic
external val __dirname: dynamic

val fs = require("fs")
val path = require("path");

actual fun loadResource(name: String): String {
    val path = path.join(
        // <ROOT>/sdpparser/build/js/packages/sdp-parser-sdpparser-test/kotlin
        __dirname,
        "../../../../..",
        "sdpparser/build/processedResources/js/test",
        name
    )

    return fs.readFileSync(path, "utf8")
}