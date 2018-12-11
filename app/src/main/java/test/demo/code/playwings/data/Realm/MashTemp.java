package test.demo.code.playwings.data.Realm;

import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class MashTemp extends RealmObject {


    @RealmField(name = "temp")
    private Temp temp;
    @RealmField(name = "duration")
    private String duration;

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}
