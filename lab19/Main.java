package lab19;
import java.util.LinkedList;
import java.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Работа с файлами (запись) ===\n");

        // 1. Создаем коллекцию сотрудников (LinkedList)
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Иванов Иван", "Разработчик", 85000.50));
        employees.add(new Employee(2, "Петрова Анна", "Менеджер", 95000.75));
        employees.add(new Employee(3, "Сидоров Петр", "Тестировщик", 65000.00));
        employees.add(new Employee(4, "Кузнецова Ольга", "Дизайнер", 75000.25));
        employees.add(new Employee(5, "Васильев Алексей", "Аналитик", 80000.00));

        System.out.println("Создана коллекция из " + employees.size() + " сотрудников");

        // 2. Создаем директорию для хранения данных
        String baseDir = "company_data";
        String employeesDir = baseDir + "/employees";

        System.out.println("\n--- Создание директорий ---");
        FileManager.createDirectory(baseDir);
        FileManager.createDirectory(employeesDir);

        // 3. Проверяем директории
        System.out.println("\n--- Проверка директорий ---");
        FileManager.checkDirectory(baseDir);

        // 4. Записываем данные в файл разными способами
        System.out.println("\n--- Запись в файлы ---");

        // Способ 1: FileWriter (простой)
        String file1 = employeesDir + "/employees_simple.txt";
        FileManager.writeEmployeesToFile(employees, file1);

        // Способ 2: BufferedWriter (эффективный)
        String file2 = employeesDir + "/employees_buffer.txt";
        FileManager.writeEmployeesWithBuffer(employees, file2);

        // Способ 3: PrintWriter (форматированный)
        String file3 = employeesDir + "/employees_formatted.txt";
        FileManager.writeEmployeesWithPrintWriter(employees, file3);

        // 5. Создаем дополнительный файл с информацией
        System.out.println("\n--- Дополнительная информация ---");
        String infoFile = baseDir + "/company_info.txt";
        writeCompanyInfo(infoFile, employees.size());

        // 6. Проверяем результат
        System.out.println("\n--- Итоговая проверка ---");
        FileManager.checkDirectory(employeesDir);

        System.out.println("\n=== Работа завершена ===");
        System.out.println("Проверьте созданные файлы в папке проекта:");
        System.out.println("1. " + new File(baseDir).getAbsolutePath());
    }

    // Дополнительный метод для записи информации о компании
    private static void writeCompanyInfo(String filePath, int employeeCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("=== Информация о компании ===");
            writer.println("Название: ООО 'Технологии'");
            writer.println("Дата создания отчета: " + java.time.LocalDate.now());
            writer.println("Всего сотрудников: " + employeeCount);
            writer.println("Директор: Сергеев Михаил");
            writer.println("=================================");
            System.out.println("Информация о компании записана в: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка записи информации: " + e.getMessage());
        }
    }}
