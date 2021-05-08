@file:Suppress("SpellCheckingInspection")

package io.github.ggarber.sdpparser

import kotlin.test.*

class SdpParserTest {
    @Test fun testParseEmptyString() {
        assertFails { SdpParser.parse("") }
    }

    @Test fun testParseNormalSdp() {
        val sdp = javaClass.getResource("/normal.sdp").readText()
        val session = SdpParser.parse(sdp)
        assertEquals(0, session.version!!.value)

        assertEquals("-", session.origin!!.username)
        assertEquals(20518, session.origin!!.sessionId)
        assertEquals(0, session.origin!!.sessionVersion)
        assertEquals("IN", session.origin!!.netType)
        assertEquals(4, session.origin!!.ipVer)
        assertEquals("203.0.113.1", session.origin!!.address,)

        assertEquals(4, session.connection!!.version)
        assertEquals("203.0.113.1",session.connection!!.ip)

        assertEquals("F7gI", session.iceUfrag!!.value)
        assertEquals("x9cml/YzichV2+XlhiMu8g", session.icePwd!!.value)

        assertEquals("audio", session.media[0].mline!!.type)
        assertEquals(54400, session.media[0].mline!!.port)

        assertEquals("video", session.media[1].mline!!.type)
        assertEquals(55400, session.media[1].mline!!.port)

        session.write()
    }

    @Test fun testComposeAlacSdp() = testCompose("alac")
    @Test fun testComposeBfcpSdp() = testCompose("bfcp")
    @Test fun testComposeDanteSdp() = testCompose("dante-aes67")
    @Test fun testComposeExtmapEncryptSdp() = testCompose("extmap-encrypt")
    // @Test fun testComposeHackySdp() = testCompose("hacky") ptime:0.125 not parsed correctly
    @Test fun testComposeIceLiteSdp() = testCompose("icelite")
    @Test fun testComposeInvalidSdp() = testCompose("invalid")
    @Test fun testComposeJsepSdp() = testCompose("jsep")
    @Test fun testComposeJssipSdp() = testCompose("jssip")
    @Test fun testComposeMediaclkAvbtpSdp() = testCompose("mediaclk-avbtp")
    @Test fun testComposeMediaclkPtpV2Sdp() = testCompose("mediaclk-ptp-v2")
    @Test fun testComposeMediaclkPtpV2WRateSdp() = testCompose("mediaclk-ptp-v2-w-rate")
    @Test fun testComposeNormalSdp() = testCompose("normal")
    @Test fun testComposeOnvifSdp() = testCompose("onvif")
    @Test fun testComposeRtcpFbSdp() = testCompose("rtcp-fb")
    @Test fun testComposeSctpDtls26Sdp() = testCompose("sctp-dtls-26")
    @Test fun testComposeSimulcastSdp() = testCompose("simulcast")
    @Test fun testComposeSsrcSdp() = testCompose("ssrc")
    @Test fun testComposeSt20226Sdp() = testCompose("st2022-6")
    @Test fun testComposeSt211020Sdp() = testCompose("st2110-20")
    @Test fun testComposeTcpActiveSdp() = testCompose("tcp-active")
    @Test fun testComposeTcpPassiveSdp() = testCompose("tcp-passive")
    @Test fun testComposeTsRefClkMediaSdp() = testCompose("ts-refclk-media")
    @Test fun testComposesRefClkSessSdp() = testCompose("ts-refclk-sess")

    private fun testCompose(name: String) {
        val sdp = javaClass.getResource("/${name}.sdp").readText()
        val session1 = SdpParser.parse(sdp)
        val session2 = SdpParser.parse(session1.write())

        assertEquals(session1, session2);
    }
}
