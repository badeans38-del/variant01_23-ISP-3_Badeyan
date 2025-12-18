package lab19;
import java.io.*;
import java.util.List;

public class FileManager {

    // Создание директории
    public static boolean createDirectory(String path) {
        File directory = new File(path);

        if (directory.exists()) {
            System.out.println("Директория уже существует: " + path);
            return true;
        }

        if (directory.mkdirs()) {
            System.out.println("Директория создана: " + path);
            return true;
        } else {
            System.out.println("Ошибка создания директории: " + path);
            return false;
        }
    }

    // Запись списка сотрудников в файл через FileWriter
    public static void writeEmployeesToFile(List<Employee> employees, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Employee emp : employees) {
                writer.write(emp.toString() + "\n");
            }
            System.out.println("Данные записаны в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    // Запись через BufferedWriter (более эффективно)
    public static void writeEmployeesWithBuffer(List<Employee> employees, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
            System.out.println("Данные записаны (BufferedWriter): " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Запись через PrintWriter (удобный форматированный вывод)
    public static void writeEmployeesWithPrintWriter(List<Employee> employees, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("=== Список сотрудников компании ===");
            writer.println("ID;Имя;Должность;Зарплата");

            for (Employee emp : employees) {
                writer.println(emp.toString());
            }

            writer.println("=== Всего сотрудников: " + employees.size() + " ===");
            System.out.println("Данные записаны (PrintWriter): " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Проверка существования директории
    public static void checkDirectory(String path) {
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Проверка: директория " + path + " существует");
            System.out.println("Путь: " + dir.getAbsolutePath());

            // Показать файлы в директории
            String[] files = dir.list();
            if (files != null && files.length > 0) {
                System.out.println("Файлы в директории:");
                for (String file : files) {
                    System.out.println("  - " + file);
                }
            } else {
                System.out.println("Директория пуста");
            }
        } else {
            System.out.println("Директория не существует или это не директория");
        }
    }
}