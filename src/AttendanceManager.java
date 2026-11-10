import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AttendanceManager {

    private ArrayList<Attendance> records;

    public AttendanceManager() {
        records = new ArrayList<>();
        loadAttendance();
    }

    public void addAttendance(Attendance record) {
        records.add(record);
        saveAttendance();
        System.out.println("Attendance marked successfully!");
    }

    public void viewAttendance() {
        if (records.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        for (Attendance record : records) {
            record.displayAttendance();
        }
    }

    public void searchAttendance(int attendanceId) {
        for (Attendance record : records) {
            if (record.getAttendanceId() == attendanceId) {
                System.out.println("Attendance Record Found:");
                record.displayAttendance();
                return;
            }
        }
        System.out.println("No attendance record found with ID: " + attendanceId);
    }

    public void updateAttendance(int attendanceId, String newCourseName, String newDate,
                                 String newStatus, String newMarkedBy) {
        for (Attendance record : records) {
            if (record.getAttendanceId() == attendanceId) {
                record.setCourseName(newCourseName);
                record.setDate(newDate);
                record.setStatus(newStatus);
                record.setMarkedBy(newMarkedBy);

                saveAttendance();
                System.out.println("Attendance record updated successfully!");
                return;
            }
        }
        System.out.println("No attendance record found with ID: " + attendanceId);
    }

    public void deleteAttendance(int attendanceId) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getAttendanceId() == attendanceId) {
                records.remove(i);
                saveAttendance();
                System.out.println("Attendance record deleted successfully!");
                return;
            }
        }
        System.out.println("No attendance record found with ID: " + attendanceId);
    }

    public void viewAttendanceByStudent(int studentId) {
        boolean found = false;

        for (Attendance record : records) {
            if (record.getStudentId() == studentId) {
                record.displayAttendance();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No attendance records found for Student ID: " + studentId);
        }
    }

    public void saveAttendance() {
        try {
            new File("data").mkdirs();
            FileWriter writer = new FileWriter("data/attendance.txt");

            for (Attendance record : records) {
                writer.write(record.toFileString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving attendance: " + e.getMessage());
        }
    }

    public void loadAttendance() {
        File file = new File("data/attendance.txt");

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int attendanceId = Integer.parseInt(parts[0]);
                int studentId = Integer.parseInt(parts[1]);
                String courseName = parts[2];
                String date = parts[3];
                String status = parts[4];
                String markedBy = parts[5];

                records.add(new Attendance(attendanceId, studentId, courseName, date, status, markedBy));
            }

            reader.close();
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error loading attendance: " + e.getMessage());
        }
    }
}