package SchoolSystem;

import java.util.*;

public class School {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void notifyAll(String message) {
        for (Student s : students) s.receiveNotification(message);
        for (Teacher t : teachers) t.receiveNotification(message);
    }

    public void printSummary() {
        System.out.println("Total Registered Persons: " + Person.personCount);
    }
}

