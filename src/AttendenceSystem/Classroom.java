package AttendenceSystem;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String className;
    private List<Student> students = new ArrayList<>();

    public Classroom(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudentById(String studentId) {
        return students.removeIf(s -> s.getId().equals(studentId));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void listStudents() {
        System.out.println("Students in " + className + ":");
        if (students.isEmpty()) {
            System.out.println("No students in this class.");
        } else {
            for (Student s : students) {
                System.out.println("- " + s.getName() + " (ID: " + s.getId() + ")");
            }
        }
    }
}

