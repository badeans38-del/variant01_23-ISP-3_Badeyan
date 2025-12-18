package lab16;

public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract void work();

    public void showInfo() {
        System.out.println("Сотрудник: " + name);
    }
}