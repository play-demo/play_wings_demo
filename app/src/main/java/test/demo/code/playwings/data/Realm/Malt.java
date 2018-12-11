package test.demo.code.playwings.data.Realm;

import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class Malt extends RealmObject {


        @RealmField(name = "name")
        private String name;
        @RealmField(name = "amount")
        private Amount amount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Amount getAmount() {
            return amount;
        }

        public void setAmount(Amount amount) {
            this.amount = amount;
        }


}
