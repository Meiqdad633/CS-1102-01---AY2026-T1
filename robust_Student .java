import java.util.Scanner;

/**
 * Student Record Management System
 * --------------------------------
 * A slightly humorous twist on managing student records.
 * Features:
 *   - Add new students
 *   - Update existing records
 *   - View student details
 * Data is stored using static arrays.
 */
public class Main {

    // -----------------------------
    // Student Data Storage
    // -----------------------------
    static final int MAX_CAPACITY = 100; // Maximum students
    static String[] studentNames = new String[MAX_CAPACITY];
    static String[] studentIDs = new String[MAX_CAPACITY];
    static int[] studentAges = new int[MAX_CAPACITY];
    static String[] studentGrades = new String[MAX_CAPACITY];
    static int studentCount = 0; // Total students

    // -----------------------------
    // Add New Student
    // -----------------------------
    public static void addStudent(String name, String id, int age, String grade) {
        if (studentCount >= MAX_CAPACITY) {
            System.out.println("Whoa! Too many students! Storage full!");
            return;
        }
        studentNames[studentCount] = name;
        studentIDs[studentCount] = id;
        studentAges[studentCount] = age;
        studentGrades[studentCount] = grade;
        studentCount++;
        System.out.println("Congrats! " + name + " has officially joined the chaos.");
    }

    // -----------------------------
    // Update Student Information
    // -----------------------------
    public static void updateStudent(String id, String newName, int newAge, String newGrade) {
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Oops! No student with ID " + id + " found. Try magic next time.");
            return;
        }
        studentNames[index] = newName;
        studentAges[index] = newAge;
        studentGrades[index] = newGrade;
        System.out.println("Info updated! " + newName + " is now officially cooler.");
    }

    // -----------------------------
    // View Student Details
    // -----------------------------
    public static void viewStudent(String id) {
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Hmm… ID " + id + " seems to have vanished into thin air.");
            return;
        }
        System.out.println("\n--- Student Profile ---");
        System.out.println("Name : " + studentNames[index]);
        System.out.println("ID   : " + studentIDs[index]);
        System.out.println("Age  : " + studentAges[index]);
        System.out.println("Grade: " + studentGrades[index]);
    }

    // -----------------------------
    // Helper: Find Student by ID
    // -----------------------------
    private static int findStudentIndex(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIDs[i].equals(id)) {
                return i;
            }
        }
        return -1; // Student not found
    }

    // -----------------------------
    // Administrator Menu Interface
    // -----------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;

        do {
            System.out.println("\n===== Welcome to Chaos Central =====");
            System.out.println("1. Add a Fresh Student");
            System.out.println("2. Update a Lucky Student's Info");
            System.out.println("3. Peek at a Student's Details");
            System.out.println("4. Escape (Exit)");
            System.out.print("Pick your destiny (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Come on, a number between 1-4! Try again: ");
                scanner.next();
            }
            menuChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (menuChoice) {
                case 1:
                    System.out.print("Student Name (don't make it weird): ");
                    String name = scanner.nextLine();
                    System.out.print("Student ID (magical digits): ");
                    String id = scanner.nextLine();
                    System.out.print("Student Age (be honest!): ");
                    int age = getIntInput(scanner);
                    System.out.print("Student Grade (A+ to F… choose wisely): ");
                    String grade = scanner.nextLine();
                    addStudent(name, id, age, grade);
                    break;

                case 2:
                    System.out.print("Enter the ID of the lucky student: ");
                    String updateID = scanner.nextLine();
                    System.out.print("New Name (because names change): ");
                    String updatedName = scanner.nextLine();
                    System.out.print("New Age (reincarnation? Nah): ");
                    int updatedAge = getIntInput(scanner);
                    System.out.print("New Grade (don't lie!): ");
                    String updatedGrade = scanner.nextLine();
                    updateStudent(updateID, updatedName, updatedAge, updatedGrade);
                    break;

                case 3:
                    System.out.print("Enter Student ID to spy on: ");
                    String viewID = scanner.nextLine();
                    viewStudent(viewID);
                    break;

                case 4:
                    System.out.println("Exiting… May your coffee stay hot. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Even computers make mistakes.");
            }
        } while (menuChoice != 4); // <-- Semicolon added here

        scanner.close();
    }

    // -----------------------------
    // Helper: Validate Integer Input
    // -----------------------------
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid number! Try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
