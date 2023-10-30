package moe.fuqiuluo.unidbg.env.files

fun fetchCpuInfo(): ByteArray {
    return """
        processor	: 0
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x0
        CPU part	: 0xd46
        CPU revision	: 3

        processor	: 1
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x0
        CPU part	: 0xd46
        CPU revision	: 3

        processor	: 2
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x0
        CPU part	: 0xd46
        CPU revision	: 3

        processor	: 3
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x0
        CPU part	: 0xd46
        CPU revision	: 3

        processor	: 4
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x2
        CPU part	: 0xd47
        CPU revision	: 0

        processor	: 5
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x2
        CPU part	: 0xd47
        CPU revision	: 0

        processor	: 6
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x2
        CPU part	: 0xd47
        CPU revision	: 0

        processor	: 7
        BogoMIPS	: 38.40
        Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm jscvt fcma lrcpc dcpop sha3 sm3 sm4 asimddp sha512 asimdfhm dit uscat ilrcpc flagm ssbs sb paca pacg dcpodp flagm2 frint i8mm bti
        CPU implementer	: 0x41
        CPU architecture: 8
        CPU variant	: 0x2
        CPU part	: 0xd48
        CPU revision	: 0

    """.trimIndent().toByteArray()
}