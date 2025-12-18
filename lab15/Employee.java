package lab15;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract void work();

    // Внутренний класс
    public class Task {
        private String name; // Конфликт имен с Employee.name

        public Task(String name) {
            this.name = name; // Это Task.name
        }

        public void showTask() {
            System.out.println("Задача: " + name);
            System.out.println("Сотрудник: " + Employee.this.name); // Явное указание
        }
    }

    // Статический вложенный класс
    public static class Calculator {
        public static double calculateBonus(double salary) {
            return salary * 0.1;
        }
    }

    public String getName() {
        return name;
    }
}