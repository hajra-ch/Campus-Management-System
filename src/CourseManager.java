import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
        loadCourses();
    }

    public void addCourse(Course course) {
        courses.add(course);
        saveCourses();
        System.out.println("Course added successfully!");
    }

    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course course : courses) {
            course.displayCourse();
        }
    }

    public void searchCourse(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                System.out.println("Course Found:");
                course.displayCourse();
                return;
            }
        }
        System.out.println("No course found with ID: " + id);
    }

    public void updateCourse(int id, String newCourseCode, String newCourseName, String newDepartment,
                             int newCreditHours, String newTeacherAssigned) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                course.setCourseCode(newCourseCode);
                course.setCourseName(newCourseName);
                course.setDepartment(newDepartment);
                course.setCreditHours(newCreditHours);
                course.setTeacherAssigned(newTeacherAssigned);

                saveCourses();
                System.out.println("Course updated successfully!");
                return;
            }
        }
        System.out.println("No course found with ID: " + id);
    }

    public void deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == id) {
                courses.remove(i);
                saveCourses();
                System.out.println("Course deleted successfully!");
                return;
            }
        }
        System.out.println("No course found with ID: " + id);
    }

    public void saveCourses() {
        try {
            new File("data").mkdirs();
            FileWriter writer = new FileWriter("data/courses.txt");

            for (Course course : courses) {
                writer.write(course.toFileString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    public void loadCourses() {
        File file = new File("data/courses.txt");

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String courseCode = parts[1];
                String courseName = parts[2];
                String department = parts[3];
                int creditHours = Integer.parseInt(parts[4]);
                String teacherAssigned = parts[5];

                courses.add(new Course(id, courseCode, courseName, department, creditHours, teacherAssigned));
            }

            reader.close();
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
    }
}