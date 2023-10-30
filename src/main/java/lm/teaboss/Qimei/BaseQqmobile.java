package lm.teaboss.Qimei;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;
import java.util.Date;

public abstract class BaseQqmobile<M extends BaseQqmobile<M>> extends Model<M> implements IBean {
    public BaseQqmobile() {
    }
    public void setImei(String imei) {
        this.set("imei", imei);
    }

    public String getImei() {
        return this.getStr("imei");
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
    
    public void setReleasekeys(String releasekeys) {
        this.set("releasekeys", releasekeys);
    }

    public String getReleasekeys() {
        return this.getStr("releasekeys");
    }

    public void setGuid(String guid) {
        this.set("guid", guid);
    }

    public String getGuid() {
        return this.getStr("guid");
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
    
}
