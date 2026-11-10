import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        CourseManager courseManager = new CourseManager();
        AttendanceManager attendanceManager = new AttendanceManager();
        ResultManager resultManager = new ResultManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

                     System.out.println("======================================");
            System.out.println("CAMPUS MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Student Module");
            System.out.println("2. Teacher Module");
            System.out.println("3. Course Module");
            System.out.println("4. Attendance Module");
            System.out.println("5. Result Module");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {

                case 1:
                    studentMenu(scanner, studentManager);
                    break;

                case 2:
                    teacherMenu(scanner, teacherManager);
                    break;

                case 3:
                    courseMenu(scanner, courseManager);
                    break;

                case 4:
                    attendanceMenu(scanner, attendanceManager);
                    break;

                case 5:
                    resultMenu(scanner, resultManager);
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // ---------------- STUDENT SUBMENU ----------------
    public static void studentMenu(Scanner scanner, StudentManager manager) {
        boolean back = false;

        while (!back) {
            System.out.println("--------------------------------------");
            System.out.println("STUDENT MODULE");
            System.out.println("--------------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = scanner.nextInt();

                    System.out.print("Enter CGPA: ");
                    double cgpa = scanner.nextDouble();

                    Student newStudent = new Student(id, name, department, semester, cgpa);
                    manager.addStudent(newStudent);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchStudent(searchId);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter New Semester: ");
                    int newSemester = scanner.nextInt();

                    System.out.print("Enter New CGPA: ");
                    double newCgpa = scanner.nextDouble();

                    manager.updateStudent(updateId, newName, newDepartment, newSemester, newCgpa);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ---------------- TEACHER SUBMENU ----------------
    public static void teacherMenu(Scanner scanner, TeacherManager manager) {
        boolean back = false;

        while (!back) {
            System.out.println("--------------------------------------");
            System.out.println("TEACHER MODULE");
            System.out.println("--------------------------------------");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Search Teacher");
            System.out.println("4. Update Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Teacher ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter Experience (years): ");
                    int experience = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Qualification: ");
                    String qualification = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    Teacher newTeacher = new Teacher(id, name, department, subject, experience, qualification, salary);
                    manager.addTeacher(newTeacher);
                    break;

                case 2:
                    manager.viewTeachers();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Teacher ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchTeacher(searchId);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter Teacher ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter New Subject: ");
                    String newSubject = scanner.nextLine();

                    System.out.print("Enter New Experience (years): ");
                    int newExperience = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Qualification: ");
                    String newQualification = scanner.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();

                    manager.updateTeacher(updateId, newName, newDepartment, newSubject, newExperience, newQualification, newSalary);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Teacher ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteTeacher(deleteId);
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ---------------- COURSE SUBMENU ----------------
    public static void courseMenu(Scanner scanner, CourseManager manager) {
        boolean back = false;

        while (!back) {
            System.out.println("--------------------------------------");
            System.out.println("COURSE MODULE");
            System.out.println("--------------------------------------");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Credit Hours: ");
                    int creditHours = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Teacher Assigned: ");
                    String teacherAssigned = scanner.nextLine();

                    Course newCourse = new Course(id, courseCode, courseName, department, creditHours, teacherAssigned);
                    manager.addCourse(newCourse);
                    break;

                case 2:
                    manager.viewCourses();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Course ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchCourse(searchId);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter Course ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course Code: ");
                    String newCourseCode = scanner.nextLine();

                    System.out.print("Enter New Course Name: ");
                    String newCourseName = scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter New Credit Hours: ");
                    int newCreditHours = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Teacher Assigned: ");
                    String newTeacherAssigned = scanner.nextLine();

                    manager.updateCourse(updateId, newCourseCode, newCourseName, newDepartment, newCreditHours, newTeacherAssigned);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Course ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteCourse(deleteId);
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ---------------- ATTENDANCE SUBMENU ----------------
    public static void attendanceMenu(Scanner scanner, AttendanceManager manager) {
        boolean back = false;

        while (!back) {
            System.out.println("--------------------------------------");
            System.out.println("ATTENDANCE MODULE");
            System.out.println("--------------------------------------");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View All Attendance");
            System.out.println("3. Search Attendance by ID");
            System.out.println("4. Update Attendance");
            System.out.println("5. Delete Attendance");
            System.out.println("6. View Attendance by Student ID");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Attendance ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter Date (e.g. 2026-09-05): ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Status (Present/Absent): ");
                    String status = scanner.nextLine();

                    System.out.print("Enter Marked By (teacher name): ");
                    String markedBy = scanner.nextLine();

                    Attendance newRecord = new Attendance(id, studentId, courseName, date, status, markedBy);
                    manager.addAttendance(newRecord);
                    break;

                case 2:
                    manager.viewAttendance();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Attendance ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchAttendance(searchId);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter Attendance ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course Name: ");
                    String newCourseName = scanner.nextLine();

                    System.out.print("Enter New Date: ");
                    String newDate = scanner.nextLine();

                    System.out.print("Enter New Status: ");
                    String newStatus = scanner.nextLine();

                    System.out.print("Enter New Marked By: ");
                    String newMarkedBy = scanner.nextLine();

                    manager.updateAttendance(updateId, newCourseName, newDate, newStatus, newMarkedBy);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Attendance ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteAttendance(deleteId);
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    int viewStudentId = scanner.nextInt();
                    manager.viewAttendanceByStudent(viewStudentId);
                    break;

                case 7:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
                // ---------------- RESULT SUBMENU ----------------
    public static void resultMenu(Scanner scanner, ResultManager manager) {
        boolean back = false;

        while (!back) {
            System.out.println("--------------------------------------");
            System.out.println("RESULT MODULE");
            System.out.println("--------------------------------------");
            System.out.println("1. Add Result");
            System.out.println("2. View All Results");
            System.out.println("3. Search Result by ID");
            System.out.println("4. Update Result");
            System.out.println("5. Delete Result");
            System.out.println("6. View Results by Student ID");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Result ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = scanner.nextInt();

                    System.out.print("Enter Marks (out of 100): ");
                    double marks = scanner.nextDouble();

                    Result newResult = new Result(id, studentId, courseName, semester, marks);
                    manager.addResult(newResult);
                    break;

                case 2:
                    manager.viewResults();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Result ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchResult(searchId);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter Result ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course Name: ");
                    String newCourseName = scanner.nextLine();

                    System.out.print("Enter New Semester: ");
                    int newSemester = scanner.nextInt();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();

                    manager.updateResult(updateId, newCourseName, newSemester, newMarks);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Result ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteResult(deleteId);
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    int viewStudentId = scanner.nextInt();
                    manager.viewResultsByStudent(viewStudentId);
                    break;

                case 7:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}