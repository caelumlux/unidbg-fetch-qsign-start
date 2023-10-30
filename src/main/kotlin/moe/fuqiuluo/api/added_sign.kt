package moe.fuqiuluo.api

import CONFIG
import com.tencent.mobileqq.qsec.qsecdandelionsdk.Dandelion
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.utils.io.core.*
import moe.fuqiuluo.comm.EnvData
import moe.fuqiuluo.ext.fetchGet
import moe.fuqiuluo.ext.toByteArray
import moe.fuqiuluo.ext.toHexString
import moe.fuqiuluo.unidbg.session.SessionManager

fun Routing.addedSign() {
    get("/friend_sign") {
        val addUin = fetchGet("add_uin")!!
        val source = fetchGet("source")!!
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
            Dandelion.energy(session.vm, "add_friend", BytePacketBuilder().also {
                it.writeLong(uin)
                it.writeLong(addUin.toLong())
                it.writeInt(source.toInt())
            }.toByteArray())
        }
        if (sign == null) {
            call.respond(APIResult(-1, "failed", null))
        } else {
            call.respond(APIResult(0, "success", sign.toHexString()))
        }
    }
    get("/group_sign") {
        val addUin = fetchGet("group_uin")!!
        val source = fetchGet("source")!!
        val subsource = fetchGet("sub_source")!!
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
            Dandelion.energy(session.vm, "add_group", BytePacketBuilder().also {
                it.writeLong(uin)
                it.writeLong(addUin.toLong())
                it.writeInt(source.toInt())
                it.writeInt(subsource.toInt())
            }.toByteArray())
        }
        if (sign == null) {
            call.respond(APIResult(-1, "failed", null))
        } else {
            call.respond(APIResult(0, "success", sign.toHexString()))
        }
    }
}