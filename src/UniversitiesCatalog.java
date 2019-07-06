public enum UniversitiesCatalog {

    EPH("EPH"),
    POLITEXNIK("POLITEXNIK"),
    BJSHKAKAN("BJSHKAKAN"),
    TNTESAGITAKAN("TNTESAGITAKAN"),
    MANKAVARJAKAN("MANKAVARJAKAN"),
    KONSERVATORIA("KONSERVATORIA"),
    AMERIKYAN("AMERIKYAN"),
    SLAVONAKAN("SLAVONAKAN"),
    NOT_SELECTED("null");

    private String name;

    UniversitiesCatalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
