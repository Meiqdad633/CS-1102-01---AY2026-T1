import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentManagementSystem extends JFrame {
    // Data model
    static class Student {
        String id, name, email;
        Student(String id, String name, String email) {
            this.id = id; this.name = name; this.email = email;
        }
    }

    // GUI components
    private DefaultTableModel studentTableModel;
    private JTable studentTable;
    private java.util.List<Student> students = new ArrayList<>();

    public StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu studentMenu = new JMenu("Student");
        JMenuItem addStudent = new JMenuItem("Add Student");
        JMenuItem updateStudent = new JMenuItem("Update Student");
        JMenuItem viewStudents = new JMenuItem("View Students");
        studentMenu.add(addStudent);
        studentMenu.add(updateStudent);
        studentMenu.add(viewStudents);
        menuBar.add(studentMenu);
        setJMenuBar(menuBar);

        // Table
        studentTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Email"}, 0);
        studentTable = new JTable(studentTableModel);
        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Event handlers
        addStudent.addActionListener(e -> showAddStudentDialog());
        updateStudent.addActionListener(e -> showUpdateStudentDialog());
        viewStudents.addActionListener(e -> refreshStudentTable());

        setVisible(true);
    }

    private void showAddStudentDialog() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        Object[] fields = {
            "ID:", idField,
            "Name:", nameField,
            "Email:", emailField
        };
        int result = JOptionPane.showConfirmDialog(this, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled.");
                }
                students.add(new Student(id, name, email));
                refreshStudentTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    private void showUpdateStudentDialog() {
        String id = JOptionPane.showInputDialog(this, "Enter Student ID to update:");
        if (id == null || id.trim().isEmpty()) return;
        Student student = students.stream().filter(s -> s.id.equals(id.trim())).findFirst().orElse(null);
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }
        JTextField nameField = new JTextField(student.name);
        JTextField emailField = new JTextField(student.email);
        Object[] fields = {
            "Name:", nameField,
            "Email:", emailField
        };
        int result = JOptionPane.showConfirmDialog(this, fields, "Update Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            student.name = nameField.getText().trim();
            student.email = emailField.getText().trim();
            refreshStudentTable();
        }
    }

    private void refreshStudentTable() {
        studentTableModel.setRowCount(0);
        for (Student s : students) {
            studentTableModel.addRow(new Object[]{s.id, s.name, s.email});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementSystem::new);
    }
}
