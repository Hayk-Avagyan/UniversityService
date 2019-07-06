public class University {

    private UniversitiesCatalog catalog;
    private String fullName;
    private int costOfEducation;
    private int termOfStudy;

    public University(UniversitiesCatalog catalog, String fullName, int costOfEducation, int termOfStudy) {
        this.catalog = catalog;
        this.fullName = fullName;
        this.costOfEducation = costOfEducation;
        this.termOfStudy = termOfStudy;
    }

    public UniversitiesCatalog getCatalog() {
        return catalog;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCostOfEducation() {
        return costOfEducation;
    }

    public int getTermOfStudy() {
        return termOfStudy;
    }

    @Override
    public String toString() {
        return "University{" +
                "catalog=" + catalog.getName() +
                ", fullName='" + fullName + '\'' +
                ", costOfEducation=" + costOfEducation +
                ", termOfStudy=" + termOfStudy +
                '}';
    }
}
