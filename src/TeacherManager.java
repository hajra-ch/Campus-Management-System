import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TeacherManager {

    private ArrayList<Teacher> teachers;

    public TeacherManager() {
        teachers = new ArrayList<>();
        loadTeachers();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        saveTeachers();
        System.out.println("Teacher added successfully!");
    }

    public void viewTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }
        for (Teacher teacher : teachers) {
            teacher.displayTeacher();
        }
    }

    public void searchTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                System.out.println("Teacher Found:");
                teacher.displayTeacher();
                return;
            }
        }
        System.out.println("No teacher found with ID: " + id);
    }

    public void updateTeacher(int id, String newName, String newDepartment, String newSubject,
                              int newExperienceYears, String newQualification, double newSalary) {

        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                teacher.setName(newName);
                teacher.setDepartment(newDepartment);
                teacher.setSubject(newSubject);
                teacher.setExperienceYears(newExperienceYears);
                teacher.setQualification(newQualification);
                teacher.setSalary(newSalary);

                saveTeachers();
                System.out.println("Teacher updated successfully!");
                return;
            }
        }
        System.out.println("No teacher found with ID: " + id);
    }

    public void deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId() == id) {
                teachers.remove(i);
                saveTeachers();
                System.out.println("Teacher deleted successfully!");
                return;
            }
        }
        System.out.println("No teacher found with ID: " + id);
    }

    // Saare teachers ko file mein save karta hai
    public void saveTeachers() {
        try {
            new File("data").mkdirs();
            FileWriter writer = new FileWriter("data/teachers.txt");

            for (Teacher teacher : teachers) {
                writer.write(teacher.toFileString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving teachers: " + e.getMessage());
        }
    }

    // File se teachers wapas load karta hai
    public void loadTeachers() {
        File file = new File("data/teachers.txt");

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                String subject = parts[3];
                int experienceYears = Integer.parseInt(parts[4]);
                String qualification = parts[5];
                double salary = Double.parseDouble(parts[6]);

                teachers.add(new Teacher(id, name, department, subject, experienceYears, qualification, salary));
            }

            reader.close();
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error loading teachers: " + e.getMessage());
        }
    }
}