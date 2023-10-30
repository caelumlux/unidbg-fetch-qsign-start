package lm.teaboss.Pow;

import lm.teaboss.Pow.ByteUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

public final class Converts {
    public static final char[] BToA = "0123456789abcdef".toCharArray();

    private Converts() {
    }

    public static byte[] getBytesByDate(String date) {
        String[] array = date.split("-");
        byte[] year = numTo2Bytes(Integer.parseInt(array[0]));
        byte[] month = numTo1Bytes(Integer.parseInt(array[1]));
        byte[] day = numTo1Bytes(Integer.parseInt(array[2]));
        return ByteUtil.merger(ByteUtil.merger(year, month), day);
    }

    public static byte[] getPWDKey(String qq, byte[] pwdmd5) {
        try {
            ByteArrayOutputStream bsofpwd = new ByteArrayOutputStream();
            bsofpwd.write(pwdmd5);
            bsofpwd.write(new byte[4]);
            bsofpwd.write(longTo4Bytes(Long.valueOf(qq)));
            byte[] pwdkey = MD5Encode(bsofpwd.toByteArray());
            return pwdkey;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static byte[] MD5Pwd(String pwd) {
        return hexStringToByte(pwd);
    }

    public static byte[] hexStringToByte(String hex) {
        hex = hex.replace(" ", "");
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }

        int len = hex.length() / 2;
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();

        for(int i = 0; i < len; ++i) {
            int pos = i * 2;
            result[i] = (byte)(toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }

        return result;
    }

    public static byte[] numTo1Bytes(Integer num) {
        String uinHex;
        for(uinHex = Integer.toHexString(num); uinHex.length() < 2; uinHex = "0" + uinHex) {
        }

        return hexStringToByte(uinHex.toUpperCase());
    }

    public static byte[] numTo2Bytes(Integer num) {
        String uinHex;
        for(uinHex = Integer.toHexString(num); uinHex.length() < 4; uinHex = "0" + uinHex) {
        }

        return hexStringToByte(uinHex.toUpperCase());
    }

    public static byte[] shortToBytes(short s) {
        byte[] targets = new byte[2];

        for(int i = 0; i < 2; ++i) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte)(s >>> offset & 255);
        }

        return targets;
    }

    public static byte[] intToBytes(int num) {
        byte[] bytes = new byte[]{(byte)(num >>> 24), (byte)(num >>> 16), (byte)(num >>> 8), (byte)num};
        return bytes;
    }

    public static byte[] longTo4Bytes(Long num) {
        String uinHex;
        for(uinHex = Long.toHexString(num); uinHex.length() < 8; uinHex = "0" + uinHex) {
        }

        return hexStringToByte(uinHex.toUpperCase());
    }

    public static byte[] longToBytes(long values) {
        byte[] buffer = new byte[8];

        for(int i = 0; i < 8; ++i) {
            int offset = 64 - (i + 1) * 8;
            buffer[i] = (byte)((int)(values >> offset & 255L));
        }

        return buffer;
    }

    public static long bytesToLong(byte[] buffer) {
        long values = 0L;

        for(int i = 0; i < 8; ++i) {
            values <<= 8;
            values |= (long)(buffer[i] & 255);
        }

        return values;
    }

    public static long bytesToNum(byte[] b) {
        long temp = 0L;
        long res = 0L;

        for(int i = 0; i < b.length; ++i) {
            res <<= 8;
            temp = (long)(b[i] & 255);
            res |= temp;
        }

        return res;
    }

    public static long java_long_to_cpp_unsigned_long(long a) {
        return ((long)((int)a) + 4294967296L) % 4294967296L;
    }

    private static byte toByte(char c) {
        byte b = (byte)"0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);

        for(int i = 0; i < bArray.length; ++i) {
            String sTemp = Integer.toHexString(255 & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }

            sb.append(sTemp.toUpperCase());
        }

        return sb.toString();
    }

    public static final String printBytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return " null bArray";
        } else {
            String byteStr = bytesToHexString(bArray);
            StringBuffer temp = new StringBuffer();

            for(int i = 0; i < byteStr.length(); ++i) {
                if (i != 0 && i % 2 == 0) {
                    temp.append(" " + byteStr.charAt(i));
                } else {
                    temp.append(byteStr.charAt(i));
                }
            }

            return temp.toString();
        }
    }

    public static final Object bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream oi = new ObjectInputStream(in);
        Object o = oi.readObject();
        oi.close();
        return o;
    }

    public static final byte[] objectToBytes(Serializable s) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream ot = new ObjectOutputStream(out);
        ot.writeObject(s);
        ot.flush();
        ot.close();
        return out.toByteArray();
    }

    public static final String objectToHexString(Serializable s) throws IOException {
        return bytesToHexString(objectToBytes(s));
    }

    public static final Object hexStringToObject(String hex) throws IOException, ClassNotFoundException {
        return bytesToObject(hexStringToByte(hex));
    }

    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);

        for(int i = 0; i < bytes.length; ++i) {
            temp.append((byte)((bytes[i] & 240) >>> 4));
            temp.append((byte)(bytes[i] & 15));
        }

        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
    }

    public static byte[] str2Bcd(String asc) {
        int len = asc.length();
        int mod = len % 2;
        if (mod != 0) {
            asc = "0" + asc;
            len = asc.length();
        }

        byte[] abt = new byte[len];
        if (len >= 2) {
            len /= 2;
        }

        byte[] bbt = new byte[len];
        abt = asc.getBytes();

        for(int p = 0; p < asc.length() / 2; ++p) {
            int j;
            if (abt[2 * p] >= 48 && abt[2 * p] <= 57) {
                j = abt[2 * p] - 48;
            } else if (abt[2 * p] >= 97 && abt[2 * p] <= 122) {
                j = abt[2 * p] - 97 + 10;
            } else {
                j = abt[2 * p] - 65 + 10;
            }

            int k;
            if (abt[2 * p + 1] >= 48 && abt[2 * p + 1] <= 57) {
                k = abt[2 * p + 1] - 48;
            } else if (abt[2 * p + 1] >= 97 && abt[2 * p + 1] <= 122) {
                k = abt[2 * p + 1] - 97 + 10;
            } else {
                k = abt[2 * p + 1] - 65 + 10;
            }

            int a = (j << 4) + k;
            byte b = (byte)a;
            bbt[p] = b;
        }

        return bbt;
    }

    public static String BCD2ASC(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);

        for(int i = 0; i < bytes.length; ++i) {
            int h = (bytes[i] & 240) >>> 4;
            int l = bytes[i] & 15;
            temp.append(BToA[h]).append(BToA[l]);
        }

        return temp.toString();
    }

    public static String MD5EncodeToHex(String origin) {
        return bytesToHexString(MD5Encode(origin));
    }

    public static byte[] MD5Encode(String origin) {
        return MD5Encode(origin.getBytes());
    }

    public static byte[] MD5Encode(byte[] bytes) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
            return md.digest(bytes);
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
            return new byte[0];
        }
    }

    public static String getIP(byte[] ips) {
        return (ips[0] & 255) + "." + (ips[1] & 255) + "." + (ips[2] & 255) + "." + (ips[3] & 255);
    }

    public static void main(String[] args) {
        CRC32 crc = new CRC32();
        crc.reset();
        crc.update(hexStringToByte("02 36 13 03 19 20 EB B9 D1 4B 03 04 01 00 00 01 01 01 00 00 67 77"));
        System.out.println(printBytesToHexString(longTo4Bytes(crc.getValue())));
        System.out.println(printBytesToHexString(longTo4Bytes(System.currentTimeMillis())));
    }
}