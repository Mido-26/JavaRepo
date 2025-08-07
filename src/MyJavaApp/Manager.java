package MyJavaApp;

public class Manager extends Employees {
    
   public Manager(int hoursWorked, float hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
    @Override
    public float calculateSalary() {
        return super.calculateSalary();
    }
}
