package AttendenceSystem;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private Map<String, String> attendance = new HashMap<>(); // date → Present/Absent

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void markAttendance(String date, String status) {
        attendance.put(date, status);
    }

    public Map<String, String> getAttendance() {
        return attendance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void printAttendance() {
        System.out.println("Attendance for " + name + " (ID: " + id + "):");
        if (attendance.isEmpty()) {
            System.out.println("No attendance records.");
        } else {
            attendance.forEach((date, status) -> System.out.println(date + " → " + status));
        }
    }
}

