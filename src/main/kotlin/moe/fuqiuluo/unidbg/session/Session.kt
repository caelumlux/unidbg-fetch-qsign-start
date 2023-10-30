package moe.fuqiuluo.unidbg.session

import CONFIG
import BASE_PATH
import com.github.unidbg.worker.Worker
import com.github.unidbg.worker.WorkerPool
import com.tencent.mobileqq.channel.SsoPacket
import com.tencent.mobileqq.fe.FEKit
import kotlinx.coroutines.sync.Mutex
import moe.fuqiuluo.comm.EnvData
import moe.fuqiuluo.unidbg.QSecVM

class Session(
    envData: EnvData,
    val pool: WorkerPool
): Worker(pool) {
    internal val vm: QSecVM =
        QSecVM(BASE_PATH, envData, CONFIG.unidbg.dynarmic, CONFIG.unidbg.unicorn, CONFIG.unidbg.kvm)

    init {
        vm.global["PACKET"] = arrayListOf<SsoPacket>()
        vm.global["mutex"] = Mutex(true)
        vm.global["qimei36"] = envData.qimei36.lowercase()
        vm.global["guid"] = envData.guid.lowercase()
        vm.init()
        FEKit.init(vm, envData.uin.toString())
    }

    override fun destroy() {
        vm.destroy()
    }
}