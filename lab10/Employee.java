package lab10;

public abstract class Employee {

    protected int id;
    protected String name;
    protected String position;

    protected static int counter = 0;

    public Employee(String name, String position) {
        this.id = generateId();
        this.name = name;
        this.position = position;
    }

    // обычный метод
    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
    }

    // абстрактный метод
    public abstract double calculateSalary();

    // статический метод
    public static int generateId() {
        counter++;
        return counter;
    }
}
