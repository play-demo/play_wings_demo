package test.demo.code.playwings.data.Realm;

import io.realm.RealmObject;
import io.realm.annotations.RealmField;

public class Hop extends RealmObject {

        @RealmField(name = "name")
        private String name;
        @RealmField(name = "amount")
        private Amount_ amount;
        @RealmField(name = "add")
        private String add;
        @RealmField(name = "attribute")
        private String attribute;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Amount_ getAmount() {
            return amount;
        }

        public void setAmount(Amount_ amount) {
            this.amount = amount;
        }

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }


}
