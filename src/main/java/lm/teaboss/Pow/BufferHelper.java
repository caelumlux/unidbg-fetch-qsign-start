package lm.teaboss.Pow;
import lm.teaboss.Pow.Converts;
import lm.teaboss.Pow.Tlv;
import org.apache.commons.lang.ArrayUtils;

public class BufferHelper {
    private byte[] buffer;

    public BufferHelper(byte[] buffer) {
        this.buffer = buffer;
    }

    public byte[] getArray(int length) {
        return this.getArray(length, true);
    }

    public byte[] getArrayStay(int length) {
        return this.getArray(length, false);
    }

    public int restSize() {
        return this.buffer.length;
    }

    public byte[] getArray(int length, boolean delete) {
        byte[] dest = ArrayUtils.subarray(this.buffer, 0, length);
        if (delete) {
            this.removeHasRead(dest.length);
        }

        return dest;
    }

    public byte[] getArrayStay(int length, boolean delete) {
        byte[] dest = ArrayUtils.subarray(this.buffer, 0, length);
        if (delete) {
            this.removeHasRead(dest.length);
        }

        return dest;
    }

    public byte[] getArray(int start, int length) {
        byte[] dest = ArrayUtils.subarray(this.buffer, start, length + start);
        return dest;
    }

    public void removeHasRead(int length) {
        for(int i = 0; i < length; ++i) {
            this.buffer = ArrayUtils.remove(this.buffer, 0);
        }

    }

    public Long getLong4() {
        return Converts.bytesToNum(this.getArray(4));
    }

    public Long getLong4Stay() {
        return Converts.bytesToNum(this.getArrayStay(4));
    }

    public Integer getInt4() {
        return (int)Converts.bytesToNum(this.getArray(4));
    }

    public Integer getInt4Stay() {
        return (int)Converts.bytesToNum(this.getArrayStay(4));
    }

    public byte getByte() {
        return this.getArray(1)[0];
    }

    public byte getByteStay() {
        return this.getArrayStay(1)[0];
    }

    public Short getShort() {
        return (short)((int)Converts.bytesToNum(this.getArray(2)));
    }

    public Short getShortStay() {
        return (short)((int)Converts.bytesToNum(this.getArrayStay(2)));
    }

    public Integer getInt2() {
        return (int)Converts.bytesToNum(this.getArray(2));
    }

    public Integer getInt2Stay() {
        return (int)Converts.bytesToNum(this.getArrayStay(2));
    }

    public Integer getInt1() {
        return (int)Converts.bytesToNum(this.getArray(1));
    }

    public Integer getInt1Stay() {
        return (int)Converts.bytesToNum(this.getArrayStay(1));
    }

    public Integer getInt(int length) {
        return (int)Converts.bytesToNum(this.getArray(length));
    }

    public Integer getIntStay(int length) {
        return (int)Converts.bytesToNum(this.getArrayStay(length));
    }

    public Tlv getTlv() {
        Tlv tlv = new Tlv();
        tlv.setTag(this.getString(2));
        tlv.setLength(this.getInt2());
        tlv.setValue(this.getArray(tlv.getLength()));
        return tlv;
    }

    public String getString(int length, String charset) {
        String result = "";

        try {
            result = new String(this.getArray(length), charset);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

    public String getString(int length) {
        return this.getString(length, "UTF8");
    }

    public String getIP() {
        return (this.getArray(1)[0] & 255) + "." + (this.getArray(1)[0] & 255) + "." + (this.getArray(1)[0] & 255) + "." + (this.getArray(1)[0] & 255);
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }
}