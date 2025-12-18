package lab14;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();

    public void showInfo() {
        System.out.println("Сотрудник: " + name + ", зарплата: " + salary);
    }
}