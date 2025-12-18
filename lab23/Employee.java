package lab23;
import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String position;
    private double salary;
    private transient String password; // transient - не сериализуется

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.password = "secret123"; // Пароль не сохранится в файле
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "Employee[id=" + id +
                ", name=" + name +
                ", position=" + position +
                ", salary=" + salary +
                ", password=" + password + "]";
    }
}