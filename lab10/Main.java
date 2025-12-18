package lab10;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager("Иван", 5, 3);
        Worker worker = new Worker("Алексей", 2, 160);

        System.out.println("=== Менеджер ===");
        manager.showInfo();
        System.out.println("Зарплата: " + manager.calculateSalary());
        System.out.println("Выработка: " + manager.getProductivity());

        System.out.println();

        System.out.println("=== Рабочий ===");
        worker.showInfo();
        System.out.println("Зарплата: " + worker.calculateSalary());
        System.out.println("Выработка: " + worker.getProductivity());

        System.out.println();

        System.out.println("Всего создано сотрудников: " + Employee.counter);
    }
}