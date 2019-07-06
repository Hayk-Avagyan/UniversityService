import java.util.Comparator;

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
        return "\nUniversity = " + catalog.getName() + "\nFull Name = " + fullName + "\nCost Of Education = " + costOfEducation + "\nTerm Of Study = " + termOfStudy;
    }
}
