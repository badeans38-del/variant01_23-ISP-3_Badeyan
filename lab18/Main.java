package lab18;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generics в работе с сотрудниками ===\n");

        // Создаем объекты
        Employee emp1 = new Employee(1, "Иванов", "Разработчик", 85000);
        Employee emp2 = new Employee(2, "Петрова", "Менеджер", 95000);
        Department dept1 = new Department("IT", 10);
        Department dept2 = new Department("HR", 5);

        // 1. Демонстрация обобщенного контейнера
        System.out.println("1. Обобщенный контейнер для Employee:");
        CompanyContainer<Employee> employeeContainer = new CompanyContainer<>("Сотрудники компании");
        employeeContainer.addItem(emp1);
        employeeContainer.addItem(emp2);
        employeeContainer.printContainerInfo();
        employeeContainer.printAllItems();

        System.out.println("\n2. Обобщенный контейнер для Department:");
        CompanyContainer<Department> deptContainer = new CompanyContainer<>("Отделы компании", dept1);
        deptContainer.addItem(dept2);
        deptContainer.printAllItems();

        // 3. Получение элементов
        System.out.println("\n3. Получение элементов по индексу:");
        Employee retrievedEmp = employeeContainer.getItem(0);
        System.out.println("Первый сотрудник: " + retrievedEmp);

        // 4. Класс с ограничением типа
        System.out.println("\n4. Класс с ограничением (extends Employee):");
        SalaryCalculator<Employee> calculator = new SalaryCalculator<>(emp1);
        calculator.printSalaryInfo();

        // Использование обобщенного метода
        calculator.calculateBonus(15); // Integer
        calculator.calculateBonus(12.5); // Double

        // 5. Попытка создать SalaryCalculator для Department (не скомпилируется)
        // SalaryCalculator<Department> wrong = new SalaryCalculator<>(dept1); // ОШИБКА!

        // 6. Разные типы в одном коде
        System.out.println("\n5. Работа с разными типами:");
        CompanyContainer<Object> mixedContainer = new CompanyContainer<>("Разные объекты");
        mixedContainer.addItem(emp1);
        mixedContainer.addItem(dept1);
        mixedContainer.addItem("Строка");
        mixedContainer.addItem(123);
        mixedContainer.printAllItems();

        // 7. Метод с параметром типа
        System.out.println("\n6. Использование методов с параметром типа:");
        System.out.println("Сотрудников в контейнере: " + employeeContainer.getCount());
        System.out.println("Отделов в контейнере: " + deptContainer.getCount());

        // 8. Безопасность типов
        System.out.println("\n7. Типобезопасность:");
        // Это работает:
        Employee e = employeeContainer.getItem(0);
        e.getName(); // OK

        // Это НЕ скомпилируется:
        // Department d = employeeContainer.getItem(0); // ОШИБКА компиляции
        // String s = employeeContainer.getItem(0); // ОШИБКА компиляции

        System.out.println("\nВсе операции завершены успешно!");
    }
}