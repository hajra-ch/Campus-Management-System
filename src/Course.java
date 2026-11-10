public class Course {
    // Attributes
    private int courseId;
    private String courseCode;
    private String courseName;
    private String department;
    private int creditHours;
    private String teacherAssigned;

    // Constructor
    public Course(int courseId, String courseCode, String courseName, String department,
                  int creditHours, String teacherAssigned) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.creditHours = creditHours;
        this.teacherAssigned = teacherAssigned;
    }

    // Display Course Information
    public void displayCourse() {
        System.out.println("Course ID       : " + courseId);
        System.out.println("Course Code     : " + courseCode);
        System.out.println("Course Name     : " + courseName);
        System.out.println("Department      : " + department);
        System.out.println("Credit Hours    : " + creditHours);
        System.out.println("Teacher Assigned: " + teacherAssigned);
        System.out.println("----------------------------");
    }

    // Getter (needed for search/update/delete later)
    public int getCourseId() {
        return courseId;
    }

    // Setters (needed for update later)
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setTeacherAssigned(String teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }
     public String toFileString() {
        return courseId + "," + courseCode + "," + courseName + "," + department + ","
                + creditHours + "," + teacherAssigned;
    }   
}
