package test.demo.code.playwings.data.Realm;

import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class Fermentation extends RealmObject {


        @RealmField(name = "temp")
        private Temp_ temp;

        public Temp_ getTemp() {
            return temp;
        }

        public void setTemp(Temp_ temp) {
            this.temp = temp;
        }



}
