package moe.fuqiuluo.api

import CONFIG
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import moe.fuqiuluo.comm.Protocol
import java.lang.management.ManagementFactory

@Serializable
data class APIResult<T>(
    val code: Int,
    val msg: String = "",
    @Contextual
    val data: T? = null
)

@Serializable
data class APIInfo(
    val version: String,
    val protocol: Protocol,
    val pid: Int,
    val getPow: String,
    val getTestData: String,
    val getQimei: String,
    val getXwDebugID: String,
    val sign:String,
    val energy:String
)

object BuildConfig {
    var version = "1.2.3"
}

fun Routing.index() {
    get("/") {
        call.respond(APIResult(0, "IAA 云天明 章北海", APIInfo(
            version = BuildConfig.version,
            protocol = CONFIG.protocol,
            pid = runCatching{ ManagementFactory.getRuntimeMXBean().name.split("@")[0].toInt() }.getOrNull() ?: -1,
            getPow = "/getPow?tlv546=token_tlv546",
            getTestData = "/getTestData?uin=[uin]&guid=[guid]&android_id=[android_id]",
            getQimei = "/getQimei?imei=[imei]&androidId=[android_id]&guid=[guid]",
            getXwDebugID = "/getxwDebugID",
            sign="/sign?uin=[UIN]&qua=[QUA]&cmd=[CMD]&seq=[SEQ]&buffer=[BUFFER]",
            energy = "/energy?version=[VERSION]&uin=[UIN]&guid=[GUID]&data=[DATA]"
        )))
    }
}
