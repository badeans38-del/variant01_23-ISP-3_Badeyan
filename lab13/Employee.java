package lab13;



public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // абстрактный метод
    public abstract double calculatePay();

    // обычный метод
    public String getInfo() {
        return name + ", зарплата: " + salary;
    }

    // статический метод
    public static String formatSalary(double salary) {
        return String.format("%.2f руб.", salary);
    }
}