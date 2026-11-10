public class Student {
     // Attributes
    private int studentId;
    private String name;
    private String department;
    private int semester;
    private double cgpa;

    // Constructor
    public Student(int studentId, String name, String department, int semester, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    // Display Student Information
    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Semester   : " + semester);
        System.out.println("CGPA       : " + cgpa);
        System.out.println("----------------------------");
    }
     // Getter for studentId
    public int getStudentId() {
        return studentId;
    }
    public void setName(String name) {
    this.name = name;
}

public void setDepartment(String department) {
    this.department = department;
}

public void setSemester(int semester) {
    this.semester = semester;
}

public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
}
    // Student ko ek text line mein badalta hai (file mein likhne ke liye)
    public String toFileString() { return studentId + "," + name + "," + department + "," + semester + "," + cgpa;
    }
}

