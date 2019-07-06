import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administration administration = new Administration();
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner, administration);

    }

    private static void showMenu(Scanner scanner, Administration administration) {
        System.out.println("1. Add new student.     2. Show universities list.     3.Sorting");
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
            case 3:
                if (administration.getUniversities().isEmpty()) {
                    System.out.println("Your list is empty, so it makes no sense to sort the void :)");
                } else {
                   listSorting(scanner, administration);
                }
                default:
                    showMenu(scanner, administration);
                    break;
        }

    }

    private static void listSorting(Scanner scanner, Administration administration) {
        System.out.println("\n1.Sorting by university \n2.Sorting by Name \n3.Sorting by cost of education \n4.Sorting by term of study");
        int index = scanner.nextInt();
        switch (index) {
            case 1:
                CompareUniversity compareUniversity = new CompareUniversity();
                Collections.sort(administration.getUniversities(), compareUniversity);
                break;
            case 2:
                CompareName compareName = new CompareName();
                Collections.sort(administration.getUniversities(), compareName);
                break;
            case 3:
                CompareCostOfEducation compareCostOfEducation = new CompareCostOfEducation();
                Collections.sort(administration.getUniversities(), compareCostOfEducation);
                break;
            case 4:
                CompareTermOfStudy compareTermOfStudy = new CompareTermOfStudy();
                Collections.sort(administration.getUniversities(), compareTermOfStudy);
                break;
            default:
                showMenu(scanner, administration);
                break;
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

        System.out.println("Input full name");
        String fullName = scanner.next();

        scanner.nextLine();

        System.out.println("Input cost of education");
        int costOfEducation = scanner.nextInt();

        System.out.println("Input term of study");
        int termOfStudy = scanner.nextInt();

        System.out.println("Thanks, new student added to the list");

        University university = new University(universitiesCatalog, fullName, costOfEducation, termOfStudy);

        administration.addUniversity(university);
        showMenu(scanner, administration);

    }

    private static UniversitiesCatalog chooseUniversityMenu(Scanner scanner) {
        System.out.println("Choose university");
        System.out.println("1. EPH  \n2. POLITEXNIK   \n3. BJSHKAKAN   \n4. TNTESAGITAKAN   \n5. MANKAVARJAKAN   \n6. KONSERVATORIA   \n7. AMERIKYAN   \n8. SLAVONAKAN");

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
