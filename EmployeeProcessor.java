import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeProcessor {
    public static void main(String[] args) {
        // Step 1: Initialize dataset
        List<Employee> employees = Arrays.asList(
            new Employee("Ali", 28, "Engineering", 75000),
            new Employee("Sara", 35, "Marketing", 68000),
            new Employee("Reza", 42, "Finance", 82000),
            new Employee("Neda", 31, "Engineering", 77000),
            new Employee("Omid", 25, "HR", 62000)
        );

        // Step 2: Define Function to concatenate name and department
        Function<Employee, String> nameDeptConcat = emp ->
            emp.getName() + " - " + emp.getDepartment();

        // Step 3: Generate new collection using streams
        List<String> nameDeptList = employees.stream()
            .map(nameDeptConcat)
            .collect(Collectors.toList());

        System.out.println("Name and Department List:");
        nameDeptList.forEach(System.out::println);

        // Step 4: Calculate average salary
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);

        System.out.printf("\nAverage Salary: %.2f\n", averageSalary);

        // Step 5: Filter employees above age threshold
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
            .filter(emp -> emp.getAge() > ageThreshold)
            .collect(Collectors.toList());

        System.out.println("\nEmployees older than " + ageThreshold + ":");
        filteredEmployees.forEach(emp ->
            System.out.println(emp.getName() + " (" + emp.getAge() + ")")
        );
    }
}
