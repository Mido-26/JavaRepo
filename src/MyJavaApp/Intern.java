package MyJavaApp;

public class Intern extends Employees {
    public Intern(int hoursWorked, float hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
    @Override
    public float calculateSalary() {
        return super.calculateSalary();
    }
}
