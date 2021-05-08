# Introduction

Session Description Protocol (SDP) parser implemented in Kotlin.  Defines internal grammar based on RFC4566 - SDP, RFC5245 - ICE, and many more.

This is a Kotlin and type safe port of the [sdp-transform](https://github.com/clux/sdp-transform) javascript implementation.

# Installation

Until published in maven central you can install it locally by running gradle `publishToMavenLocal` task.

# Usage

## Generating a Session Description

```
import io.github.ggarber.sdpparser

val session = SdpSession()
session.version = SdpVersion(0)
session.origin = SdpOrigin("-", 0, 0, "IN", 4, "0.0.0.0")
session.name = SdpName("-")
val media = SdpMedia()
media.mline = SdpMline("audio", 8888, "UDP/TLS/RTP/SAVPF", "0")
session.media.add(media)
val str = session.write()
```

## Parsing a Session Description

```
import io.github.ggarber.sdpparser

val session = SdpParser.parse(str)
```
