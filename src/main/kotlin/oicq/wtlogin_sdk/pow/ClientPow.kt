package oicq.wtlogin_sdk.pow
import com.github.unidbg.linux.android.dvm.DvmObject
import moe.fuqiuluo.unidbg.QSecVM




object ClientPow {
    @JvmStatic
    fun getTestData(vm: QSecVM): ByteArray {
        val objpow = vm.newInstance("oicq/wlogin_sdk/pow/ClientPow", unique = true)
        return objpow.callJniMethodObject<DvmObject<*>>(vm.emulator,
            "nativeGetTestData()[B").value as ByteArray
    }
}