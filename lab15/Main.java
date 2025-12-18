package lab15;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Вложенные классы ===\n");

        // 1. Создаем объекты
        Manager manager = new Manager("Иванов");

        // 2. Внутренний класс (нужен объект)
        Manager.Task task = manager.new Task("Подготовить отчет");
        task.showTask();

        // 3. Статический класс (без объекта)
        double bonus = Manager.Calculator.calculateBonus(50000);
        System.out.println("Бонус: " + bonus);

        // 4. Различия в доступе
        System.out.println("\n--- Различия ---");

        // Внутренний класс имеет доступ к полям
        Manager.Task task2 = manager.new Task("Тест");
        task2.showTask(); // Видит Employee.this.name

        // Статический класс НЕ имеет доступа
        double bonus2 = Employee.Calculator.calculateBonus(60000);
        System.out.println("Бонус 2: " + bonus2);

        // 5. Несколько объектов
        Manager[] managers = {
                new Manager("Петров"),
                new Manager("Сидоров")
        };

        for (Manager m : managers) {
            Manager.Task t = m.new Task("Задача для " + m.getName());
            t.showTask();
        }
    }
}