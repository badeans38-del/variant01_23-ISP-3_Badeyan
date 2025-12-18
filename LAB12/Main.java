package LAB12;



public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация полиморфизма ===");

        // 1. Создаем массив базового типа Employee
        Employee[] employees = new Employee[4];

        // 2. Заполняем разными типами (полиморфизм при создании)
        employees[0] = new Worker("Иванов", 300.0, 160);
        employees[1] = new Manager("Петров", 600.0, 160, 5000.0);
        employees[2] = new Worker("Сидоров", 280.0, 150);
        employees[3] = new Manager("Кузнецов", 700.0, 155, 6000.0);

        // 3. Демонстрация полиморфизма в цикле
        System.out.println("\n--- Информация о всех сотрудниках ---");
        for (Employee emp : employees) {
            // Полиморфизм: JVM сама выбирает нужную реализацию
            System.out.println(emp.getInfo());
        }

        // 4. Демонстрация полиморфизма при расчете зарплаты
        System.out.println("\n--- Расчет общей зарплаты ---");
        double totalSalary = 0;
        for (Employee emp : employees) {
            // Для каждого объекта вызовется свой calculatePay()
            double salary = emp.calculatePay();
            System.out.println(emp.getName() + ": " + salary);
            totalSalary += salary;
        }
        System.out.println("Общая сумма: " + totalSalary);

        // 5. Использование instanceof для специфичных методов
        System.out.println("\n--- Специфичные действия ---");
        for (Employee emp : employees) {
            if (emp instanceof Manager) {
                Manager manager = (Manager) emp; // Приведение типа
                System.out.println(manager.getName() + " имеет бонус: " + manager.getBonus());
            } else if (emp instanceof Worker) {
                System.out.println(emp.getName() + " - рабочий с почасовой оплатой");
            }
        }

        // 6. Статический полиморфизм (перегрузка метода)
        System.out.println("\n--- Перегрузка методов ---");
        printEmployee(employees[0]);
        printEmployee(employees[1], "Подробно: ");
    }

    // Перегруженные методы (статический полиморфизм)
    public static void printEmployee(Employee emp) {
        System.out.println("Сотрудник: " + emp.getName());
    }

    public static void printEmployee(Employee emp, String message) {
        System.out.println(message + emp.getInfo());
    }
}