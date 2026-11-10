public class Attendance {
    // Attributes
    private int attendanceId;
    private int studentId;
    private String courseName;
    private String date;
    private String status;
    private String markedBy;

    // Constructor
    public Attendance(int attendanceId, int studentId, String courseName, String date,
                       String status, String markedBy) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.courseName = courseName;
        this.date = date;
        this.status = status;
        this.markedBy = markedBy;
    }

    // Display Attendance Information
    public void displayAttendance() {
        System.out.println("Attendance ID : " + attendanceId);
        System.out.println("Student ID    : " + studentId);
        System.out.println("Course        : " + courseName);
        System.out.println("Date          : " + date);
        System.out.println("Status        : " + status);
        System.out.println("Marked By     : " + markedBy);
        System.out.println("----------------------------");
    }

    // Getter (needed for search/update/delete later)
    public int getAttendanceId() {
        return attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    // Setters (needed for update later)
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMarkedBy(String markedBy) {
        this.markedBy = markedBy;
    }
        public String toFileString() {
        return attendanceId + "," + studentId + "," + courseName + "," + date + ","
                + status + "," + markedBy;
    }
}
