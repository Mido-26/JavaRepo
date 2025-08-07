package SchoolSystem;

import java.util.*;

public class Teacher extends Person implements Payable, NotificationService {
    private String employeeId;
    private List<String> subjectsTaught;

    public Teacher(String name, int age, String address, String employeeId, List<String> subjectsTaught) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.subjectsTaught = subjectsTaught;
    }

    public double calculateSalary() {
        return subjectsTaught.size() * 500_000;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Role: Teacher");
        System.out.println("Subjects: " + subjectsTaught);
        System.out.println("Salary: " + calculateSalary() + " TZS");
    }

    @Override
    public String getPaymentDetails() {
        return "Monthly Salary: " + calculateSalary() + " TZS";
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Teacher " + getName() + " received: " + message);
    }
}

