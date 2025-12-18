package lab13;



public class Main {
    public static void main(String[] args) {
        // 1. Переменная абстрактного класса
        Employee emp1 = new Manager("Иванов", 50000, 15000);

        // 2. Переменная конкретного класса
        Manager manager = new Manager("Петров", 60000, 20000);

        // 3. Переменная интерфейса
        BonusCalculable bonusEmp = new Manager("Сидоров", 55000, 18000);

        System.out.println("=== Демонстрация ===");

        // Методы абстрактного класса
        System.out.println("\n--- Методы Employee ---");
        System.out.println(emp1.getInfo());
        System.out.println("Зарплата: " + emp1.calculatePay());

        // Методы конкретного класса
        System.out.println("\n--- Методы Manager ---");
        manager.conductMeeting();
        System.out.println(manager.getBonusInfo());

        // Методы интерфейса
        System.out.println("\n--- Методы BonusCalculable ---");
        System.out.println(bonusEmp.getDefaultBonusMessage());
        System.out.println("Бонус: " + bonusEmp.calculateBonus());

        // Статические методы
        System.out.println("\n--- Статические методы ---");
        System.out.println("Оформление: " + Employee.formatSalary(75000));
        System.out.println("Налог: " + BonusCalculable.calculateTax(10000));

        // Полиморфизм
        System.out.println("\n--- Полиморфизм ---");
        Employee[] employees = {emp1, manager};
        for (Employee e : employees) {
            System.out.println(e.calculatePay()); // разное поведение
        }
    }
}