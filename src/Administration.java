import java.util.ArrayList;

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
