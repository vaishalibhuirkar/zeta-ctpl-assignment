
import java.time.LocalDate;
public class Employee {
    int id;
    String name;
    Address address;
    int age;
    LocalDate joiningDate;
    double salary;

    public Employee(int id, String name, Address address, int age, LocalDate joiningDate, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', address=" + address + ", age=" + age + ", joiningDate=" + joiningDate + ", salary=" + salary + "}";
    }
}
