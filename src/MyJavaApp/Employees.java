package MyJavaApp;

public class Employees {

    private int hoursWorked;
    private float hourlyRate;
    public Employees(int hoursWorked, float hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    public float calculateSalary() {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Hours worked and hourly rate must be non-negative.");
            return 0;
        }
        return hoursWorked * hourlyRate;
    }
}


