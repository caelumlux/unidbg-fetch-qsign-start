package lm.teaboss.Qimei;

import lm.teaboss.Pow.Converts;

public class Qqmobile extends BaseQqmobile<Qqmobile> {
    public Qqmobile() {
    }

    public byte[] getGuidBin() {
        return Converts.hexStringToByte(this.getGuid());
    }

    public String getApiLevel(String Ver) {
        String apiLevel = "23";
        switch (Ver) {
            case "9":
                apiLevel = "28";
                return apiLevel;
            case "10":
                apiLevel = "29";
                return apiLevel;
            case "11":
                apiLevel = "30";
                return apiLevel;
            case "12":
                apiLevel = "31";
                return apiLevel;
            case "13":
                apiLevel = "33";
                return apiLevel;
            case "6.0":
                apiLevel = "23";
                return apiLevel;
            case "7.0":
                apiLevel = "24";
                return apiLevel;
            case "7.1":
                apiLevel = "25";
                return apiLevel;
            case "8.0":
                apiLevel = "26";
                return apiLevel;
            case "8.1":
                apiLevel = "27";
                return apiLevel;
            case "6.0.1":
                apiLevel = "23";
                return apiLevel;
            case "7.1.1":
                apiLevel = "25";
                return apiLevel;
            case "7.1.2":
                apiLevel = "25";
                return apiLevel;
        }

        apiLevel = "28";
        return apiLevel;
    }
}
