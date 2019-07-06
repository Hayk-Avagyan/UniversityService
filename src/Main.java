import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administration administration = new Administration();
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner, administration);

    }

    private static void showMenu(Scanner scanner, Administration administration) {
        System.out.println("1. Add new student.     2. Show universities list");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                createNewStudent(scanner, administration);
                break;
            case 2:
                administration.showUniversitiesCatalog();
                applyToUniversity(scanner, administration);
                administration.showUniversitiesCatalog();
                break;
                default:
                    showMenu(scanner, administration);
        }

    }

    private static void applyToUniversity(Scanner scanner, Administration administration) {
        System.out.println("Choose the university you want to enroll in");
        int index = scanner.nextInt();

        if (index >= 0 && index<administration.getUniversities().size()) {
            administration.enterTheUniversity(index);
        } else {
            applyToUniversity(scanner, administration);
        }

    }

    private static void createNewStudent(Scanner scanner, Administration administration) {
        UniversitiesCatalog universitiesCatalog = chooseUniversityMenu(scanner);

        System.out.println("input full name");
        String fullName = scanner.nextLine();

        System.out.println("input cost of education");
        int costOfEducation = scanner.nextInt();

        System.out.println("input term of study");
        int termOfStudy = scanner.nextInt();

        University university = new University(universitiesCatalog, fullName, costOfEducation, termOfStudy);

        administration.addUniversity(university);
        showMenu(scanner, administration);

    }

    private static UniversitiesCatalog chooseUniversityMenu(Scanner scanner) {
        System.out.println("Choose university");
        System.out.println("1. EPH   2. POLITEXNIK   3. BJSHKAKAN   4. TNTESAGITAKAN   5. MANKAVARJAKAN   6. KONSERVATORIA   7. AMERIKYAN   8. SLAVONAKAN");

        int chooseValue = scanner.nextInt();
        UniversitiesCatalog universitiesCatalog = chooseUniversity(chooseValue);
        while (universitiesCatalog == UniversitiesCatalog.NOT_SELECTED) {
            universitiesCatalog = chooseUniversityMenu(scanner);
        }
        return universitiesCatalog;
    }

    private static UniversitiesCatalog chooseUniversity(int number) {
        switch (number) {
            case 1:
                return UniversitiesCatalog.EPH;
            case 2:
                return UniversitiesCatalog.POLITEXNIK;
            case 3:
                return UniversitiesCatalog.BJSHKAKAN;
            case 4:
                return UniversitiesCatalog.TNTESAGITAKAN;
            case 5:
                return UniversitiesCatalog.MANKAVARJAKAN;
            case 6:
                return UniversitiesCatalog.KONSERVATORIA;
            case 7:
                return UniversitiesCatalog.AMERIKYAN;
            case 8:
                return UniversitiesCatalog.SLAVONAKAN;
                default:
                    return UniversitiesCatalog.NOT_SELECTED;
        }
    }


}
