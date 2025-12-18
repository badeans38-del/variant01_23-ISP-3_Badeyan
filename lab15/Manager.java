package lab15;

public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " управляет отделом");
    }
}