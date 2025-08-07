package SchoolSystem;

import java.util.*;

public class Student extends Person implements Payable, NotificationService{
    private String studentId;
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String name, int age, String address, String studentId) {
        super(name, age, address);
        this.studentId = studentId;
    }
    
    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        return grades.values().stream().mapToInt(i -> i).average().orElse(0);
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Role: Student");
        System.out.println("Average Grade: " + calculateAverage());
    }

    @Override
    public String getPaymentDetails() {
        return "Tuition Fees Paid";
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Student " + getName() + " received: " + message);
    }

    public Student deepCopy() {
        Student copy = new Student(getName(), getAge(), getAddress(), this.studentId);
        for (Map.Entry<String, Integer> entry : this.grades.entrySet()) {
            copy.addGrade(entry.getKey(), entry.getValue());
        }
        return copy;
    }
}
