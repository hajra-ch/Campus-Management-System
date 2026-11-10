public class Teacher {
    // Attributes
    private int teacherId;
    private String name;
    private String department;
    private String subject;
    private int experienceYears;
    private String qualification;
    private double salary;

    // Constructor
    public Teacher(int teacherId, String name, String department, String subject,
                   int experienceYears, String qualification, double salary) {
        this.teacherId = teacherId;
        this.name = name;
        this.department = department;
        this.subject = subject;
        this.experienceYears = experienceYears;
        this.qualification = qualification;
        this.salary = salary;
    }

    // Display Teacher Information
    public void displayTeacher() {
        System.out.println("Teacher ID    : " + teacherId);
        System.out.println("Name          : " + name);
        System.out.println("Department    : " + department);
        System.out.println("Subject       : " + subject);
        System.out.println("Experience    : " + experienceYears + " years");
        System.out.println("Qualification : " + qualification);
        System.out.println("Salary        : " + salary);
        System.out.println("----------------------------");
    }

    // Getter (needed for search/update/delete later)
    public int getTeacherId() {
        return teacherId;
    }

    // Setters (needed for update later)
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
        // Teacher ko ek text line mein badalta hai (file mein likhne ke liye)
    public String toFileString() {
        return teacherId + "," + name + "," + department + "," + subject + ","
                + experienceYears + "," + qualification + "," + salary;
    }
}
