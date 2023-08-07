import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Class> classes = new ArrayList<>();

        System.out.println("Initializing teachers...");
        teachers.add(new Teacher("Full Time Teacher 1", 3000, 5, true));
        teachers.add(new Teacher("Full Time Teacher 2", 3500, 8, true));
        teachers.add(new Teacher("Part Time Teacher 1", 25, 0, false));
        teachers.add(new Teacher("Part Time Teacher 2", 30, 0, false));

        // Initialize students
        System.out.println("Initializing students...");
        for (int i = 1; i <= 6; i++) {
            System.out.print("Enter student " + i + " name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student " + i + " ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter student " + i + " age: ");
            int age = Integer.parseInt(scanner.nextLine());
            students.add(new Student(name, id, age));
        }

        // Initialize classes
        System.out.println("Initializing classes...");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter class " + i + " name: ");
            String className = scanner.nextLine();
            System.out.print("Enter class " + i + " classroom: ");
            String classroom = scanner.nextLine();

            System.out.println("Available teachers:");
            for (int j = 0; j < teachers.size(); j++) {
                System.out.println(j + ". " + teachers.get(j).getName());
            }
            System.out.print("Select teacher index for class " + i + ": ");
            int teacherIndex = Integer.parseInt(scanner.nextLine());
            Teacher selectedTeacher = teachers.get(teacherIndex);

            Class newClass = new Class(className, classroom, selectedTeacher);

            System.out.println("Available students:");
            for (int j = 0; j < students.size(); j++) {
                System.out.println(j + ". " + students.get(j).getName());
            }
            System.out.print("Enter number of students to add to class " + i + ": ");
            int numStudents = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < numStudents; j++) {
                System.out.print("Select student index " + (j + 1) + ": ");
                int studentIndex = Integer.parseInt(scanner.nextLine());
                newClass.addStudent(students.get(studentIndex));
            }

            classes.add(newClass);
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("a. Print all professors with their data");
            System.out.println("b. Print all classes and select a class to view details");
            System.out.println("c. Create a new student and add them to an existing class");
            System.out.println("d. Create a new class and add a teacher and students");
            System.out.println("e. List all classes in which a student is included");
            System.out.println("f. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    System.out.println("\nProfessors with their data:");
                    for (Teacher teacher : teachers) {
                        System.out.println(teacher.getName() + " - Salary: " + teacher.calculateSalary());
                    }
                    break;

                case "b":
                    System.out.println("\nClasses:");
                    for (int i = 0; i < classes.size(); i++) {
                        System.out.println(i + ". " + classes.get(i).getName());
                    }
                    System.out.print("Select a class to view details (enter index): ");
                    int classIndex = Integer.parseInt(scanner.nextLine());
                    if (classIndex >= 0 && classIndex < classes.size()) {
                        Class selectedClass = classes.get(classIndex);
                        System.out.println("Class: " + selectedClass.getName());
                        System.out.println("Teacher: " + selectedClass.getTeacher().getName());
                        System.out.println("Students:");
                        for (Student student : selectedClass.getStudents()) {
                            System.out.println("- " + student.getName());
                        }
                    } else {
                        System.out.println("Invalid class index.");
                    }
                    break;

                case "c":
                    System.out.print("Enter student name: ");
                    String newStudentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String newStudentId = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int newStudentAge = Integer.parseInt(scanner.nextLine());

                    Student newStudent = new Student(newStudentName, newStudentId, newStudentAge);

                    System.out.println("Available classes to add the student to:");
                    for (int i = 0; i < classes.size(); i++) {
                        System.out.println(i + ". " + classes.get(i).getName());
                    }
                    System.out.print("Select a class to add the student to (enter index): ");
                    int classIndexToAddStudent = Integer.parseInt(scanner.nextLine());

                    if (classIndexToAddStudent >= 0 && classIndexToAddStudent < classes.size()) {
                        Class selectedClass = classes.get(classIndexToAddStudent);
                        selectedClass.addStudent(newStudent);
                        System.out.println("Student added to class " + selectedClass.getName());
                    } else {
                        System.out.println("Invalid class index.");
                    }
                    break;

                case "d":
                    System.out.print("Enter class name: ");
                    String newClassName = scanner.nextLine();
                    System.out.print("Enter classroom: ");
                    String newClassroom = scanner.nextLine();

                    System.out.println("Available teachers:");
                    for (int i = 0; i < teachers.size(); i++) {
                        System.out.println(i + ". " + teachers.get(i).getName());
                    }
                    System.out.print("Select a teacher for the class (enter index): ");
                    int teacherIndexForNewClass = Integer.parseInt(scanner.nextLine());

                    if (teacherIndexForNewClass >= 0 && teacherIndexForNewClass < teachers.size()) {
                        Teacher selectedTeacher = teachers.get(teacherIndexForNewClass);

                        Class newClass = new Class(newClassName, newClassroom, selectedTeacher);

                        System.out.println("Available students to add to the class:");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println(i + ". " + students.get(i).getName());
                        }
                        System.out.print("Enter number of students to add to the class: ");
                        int numStudentsToAdd = Integer.parseInt(scanner.nextLine());

                        for (int i = 0; i < numStudentsToAdd; i++) {
                            System.out.print("Select student index " + (i + 1) + ": ");
                            int studentIndexToAdd = Integer.parseInt(scanner.nextLine());
                            if (studentIndexToAdd >= 0 && studentIndexToAdd < students.size()) {
                                Student selectedStudent = students.get(studentIndexToAdd);
                                newClass.addStudent(selectedStudent);
                            } else {
                                System.out.println("Invalid student index.");
                            }
                        }

                        classes.add(newClass);
                        System.out.println("New class created and students added.");
                    } else {
                        System.out.println("Invalid teacher index.");
                    }
                    break;

                case "e":
                    System.out.print("Enter student ID to list their classes: ");
                    String studentId = scanner.nextLine();

                    System.out.println("Classes for student with ID " + studentId + ":");
                    for (Class classObj : classes) {
                        for (Student student : classObj.getStudents()) {
                            if (student.getId().equals(studentId)) {
                                System.out.println("- " + classObj.getName());
                                break; // No need to check the rest of the students in this class
                            }
                        }
                    }
                    break;

                case "f":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}