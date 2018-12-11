package test.demo.code.playwings.data.Realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class Method extends RealmObject {

    @RealmField(name = "mash_temp")
    private RealmList<MashTemp> mashTemp = null;
    @RealmField(name = "fermentation")
    private Fermentation fermentation;
    @RealmField(name = "twist")
    private String twist;

    public RealmList<MashTemp> getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(RealmList<MashTemp> mashTemp) {
        this.mashTemp = mashTemp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }


}
