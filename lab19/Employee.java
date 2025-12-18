package lab19;
import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String position;
    private double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + ";" + name + ";" + position + ";" + salary;
    }

    public String toFormattedString() {
        return String.format("ID: %d | %s | %s | %.2f руб.", id, name, position, salary);
    }
}