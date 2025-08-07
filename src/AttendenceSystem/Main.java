package AttendenceSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();
        boolean running = true;

        while (running) {
            System.out.println("\nSchool Attendance System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance");
            System.out.println("5. Transfer Student");
            System.out.println("6. List Students in Class");
            System.out.println("7. Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    String id = school.generateStudentId();
                    Student student = new Student(id, name);
                    school.getOrCreateClass(className).addStudent(student);

                    System.out.println("Student added with ID: " + id);
                }
                case 2 -> {
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    Classroom cls = school.getClassroomByStudentId(id);
                    if (cls != null && cls.removeStudentById(id)) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    Classroom cls = school.getOrCreateClass(className);

                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();

                    for (Student s : cls.getStudents()) {
                        System.out.print(s.getName() + " (P/A): ");
                        String status = scanner.nextLine().trim().equalsIgnoreCase("P") ? "Present" : "Absent";
                        s.markAttendance(date, status);
                    }
                    System.out.println("Attendance marked.");
                }
                case 4 -> {
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    Student s = school.searchStudentById(id);
                    if (s != null) {
                        s.printAttendance();
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter new class name: ");
                    String newClass = scanner.nextLine();
                    school.transferStudent(id, newClass);
                }
                case 6 -> {
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    Classroom cls = school.getOrCreateClass(className);
                    cls.listStudents();
                }
                case 7 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}

