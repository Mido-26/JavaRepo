package SchoolSystem;

public abstract class Person {
    private String name;
    private int age;
    private String address;

    protected static int personCount = 0; // For static tracking

    public Person(String name, int age, String address) {
        this.name = name;
        setAge(age);
        this.address = address;
        personCount++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        if (age > 0) this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public abstract void displayInfo();
}
