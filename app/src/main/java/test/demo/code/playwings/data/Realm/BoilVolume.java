package test.demo.code.playwings.data.Realm;

import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class BoilVolume extends RealmObject {


    @RealmField(name = "value")
    private String value;
    @RealmField(name = "unit")
    private String unit;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
