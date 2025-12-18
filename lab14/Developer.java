package lab14;

public class Developer extends Employee implements Actionable {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " пишет код");
    }

    @Override
    public void performAction() {
        System.out.println(name + " отлаживает программу");
    }

    @Override
    public String getActionType() {
        return "Техническое действие";
    }

    // Специфичный метод Developer
    public void debugCode() {
        System.out.println(name + " исправляет ошибки");
    }
}