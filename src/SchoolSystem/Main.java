package SchoolSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        Student john = new Student("John Doe", 17, "Zanzibar", "ST001");
        john.addGrade("Math", 90);
        john.addGrade("English", 79);

        Teacher smith = new Teacher("Mrs. Smith", 35, "Dar", "TCH202", List.of("Math", "Physics"));

        school.addStudent(john);
        school.addTeacher(smith);

        List<Person> people = List.of(john, smith);
        for (Person p : people) {
            p.displayInfo();
            if (p instanceof Payable) {
                System.out.println("Payment: " + ((Payable) p).getPaymentDetails());
            }
            System.out.println();
        }

        school.printSummary();

        // Notifications
        school.notifyAll("Tomorrow is a holiday!");

        // Deep Copy
        Student johnCopy = john.deepCopy();
        johnCopy.addGrade("Kiswahili", 100);
        System.out.println("\nOriginal Grades: " + john.getGrades());
        System.out.println("Copied Grades: " + johnCopy.getGrades());
    }
}

