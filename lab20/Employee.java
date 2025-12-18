package lab20;
public class Employee {
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

    // Создание Employee из строки (для чтения из файла)
    public static Employee fromString(String line) {
        try {
            String[] parts = line.split(";");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String position = parts[2];
            double salary = Double.parseDouble(parts[3]);
            return new Employee(id, name, position, salary);
        } catch (Exception e) {
            System.out.println("Ошибка преобразования строки: " + line);
            return null;
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("%d. %s | %s | %.2f руб.", id, name, position, salary);
    }
}