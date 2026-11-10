# Campus Management System

A console-based Campus Management System written in Java. It manages students, teachers, courses, attendance and results through a menu-driven interface, and saves all data to text files so nothing is lost when the program closes.

## Features

- **Student Module:** add, view, search, update and delete students
- **Teacher Module:** add, view, search, update and delete teachers
- **Course Module:** add, view, search, update and delete courses, with a teacher assigned to each
- **Attendance Module:** mark, view, search, update and delete attendance records, plus view attendance by student
- **Result Module:** add marks per course and semester, with the grade calculated automatically (A to F), plus view results by student
- **File handling:** every module saves its data to a text file and loads it again on startup
- **Nested menus:** a main menu leads into a separate submenu for each module

## Concepts Used

- Object-Oriented Programming (classes, objects, constructors)
- Encapsulation (private fields with getters and setters)
- Collections (`ArrayList`)
- Methods, loops, conditions and `switch`
- Exception handling (`try-catch`)
- File handling (`FileWriter`, `BufferedReader`)
- Separation of concerns (a model class and a manager class for each module)

## Project Structure
Each module has a **model class** (the data, for example `Student`) and a **manager class** (the logic, for example `StudentManager`). `Main.java` only handles the menus.

## How to Run

1. Install JDK 21 (or any recent JDK).
2. Clone the repository
git clone https://github.com/hajra-ch/Campus-Management-System.git
3. Open the folder in VS Code (with the Java Extension Pack) and run `Main.java`.

Or from the command line:
cd Campus-Management-System/src
javac *.java
java Main

Saved data is written to a `data/` folder, which is created automatically on first use.

## Grading Scale

| Marks | Grade |
|-------|-------|
| 85 and above | A |
| 70 to 84 | B |
| 60 to 69 | C |
| 50 to 59 | D |
| Below 50 | F |

## Known Limitations

- Data is saved in comma-separated text files, so values must not contain commas.
- IDs are not checked for duplicates.
- Invalid input (for example text where a number is expected) is not fully validated yet.

## Possible Future Improvements

- Admin login
- Input validation and duplicate ID checks
- Linking courses directly to teacher and student objects
- Moving from text files to a database

## Author

Built as a semester project to practise Java and object-oriented design.
