package AttendenceSystem;

import java.util.HashMap;
import java.util.Map;

public class School {
    private Map<String, Classroom> classes = new HashMap<>();
    private int nextStudentId = 100;

    public Classroom getOrCreateClass(String className) {
        return classes.computeIfAbsent(className, name -> new Classroom(name));
    }

    public Student searchStudentById(String id) {
        for (Classroom classroom : classes.values()) {
            Student s = classroom.findStudentById(id);
            if (s != null) return s;
        }
        return null;
    }

    public String generateStudentId() {
        return "S" + (nextStudentId++);
    }

    public Classroom getClassroomByStudentId(String studentId) {
        for (Classroom classroom : classes.values()) {
            if (classroom.findStudentById(studentId) != null) {
                return classroom;
            }
        }
        return null;
    }

    public void transferStudent(String studentId, String newClassName) {
        Classroom oldClass = getClassroomByStudentId(studentId);
        if (oldClass == null) {
            System.out.println("Student not found.");
            return;
        }
        Student student = oldClass.findStudentById(studentId);
        if (student == null) return;

        oldClass.removeStudentById(studentId);
        getOrCreateClass(newClassName).addStudent(student);
        System.out.println("Student transferred successfully.");
    }
}

