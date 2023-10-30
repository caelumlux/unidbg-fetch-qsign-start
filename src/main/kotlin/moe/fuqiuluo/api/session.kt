@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.api

import CONFIG
import kotlinx.coroutines.*
import moe.fuqiuluo.unidbg.session.Session
import moe.fuqiuluo.unidbg.session.SessionManager

fun initSession(uin: Long): Session? {
    return SessionManager.get(uin) ?: if (!CONFIG.autoRegister) {
        throw SessionNotFoundError
    } else {
        null
    }
}

fun findSession(uin: Long): Session {
    return SessionManager.get(uin) ?: throw SessionNotFoundError
}

internal inline fun <T> Session.withRuntime(crossinline action: () -> T): T? {
    val t = action()
    pool.release(this)
    return t
}
