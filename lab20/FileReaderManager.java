package lab20;
import java.io.*;

public class FileReaderManager {

    // 1. Чтение файла построчно через FileReader и BufferedReader
    public static void readFileBasic(String filePath) {
        System.out.println("\n=== Способ 1: FileReader + BufferedReader ===");

        File file = new File(filePath);

        // Проверка существования файла
        if (!file.exists()) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        if (!file.isFile()) {
            System.out.println("Указанный путь не является файлом: " + filePath);
            return;
        }

        System.out.println("Чтение файла: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + file.length() + " байт");

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Создание потоков
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            int lineNumber = 1;

            System.out.println("\nСодержимое файла:");
            System.out.println("------------------");

            // Чтение построчно
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Строка " + lineNumber + ": " + line);
                lineNumber++;
            }

            System.out.println("------------------");
            System.out.println("Чтение завершено. Прочитано строк: " + (lineNumber - 1));

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } finally {
            // Закрытие потоков в finally блоке
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
                System.out.println("Потоки успешно закрыты");
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии потоков: " + e.getMessage());
            }
        }
    }

    // 2. Чтение с помощью try-with-resources (автоматическое закрытие)
    public static void readFileWithResources(String filePath) {
        System.out.println("\n=== Способ 2: try-with-resources ===");

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        // Автоматическое закрытие потоков
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            System.out.println("Чтение файла: " + file.getName());
            System.out.println("---------------------------");

            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }

            System.out.println("---------------------------");
            System.out.println("Всего строк: " + count);

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        // Потоки закрываются автоматически
    }

    // 3. Чтение и преобразование в объекты Employee
    public static void readEmployeesFromFile(String filePath) {
        System.out.println("\n=== Чтение сотрудников из файла ===");

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Файл с сотрудниками не найден!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            System.out.println("Список сотрудников из файла:");
            System.out.println("=============================");

            String line;
            int employeeCount = 0;

            while ((line = reader.readLine()) != null) {
                // Пропускаем заголовочные строки
                if (line.startsWith("===") || line.startsWith("ID;")) {
                    continue;
                }

                // Пропускаем пустые строки
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Преобразуем строку в объект Employee
                Employee emp = Employee.fromString(line);
                if (emp != null) {
                    System.out.println(emp);
                    employeeCount++;
                }
            }

            System.out.println("=============================");
            System.out.println("Всего сотрудников прочитано: " + employeeCount);

        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    // 4. Чтение всего файла в список строк
    public static void readAllLines(String filePath) {
        System.out.println("\n=== Чтение всех строк в список ===");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            int totalLines = 0;

            System.out.println("Построчный вывод:");

            while ((line = reader.readLine()) != null) {
                totalLines++;
                System.out.printf("%3d: %s%n", totalLines, line);
            }

            System.out.println("Итого строк в файле: " + totalLines);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}