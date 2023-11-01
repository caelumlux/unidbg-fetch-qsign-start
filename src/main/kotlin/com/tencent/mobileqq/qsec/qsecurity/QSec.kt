package com.tencent.mobileqq.qsec.qsecurity

import com.github.unidbg.linux.android.dvm.BaseVM
import com.github.unidbg.linux.android.dvm.DvmObject
import com.github.unidbg.linux.android.dvm.array.ByteArray
import moe.fuqiuluo.unidbg.QSecVM

object QSec {
    fun doSomething(vm: QSecVM, context: DvmObject<*>) {
        vm.newInstance("com/tencent/mobileqq/qsec/qsecurity/QSec", unique = true)
            .callJniMethodInt(vm.emulator, "doSomething(Landroid/content/Context;I)I", context, 1)
    }

    fun getEst(vm: QSecVM): ByteArray? {
        val context = (vm.vm as BaseVM).resolveClass("android/content/Context", vm.vm.resolveClass("java/io/File")).newObject(null)
        return vm.newInstance("com/tencent/mobileqq/qsec/qsecest/QsecEst", unique = true)
            .callJniMethodObject(
                vm.emulator, "d(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[B",
                context, vm.envData.guid, "")
    }
    fun getXwdbugID(vm: QSecVM,QQ:String): kotlin.ByteArray {
        val context = (vm.vm as BaseVM).resolveClass("android/content/Context", vm.vm.resolveClass("java/io/File")).newObject(null)
        return vm.newInstance("com/tencent/mobileqq/qsec/qsecurity/QSec", unique = true)
            .callJniMethodObject<DvmObject<*>>(
                vm.emulator, "getXwDebugID(Ljava/lang/String;)[B",
                QQ).value as kotlin.ByteArray
    }

}
