package lab23;
import java.io.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ");

        // 1. Проверяем существование файла
        File file = new File("employee.ser");
        if (!file.exists()) {
            System.out.println("Файл employee.ser не найден!");
            System.out.println("g");
            return;
        }

        System.out.println("Файл найден: " + file.getAbsolutePath());
        System.out.println("Размер: " + file.length() + " байт");

        // 2. Десериализация
        try {
            System.out.println("\n---  ---");
            System.out.println("ВАЖНО: конструктор Employee НЕ будет вызван!");

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Читаем объект
            Employee emp = (Employee) ois.readObject();

            ois.close();
            fis.close();

            // 3. Вывод восстановленных данных
            System.out.println("\n--- Восстановленный объект ---");
            System.out.println("ID: " + emp.getId());
            System.out.println("Имя: " + emp.getName());
            System.out.println("Должность: " + emp.getPosition());
            System.out.println("Зарплата: " + emp.getSalary());
            System.out.println("Пароль: " + emp.getPassword() + " (transient поле)");

            System.out.println("\n--- Анализ ---");
            System.out.println("1. Конструктор не вызывался - объект восстановлен из байтов");
            System.out.println("2. Поля 'id', 'name', 'position', 'salary' восстановлены");
            System.out.println("3. Поле 'password' = null (помечено как transient)");
            System.out.println("4. Объект идентичен сохраненному");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Лаба 23 завершена ===");
    }
}