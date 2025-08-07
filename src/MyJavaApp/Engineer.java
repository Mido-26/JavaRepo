package MyJavaApp;

public class Engineer extends Employees {

    public Engineer(int hoursWorked, float hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
    @Override
    public float calculateSalary() {
        return super.calculateSalary();
    }
}
