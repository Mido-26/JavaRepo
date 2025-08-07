package MyJavaApp;

public class App {
    public static void main(String[] args) {

        // var bank = new Bank();
        // bank.deposit(100.0f);
        // bank.withdraw(50.0f);
        // System.out.println("Current balance: " + bank.getBalance());
        // bank.withdraw(60.0f); // This should print an error message
        // bank.deposit(-20.0f); // This should also print an error message
        // System.out.println("Hello, World!");

        // calculate salary for a regular employee
        System.out.println("Manager salary " + calculateSalary(new Manager(8, 20.0f)));
        System.out.println("Engineer salary " + calculateSalary(new Engineer(8, 15.0f)));
        System.out.println("Intern salary " + calculateSalary(new Intern(9, 10.0f)));
    }

    public static float calculateSalary(Employees employees){
        return employees.calculateSalary();
    }
}
