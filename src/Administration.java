import java.util.ArrayList;
import java.util.Comparator;

public class Administration {

    private int income;
    private ArrayList<University> universities = new ArrayList<>();

    public int getIncome() {
        return income;
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void addUniversity(University university) {
        universities.add(university);
    }

    private void receivedIncome(int costOfEducation) {
        income += costOfEducation;
    }

    public void showUniversitiesCatalog() {
        int index = 0;
        for (University university : universities) {
            System.out.println(index + " " + university.toString());
            index++;
        }

        System.out.println("current income = " + income);
    }

    public void enterTheUniversity(int index) {
        University university = universities.get(index);
        receivedIncome(university.getCostOfEducation());
        universities.remove(university);
        System.out.println("Congratulations you entered " + university.getCatalog().getName());

    }


}

class CompareUniversity implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return o1.getCatalog().compareTo(o2.getCatalog());
    }
}

class CompareName implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}

class CompareCostOfEducation implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return o1.getCostOfEducation() - o2.getCostOfEducation();
    }
}

class CompareTermOfStudy implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return o1.getTermOfStudy() - o2.getTermOfStudy();
    }
}
