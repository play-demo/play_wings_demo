package test.demo.code.playwings.data.Realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class Ingredients extends RealmObject {

    @RealmField(name = "malt")
    private RealmList<Malt> malt = null;
    @RealmField(name = "hops")
    private RealmList<Hop> hops = null;
    @RealmField(name = "yeast")
    private String yeast;

    public RealmList<Malt> getMalt() {
        return malt;
    }

    public void setMalt(RealmList<Malt> malt) {
        this.malt = malt;
    }

    public RealmList<Hop> getHops() {
        return hops;
    }

    public void setHops(RealmList<Hop> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
}

