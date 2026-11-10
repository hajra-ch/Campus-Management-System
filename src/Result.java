public class Result {
    // Attributes
    private int resultId;
    private int studentId;
    private String courseName;
    private int semester;
    private double marks;
    private String grade;

    // Constructor
    public Result(int resultId, int studentId, String courseName, int semester, double marks) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.courseName = courseName;
        this.semester = semester;
        this.marks = marks;
        this.grade = calculateGrade(marks);   // grade khud calculate hota hai
    }

    // Grade calculation logic
    private String calculateGrade(double marks) {
        if (marks >= 85) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Display Result Information
    public void displayResult() {
        System.out.println("Result ID  : " + resultId);
        System.out.println("Student ID : " + studentId);
        System.out.println("Course     : " + courseName);
        System.out.println("Semester   : " + semester);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + grade);
        System.out.println("----------------------------");
    }

    // Getters
    public int getResultId() {
        return resultId;
    }

    public int getStudentId() {
        return studentId;
    }

    // Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);   // marks badle to grade bhi dobara calculate
    }
        public String toFileString() {
        return resultId + "," + studentId + "," + courseName + "," + semester + "," + marks;
    }
}
