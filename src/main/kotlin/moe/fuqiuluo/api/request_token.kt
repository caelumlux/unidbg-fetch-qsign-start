@file:Suppress("UNCHECKED_CAST")
package moe.fuqiuluo.api

import com.tencent.mobileqq.channel.SsoPacket
import com.tencent.mobileqq.sign.QQSecuritySign
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.sync.Mutex
import moe.fuqiuluo.ext.fetchGet

fun Routing.requestToken() {
    get("/request_token") {
        val uin = fetchGet("uin")!!.toLong()
        val session = findSession(uin)
        val isForced = fetchGet("force", def = "false")

        val vm = session.vm

        if ("HAS_SUBMIT" !in vm.global && isForced == "false") {
            call.respond(APIResult(-1, "QSign not initialized, unable to request_token, please submit the initialization package first.", ""))
        } else {
            val isSuccessful = true
            val list = arrayListOf<SsoPacket>()
            session.withRuntime {
                val lock = vm.global["mutex"] as Mutex
                lock.tryLock()
                QQSecuritySign.requestToken(vm)
            }
            call.respond(APIResult(if (!isSuccessful) -1 else 0, if (!isSuccessful) "request_token timeout" else "submit success", list))
        }
    }
}