import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
        loadStudents();   // program shuru hote hi purana data wapas laao
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            student.displayStudent();
        }
    }

    public void searchStudent(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                System.out.println("Student Found:");
                student.displayStudent();
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    public void updateStudent(int id, String newName, String newDepartment, int newSemester, double newCgpa) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                student.setName(newName);
                student.setDepartment(newDepartment);
                student.setSemester(newSemester);
                student.setCgpa(newCgpa);

                saveStudents();
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.remove(i);
                saveStudents();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    // Saare students ko file mein save karta hai
    public void saveStudents() {
        try {
            new File("data").mkdirs();
            FileWriter writer = new FileWriter("data/students.txt");

            for (Student student : students) {
                writer.write(student.toFileString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // File se students wapas load karta hai
    public void loadStudents() {
        File file = new File("data/students.txt");

        if (!file.exists()) {
            return;   // file nahi hai, to kuch load nahi karna
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                int semester = Integer.parseInt(parts[3]);
                double cgpa = Double.parseDouble(parts[4]);

                students.add(new Student(id, name, department, semester, cgpa));
            }

            reader.close();
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}
