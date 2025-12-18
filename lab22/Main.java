package lab22;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Собственные исключения ===");

        // 1. Проверка возраста
        System.out.print("\n1. Введите возраст: ");
        try {
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Возраст корректен: " + age);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка возраста: " + e.getMessage());
            System.out.println("Введено: " + e.getInvalidValue());
        }

        // 2. Проверка зарплаты
        System.out.print("\n2. Введите зарплату: ");
        try {
            double salary = scanner.nextDouble();
            validateSalary(salary);
            System.out.println("Зарплата корректна: " + salary);
        } catch (InvalidSalaryException e) {
            System.out.println("Ошибка зарплаты: " + e.getMessage());
        }

        // 3. Создание сотрудника
        System.out.println("\n3. Создание сотрудника:");
        try {
            Employee emp = new Employee("", "Разработчик", -5000);
            System.out.println("Создан: " + emp);
        } catch (InvalidEmployeeDataException e) {
            System.out.println("Ошибка сотрудника: " + e.getMessage());
        }

        // 4. Нормальный сотрудник
        System.out.println("\n4. Нормальный сотрудник:");
        try {
            Employee emp = new Employee("Иванов", "Менеджер", 80000);
            System.out.println("Создан: " + emp);
        } catch (InvalidEmployeeDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть отрицательным", age);
        }
        if (age > 150) {
            throw new InvalidAgeException("Слишком большой возраст", age);
        }
        if (age < 18) {
            throw new InvalidAgeException("Возраст меньше 18 лет", age);
        }
    }

    static void validateSalary(double salary) throws InvalidSalaryException {
        if (salary <= 0) {
            throw new InvalidSalaryException("Зарплата должна быть > 0: " + salary);
        }
        if (salary > 1_000_000) {
            throw new InvalidSalaryException("Зарплата слишком большая: " + salary);
        }
    }
}

// 1. Исключение для возраста
class InvalidAgeException extends Exception {
    private int invalidValue;

    public InvalidAgeException(String message, int invalidValue) {
        super(message);
        this.invalidValue = invalidValue;
    }

    public int getInvalidValue() {
        return invalidValue;
    }
}

// 2. Исключение для зарплаты
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// 3. Исключение для данных сотрудника
class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}

// Класс Employee с проверками
class Employee {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) throws InvalidEmployeeDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Имя не может быть пустым");
        }
        if (position == null || position.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Должность не может быть пустой");
        }
        if (salary <= 0) {
            throw new InvalidEmployeeDataException("Зарплата должна быть > 0");
        }

        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " + position + " (" + salary + " руб.)";
    }
}