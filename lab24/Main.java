package lab24;


import java.io.*;
import java.io.*;
import java.io.*;

class Employee implements Serializable {
    int id;
    String name;
    double salary;

    public String toString() {
        return id + ". " + name + " - " + salary + " руб.";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Десериализация. ЧТЕНИЕ ФАЙЛА ИЗ ЛАБ_23 ===");

        // 1. Создаем файл с объектом (если его нет)
        File file = new File("employee.ser");
        if (!file.exists()) {
            System.out.println("Создаю файл для примера...");
            createTestFile();
        }

        // 2. Десериализация (чтение из файла)
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Employee emp = (Employee) in.readObject();

            in.close();
            fileIn.close();

            System.out.println("\nОбъект восстановлен:");
            System.out.println("ID: " + emp.id);
            System.out.println("Имя: " + emp.name);
            System.out.println("Зарплата: " + emp.salary);
            System.out.println("toString(): " + emp);

            // Анализ
            System.out.println("\n--- Анализ ---");
            System.out.println("1. Конструктор Employee НЕ вызывался");
            System.out.println("2. Объект восстановлен из байтов");
            System.out.println("3. Все поля совпадают с записанными");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Готово ===");
    }

    // Метод для создания тестового файла
    static void createTestFile() {
        try {
            Employee emp = new Employee();
            emp.id = 101;
            emp.name = "Иванов";
            emp.salary = 85000;

            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();

            System.out.println("Файл создан: employee.ser");
        } catch (IOException e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }
    }
}