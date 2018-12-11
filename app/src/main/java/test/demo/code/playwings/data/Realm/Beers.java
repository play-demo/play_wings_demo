package test.demo.code.playwings.data.Realm;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmField;

public class Beers extends RealmObject {

    @PrimaryKey
    @RealmField(name = "id")
    private int id;
    @RealmField(name = "name")
    private String name;
    @RealmField(name = "tagline")
    private String tagline;
    @RealmField(name = "first_brewed")
    private String first_brewed;
    @RealmField(name = "description")
    private String description;
    @RealmField(name = "image_url")
    private String image_url;
    @RealmField(name = "abv")
    private String abv ;
    @RealmField(name = "ibu")
    private String ibu ;
    @RealmField(name = "target_fg")
    private String target_fg ;
    @RealmField(name = "target_og")
    private String target_og ;
    @RealmField(name = "ebc")
    private String ebc ;
    @RealmField(name = "srm")
    private String srm ;
    @RealmField(name = "ph")
    private String ph;
    @RealmField(name = "attenuation_level")
    private String attenuation_level ;
    @RealmField(name = "volume")
    private Volume volume;
    @RealmField(name = "boil_volume")
    private BoilVolume boil_volume;
    @RealmField(name = "method")
    private Method method;
    @RealmField(name = "ingredients")
    private Ingredients ingredients;
    @RealmField(name = "food_pairing")
    private RealmList<String> foodPairing = null;
    @RealmField(name = "brewers_tips")
    private String brewers_tips;
    @RealmField(name = "contributed_by")
    private String contributed_by;

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
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public String getTarget_fg() {
        return target_fg;
    }

    public void setTarget_fg(String target_fg) {
        this.target_fg = target_fg;
    }

    public String getTarget_og() {
        return target_og;
    }

    public void setTarget_og(String target_og) {
        this.target_og = target_og;
    }

    public String getEbc() {
        return ebc;
    }

    public void setEbc(String ebc) {
        this.ebc = ebc;
    }

    public String getSrm() {
        return srm;
    }

    public void setSrm(String srm) {
        this.srm = srm;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getAttenuation_level() {
        return attenuation_level;
    }

    public void setAttenuation_level(String attenuation_level) {
        this.attenuation_level = attenuation_level;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public BoilVolume getBoil_volume() {
        return boil_volume;
    }

    public void setBoil_volume(BoilVolume boil_volume) {
        this.boil_volume = boil_volume;
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

    public void setFoodPairing(RealmList<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    public String getContributed_by() {
        return contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }


}

