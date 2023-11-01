package lm.teaboss
import CONFIG
import com.tencent.mobileqq.qsec.qsecurity.QSec
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import lm.teaboss.Pow.Pow
import lm.teaboss.Qimei.Method
import moe.fuqiuluo.api.*
import moe.fuqiuluo.comm.EnvData
import moe.fuqiuluo.ext.fetchGet
import moe.fuqiuluo.ext.hex2ByteArray
import moe.fuqiuluo.ext.toHexString
import moe.fuqiuluo.unidbg.session.SessionManager
import oicq.wtlogin_sdk.pow.ClientPow


fun Routing.Pow() {
    get("/getTestData") {
        val uin = fetchGet("uin")!!.toLong()
        val session = initSession(uin) ?: run {
            val androidId = fetchGet("android_id", def = "")
            val guid = fetchGet("guid", def = "")
            if (androidId.isNullOrEmpty() || guid.isNullOrEmpty()) {
                throw MissingKeyError
            }
            SessionManager.register(EnvData(uin, androidId, guid.lowercase(), "", CONFIG.protocol.qua, CONFIG.protocol.version, CONFIG.protocol.code))
            findSession(uin)
        }
        val sign = session.withRuntime {
            ClientPow.getTestData(session.vm)
        }

        if (sign == null) {
            call.respond(APIResult(-1, "failed", null))
        } else {
            call.respond(APIResult(0, "success", sign.toHexString()))
        }
    }
    get("/getPow") {
        val tlv546 = fetchGet("tlv546")!!.hex2ByteArray()
        val sign=Pow.calcPow(tlv546)
        if (sign == null) {
            call.respond(APIResult(-1, "failed", null))
        } else {
            call.respond(APIResult(0, "success", sign.toHexString()))
        }
    }
    get("/getQimei"){
        val imei = fetchGet("imei", def = "")
        val androidId = fetchGet("androidid", def = "")
        val guid = fetchGet("guid",def="")
        if (androidId.isNullOrEmpty() || imei.isNullOrEmpty() || guid.isNullOrEmpty()) {
            call.respond(APIResult(-1, "failed", "imei或androidId或GUID为空"))
        }
        val result = Method.getQimei(imei, androidId, guid, "8.9.88")
        call.respond(APIResult(0, "success", result))
    }
    get("/getXwDebugID") {
        val uin = fetchGet("uin")!!.toLong()
        val session = initSession(uin) ?: run {
            val androidId = fetchGet("android_id", def = "")
            val guid = fetchGet("guid", def = "")
            if (androidId.isNullOrEmpty() || guid.isNullOrEmpty()) {
                throw MissingKeyError
            }
            SessionManager.register(EnvData(uin, androidId, guid.lowercase(), "", CONFIG.protocol.qua, CONFIG.protocol.version, CONFIG.protocol.code))
            findSession(uin)
        }
        val sign = session.withRuntime {
            QSec.getXwdbugID(session.vm,uin.toString())
        }

        if (sign == null) {
            call.respond(APIResult(-1, "failed", null))
        } else {
            call.respond(APIResult(0, "success", sign.toHexString()))
        }
        ///call.respond(APIResult(114514,"因为是上报包所以固定真机啦","055300960A93010A9001413438443136373245463337343030304643364337353932463632323845354546444542323634423846324335424441393339333439303234383239463441364346424533413845393932313143334142333941313031364536453438314338333746413343313536433837363831304243434441354346413939423046363534453034363239454537433842304346"))
    }
}
