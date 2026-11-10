import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ResultManager {

    private ArrayList<Result> results;

    public ResultManager() {
        results = new ArrayList<>();
        loadResults();
    }

    public void addResult(Result result) {
        results.add(result);
        saveResults();
        System.out.println("Result added successfully!");
    }

    public void viewResults() {
        if (results.isEmpty()) {
            System.out.println("No results found.");
            return;
        }
        for (Result result : results) {
            result.displayResult();
        }
    }

    public void searchResult(int resultId) {
        for (Result result : results) {
            if (result.getResultId() == resultId) {
                System.out.println("Result Found:");
                result.displayResult();
                return;
            }
        }
        System.out.println("No result found with ID: " + resultId);
    }

    public void updateResult(int resultId, String newCourseName, int newSemester, double newMarks) {
        for (Result result : results) {
            if (result.getResultId() == resultId) {
                result.setCourseName(newCourseName);
                result.setSemester(newSemester);
                result.setMarks(newMarks);

                saveResults();
                System.out.println("Result updated successfully!");
                return;
            }
        }
        System.out.println("No result found with ID: " + resultId);
    }

    public void deleteResult(int resultId) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getResultId() == resultId) {
                results.remove(i);
                saveResults();
                System.out.println("Result deleted successfully!");
                return;
            }
        }
        System.out.println("No result found with ID: " + resultId);
    }

    public void viewResultsByStudent(int studentId) {
        boolean found = false;

        for (Result result : results) {
            if (result.getStudentId() == studentId) {
                result.displayResult();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No results found for Student ID: " + studentId);
        }
    }

    public void saveResults() {
        try {
            new File("data").mkdirs();
            FileWriter writer = new FileWriter("data/results.txt");

            for (Result result : results) {
                writer.write(result.toFileString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }

    public void loadResults() {
        File file = new File("data/results.txt");

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int resultId = Integer.parseInt(parts[0]);
                int studentId = Integer.parseInt(parts[1]);
                String courseName = parts[2];
                int semester = Integer.parseInt(parts[3]);
                double marks = Double.parseDouble(parts[4]);

                results.add(new Result(resultId, studentId, courseName, semester, marks));
            }

            reader.close();
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error loading results: " + e.getMessage());
        }
    }
}