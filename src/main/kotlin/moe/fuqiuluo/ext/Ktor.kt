package moe.fuqiuluo.ext

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*
import moe.fuqiuluo.api.APIResult

suspend fun PipelineContext<Unit, ApplicationCall>.fetchGet(key: String, def: String? = null, err: String? = "Parameter '$key' is missing."): String? {
    val data = call.parameters[key] ?: def
    if (data == null && err != null) {
        failure(1, err)
    }
    return data
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPost(params: Parameters, key: String, def: String? = null, err: String? = "Parameter '$key' is missing."): String? {
    val data = params[key] ?: def
    if (data == null && err != null) {
        failure(1, err)
    }
    return data
}

suspend fun PipelineContext<Unit, ApplicationCall>.failure(code: Int, msg: String) {
    call.respond(APIResult(code, msg, "failed"))
}
