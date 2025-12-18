package lab14;

public class Manager extends Employee implements Actionable {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " управляет отделом");
    }

    @Override
    public void performAction() {
        System.out.println(name + " проводит совещание");
    }

    @Override
    public String getActionType() {
        return "Управленческое действие";
    }

    // Специфичный метод Manager
    public void makeDecision() {
        System.out.println(name + " принимает решение");
    }
}