package test.demo.code.playwings.data.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GsBeers {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("first_brewed")
    @Expose
    private String firstBrewed;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("abv")
    @Expose
    private double abv;
    @SerializedName("ibu")
    @Expose
    private double ibu;
    @SerializedName("target_fg")
    @Expose
    private double targetFg;
    @SerializedName("target_og")
    @Expose
    private double targetOg;
    @SerializedName("ebc")
    @Expose
    private double ebc;
    @SerializedName("srm")
    @Expose
    private double srm;
    @SerializedName("ph")
    @Expose
    private double ph;
    @SerializedName("attenuation_level")
    @Expose
    private double attenuationLevel;
    @SerializedName("volume")
    @Expose
    private Volume volume;
    @SerializedName("boil_volume")
    @Expose
    private BoilVolume boilVolume;
    @SerializedName("method")
    @Expose
    private Method method;
    @SerializedName("ingredients")
    @Expose
    private Ingredients ingredients;
    @SerializedName("food_pairing")
    @Expose
    private List<String> foodPairing = null;
    @SerializedName("brewers_tips")
    @Expose
    private String brewersTips;
    @SerializedName("contributed_by")
    @Expose
    private String contributedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public double getIbu() {
        return ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public double getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(double targetFg) {
        this.targetFg = targetFg;
    }

    public double getTargetOg() {
        return targetOg;
    }

    public void setTargetOg(double targetOg) {
        this.targetOg = targetOg;
    }

    public double getEbc() {
        return ebc;
    }

    public void setEbc(double ebc) {
        this.ebc = ebc;
    }

    public double getSrm() {
        return srm;
    }

    public void setSrm(double srm) {
        this.srm = srm;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAttenuationLevel() {
        return attenuationLevel;
    }

    public void setAttenuationLevel(double attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public BoilVolume getBoilVolume() {
        return boilVolume;
    }

    public void setBoilVolume(BoilVolume boilVolume) {
        this.boilVolume = boilVolume;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(List<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

    public String getBrewersTips() {
        return brewersTips;
    }

    public void setBrewersTips(String brewersTips) {
        this.brewersTips = brewersTips;
    }

    public String getContributedBy() {
        return contributedBy;
    }

    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }

    public class Amount {

        @SerializedName("value")
        @Expose
        private double value;
        @SerializedName("unit")
        @Expose
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }

    public class Amount_ {

        @SerializedName("value")
        @Expose
        private double value;
        @SerializedName("unit")
        @Expose
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }

    public class BoilVolume {

        @SerializedName("value")
        @Expose
        private double value;
        @SerializedName("unit")
        @Expose
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }

    public class Fermentation {

        @SerializedName("temp")
        @Expose
        private Temp_ temp;

        public Temp_ getTemp() {
            return temp;
        }

        public void setTemp(Temp_ temp) {
            this.temp = temp;
        }

    }

    public class Hop {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("amount")
        @Expose
        private Amount_ amount;
        @SerializedName("add")
        @Expose
        private String add;
        @SerializedName("attribute")
        @Expose
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

    public class Ingredients {

        @SerializedName("malt")
        @Expose
        private List<Malt> malt = null;
        @SerializedName("hops")
        @Expose
        private List<Hop> hops = null;
        @SerializedName("yeast")
        @Expose
        private String yeast;

        public List<Malt> getMalt() {
            return malt;
        }

        public void setMalt(List<Malt> malt) {
            this.malt = malt;
        }

        public List<Hop> getHops() {
            return hops;
        }

        public void setHops(List<Hop> hops) {
            this.hops = hops;
        }

        public String getYeast() {
            return yeast;
        }

        public void setYeast(String yeast) {
            this.yeast = yeast;
        }
    }

    public class Malt {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("amount")
        @Expose
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

    public class MashTemp {

        @SerializedName("temp")
        @Expose
        private Temp temp;
        @SerializedName("duration")
        @Expose
        private double duration;

        public Temp getTemp() {
            return temp;
        }

        public void setTemp(Temp temp) {
            this.temp = temp;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

    }

    public class Method {

        @SerializedName("mash_temp")
        @Expose
        private List<MashTemp> mashTemp = null;
        @SerializedName("fermentation")
        @Expose
        private Fermentation fermentation;
        @SerializedName("twist")
        @Expose
        private Object twist;

        public List<MashTemp> getMashTemp() {
            return mashTemp;
        }

        public void setMashTemp(List<MashTemp> mashTemp) {
            this.mashTemp = mashTemp;
        }

        public Fermentation getFermentation() {
            return fermentation;
        }

        public void setFermentation(Fermentation fermentation) {
            this.fermentation = fermentation;
        }

        public Object getTwist() {
            return twist;
        }

        public void setTwist(Object twist) {
            this.twist = twist;
        }

    }

    public class Temp {

        @SerializedName("value")
        @Expose
        private double value;
        @SerializedName("unit")
        @Expose
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }

    public class Temp_ {

        @SerializedName("value")
        @Expose
        private double value;
        @SerializedName("unit")
        @Expose
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }

    public class Volume {

        @SerializedName("value")
        @Expose
        private double value;
        @SerializedName("unit")
        @Expose
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }
}

