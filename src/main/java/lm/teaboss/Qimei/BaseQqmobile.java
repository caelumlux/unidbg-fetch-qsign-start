package lm.teaboss.Qimei;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;
import java.util.Date;

public abstract class BaseQqmobile<M extends BaseQqmobile<M>> extends Model<M> implements IBean {
    public BaseQqmobile() {
    }

    public void setId(Integer id) {
        this.set("id", id);
    }

    public Integer getId() {
        return this.getInt("id");
    }

    public void setImei(String imei) {
        this.set("imei", imei);
    }

    public String getImei() {
        return this.getStr("imei");
    }

    public void setImsi(String imsi) {
        this.set("imsi", imsi);
    }

    public String getImsi() {
        return this.getStr("imsi");
    }

    public void setSsid(String ssid) {
        this.set("ssid", ssid);
    }

    public String getSsid() {
        return this.getStr("ssid");
    }

    public void setBssid(String bssid) {
        this.set("bssid", bssid);
    }

    public String getBssid() {
        return this.getStr("bssid");
    }

    public void setAndroidid(String androidid) {
        this.set("androidid", androidid);
    }

    public String getAndroidid() {
        return this.getStr("androidid");
    }

    public void setAndroidver(String androidver) {
        this.set("androidver", androidver);
    }

    public String getAndroidver() {
        return this.getStr("androidver");
    }

    public void setLinuxandgcc(String linuxandgcc) {
        this.set("linuxandgcc", linuxandgcc);
    }

    public String getLinuxandgcc() {
        return this.getStr("linuxandgcc");
    }

    public void setReleasekeys(String releasekeys) {
        this.set("releasekeys", releasekeys);
    }

    public String getReleasekeys() {
        return this.getStr("releasekeys");
    }

    public void setUuid(String uuid) {
        this.set("uuid", uuid);
    }

    public String getUuid() {
        return this.getStr("uuid");
    }

    public void setRelseinfra(String relseinfra) {
        this.set("relseinfra", relseinfra);
    }

    public String getRelseinfra() {
        return this.getStr("relseinfra");
    }

    public void setMac(String mac) {
        this.set("mac", mac);
    }

    public String getMac() {
        return this.getStr("mac");
    }

    public void setGuid(String guid) {
        this.set("guid", guid);
    }

    public String getGuid() {
        return this.getStr("guid");
    }

    public void setBasemodel(String basemodel) {
        this.set("basemodel", basemodel);
    }

    public String getBasemodel() {
        return this.getStr("basemodel");
    }

    public void setModel(String model) {
        this.set("model", model);
    }

    public String getModel() {
        return this.getStr("model");
    }

    public void setBrand(String brand) {
        this.set("brand", brand);
    }

    public String getBrand() {
        return this.getStr("brand");
    }

    public void setCreatetime(Date createtime) {
        this.set("createtime", createtime);
    }

    public Date getCreatetime() {
        return (Date)this.get("createtime");
    }

    public void setQ16(String q16) {
        this.set("q16", q16);
    }

    public String getQ16() {
        return this.getStr("q16");
    }

    public void setQ36(String q36) {
        this.set("q36", q36);
    }

    public String getQ36() {
        return this.getStr("q36");
    }
}
