package LAB12;



public abstract class Employee {
    private String name;
    private String position;
    private double salary;
    private int hoursWorked;

    public Employee(String name, String position, double salary, int hoursWorked) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hoursWorked = hoursWorked;
    }

    public abstract double calculatePay();
    public abstract String getInfo();

    // Геттеры
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public int getHoursWorked() { return hoursWorked; }
}