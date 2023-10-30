package lm.teaboss.Pow;
import java.io.ByteArrayOutputStream;
import java.util.Random;






public class ByteUtil
{
    public static byte[] genKey(int length) {
        byte[] rs = new byte[length];
        Random rnd = new Random();
        rnd.nextBytes(rs);
        return rs;
    }







    public static byte[] gen0x00Key(int length) {
        byte[] rs = new byte[length];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = 0;
        }
        return rs;
    }

    public static byte[] slice(byte[] src, int start) {
        int length = src.length - start;
        return slice(src, start, length);
    }

    public static byte[] slice(byte[] src, int start, int length) {
        if (src == null || src.length < start + length || length <= 0) {
            return new byte[0];
        }
        byte[] bs = new byte[length];
        for (int i = 0; i < length; i++) {
            bs[i] = src[start + i];
        }
        return bs;
    }







    public static byte[] pack(byte[] src) {
        int index = -1; int i;
        for (i = 0; i < src.length; i++) {
            if (src[i] != 0) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            byte[] rs = new byte[src.length - index];
            System.arraycopy(src, index, rs, 0, rs.length);
            src = rs;
        } else {
            return new byte[0];
        }
        index = -1;
        for (i = src.length; i > 0; i--) {
            if (src[i - 1] != 0) {
                index = i - 1;
                break;
            }
        }
        if (index > -1) {
            byte[] rs = new byte[index + 1];
            System.arraycopy(src, 0, rs, 0, rs.length);
            src = rs;
        } else {
            return new byte[0];
        }
        return src;
    }

    public static void main(String[] args) {
        System.out.println(Converts.printBytesToHexString(pack(Converts.hexStringToByte("01 00 00"))));
    }








    public static byte[] merger(byte[] bt1, byte[] bt2) {
        byte[] bt3 = new byte[bt1.length + bt2.length];
        System.arraycopy(bt1, 0, bt3, 0, bt1.length);
        System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
        return bt3;
    }







    public static byte[] reverse(byte[] src) {
        byte[] rs = new byte[src.length];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = src[src.length - 1 - i];
        }
        return rs;
    }

    public static String genHostName(int length) {
        String cs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(cs.charAt(rnd.nextInt(cs.length())));
        }
        return sb.toString();
    }







    public static boolean ipCheck(String text) {
        if (text != null && !text.isEmpty()) {

            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

            if (text.matches(regex))
            {
                return true;
            }

            return false;
        }


        return false;
    }







    public static byte[] encrypt(byte[] input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            for (int i = 0; i < input.length; i++)
            {
                int temp = (input[i] & 0xFF) + (i + 1) * 10;


                baos.write(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }







    public static byte[] decrypt(byte[] input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            for (int i = 0; i < input.length; i++) {
                int temp = input[i] - (i + 1) * 10 & 0xFF;
                baos.write(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }
}
