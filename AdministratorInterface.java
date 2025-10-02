import java.util.*;

// Student class
class Student {
    private String name;
    private String studentId;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Map<Course, Double> grades = new HashMap<>();

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }

    public boolean enrollInCourse(Course course) {
        if (course.enrollStudent()) {
            enrolledCourses.add(course);
            return true;
        }
        return false;
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            grades.put(course, grade);
        }
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }
}

// Course class
class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledCount = 0;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
    }

    public String getCourseName() { return courseName; }

    public boolean enrollStudent() {
        if (enrolledCount < maxCapacity) {
            enrolledCount++;
            totalEnrolledStudents++;
            return true;
        }
        return false;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}

// CourseManagement class
class CourseManagement {
    private static List<Course> courseList = new ArrayList<>();

    public static void addCourse(String code, String name, int capacity) {
        courseList.add(new Course(code, name, capacity));
    }

    public static List<Course> getCourses() {
        return courseList;
    }

    public static boolean enrollStudent(Student student, Course course) {
        return student.enrollInCourse(course);
    }

    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    public static double calculateOverallGrade(Student student) {
        Map<Course, Double> grades = student.getGrades();
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }
}

// Main class with CLI
public class AdministratorInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- UOpeople Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Enroll Student");
            System.out.println("4. Assign Grade");
            System.out.println("5. Calculate Overall Grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> addStudent();
                case 3 -> enrollStudent();
                case 4 -> assignGrade();
                case 5 -> calculateGrade();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addCourse() {
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Max Capacity: ");
        int capacity = scanner.nextInt();
        CourseManagement.addCourse(code, name, capacity);
        System.out.println("Course added.");
    }

    private static void addStudent() {
        System.out.print("Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        students.add(new Student(name, id));
        System.out.println("Student added.");
    }

    private static void enrollStudent() {
        Student student = selectStudent();
        Course course = selectCourse();
        if (CourseManagement.enrollStudent(student, course)) {
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Course is full.");
        }
    }

    private static void assignGrade() {
        Student student = selectStudent();
        Course course = selectCourse();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        CourseManagement.assignGrade(student, course, grade);
        System.out.println("Grade assigned.");
    }

    private static void calculateGrade() {
        Student student = selectStudent();
        double overall = CourseManagement.calculateOverallGrade(student);
        System.out.println("Overall Grade: " + overall);
    }

    private static Student selectStudent() {
        System.out.println("Select Student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". " + students.get(i).getName());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        return students.get(index);
    }

    private static Course selectCourse() {
        List<Course> courses = CourseManagement.getCourses();
        System.out.println("Select Course:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ". " + courses.get(i).getCourseName());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        return courses.get(index);
    }
}
