package lab14;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация приведения типов ===\n");

        // 1. Восходящее приведение (автоматическое)
        System.out.println("1. Восходящее приведение (Upcasting):");
        Employee emp1 = new Manager("Иванов", 50000); // Manager -> Employee
        Employee emp2 = new Developer("Петров", 60000); // Developer -> Employee

        emp1.showInfo();
        emp2.showInfo();

        // 2. Полиморфизм
        System.out.println("\n2. Полиморфизм:");
        Employee[] employees = {emp1, emp2};
        for (Employee emp : employees) {
            emp.work(); // Вызывается разная реализация
        }

        // 3. Нисходящее приведение с instanceof (безопасное)
        System.out.println("\n3. Нисходящее приведение (Downcasting) с instanceof:");

        for (Employee emp : employees) {
            if (emp instanceof Manager) {
                Manager manager = (Manager) emp; // Employee -> Manager
                manager.makeDecision();
            } else if (emp instanceof Developer) {
                Developer dev = (Developer) emp; // Employee -> Developer
                dev.debugCode();
            }
        }

        // 4. Приведение к интерфейсу
        System.out.println("\n4. Приведение к интерфейсу:");
        Actionable action1 = new Manager("Сидоров", 55000); // Manager -> Actionable
        Actionable action2 = new Developer("Кузнецов", 65000); // Developer -> Actionable

        action1.performAction();
        action2.performAction();

        // 5. Обратное приведение от интерфейса
        System.out.println("\n5. Приведение от интерфейса к классу:");
        if (action1 instanceof Manager) {
            Manager m = (Manager) action1;
            m.showInfo();
        }

        // 6. Некорректное приведение (опасно!)
        System.out.println("\n6. Некорректное приведение:");
        try {
            Developer wrongDev = (Developer) emp1; // emp1 - Manager, а не Developer
            wrongDev.debugCode();
        } catch (ClassCastException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // 7. Безопасная проверка перед приведением
        System.out.println("\n7. Безопасная проверка:");
        Employee testEmp = new Developer("Тестов", 40000);

        if (testEmp instanceof Developer) {
            System.out.println("Это разработчик, можно приводить");
            Developer safeDev = (Developer) testEmp;
            safeDev.debugCode();
        } else {
            System.out.println("Это не разработчик");
        }

        // 8. Цепочка instanceof
        System.out.println("\n8. Цепочка проверок:");
        Object obj = new Manager("Объект", 70000);

        if (obj instanceof Object) {
            System.out.println("Это Object");
        }
        if (obj instanceof Employee) {
            System.out.println("Это Employee");
        }
        if (obj instanceof Manager) {
            System.out.println("Это Manager");
        }
        if (obj instanceof Actionable) {
            System.out.println("Это Actionable");
        }
    }
}