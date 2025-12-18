package lab20;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Чтение файлов ===");

        // Пробуем разные пути
        String[] possiblePaths = {
                "company_data",                           // Текущая директория
                "src/company_data",                       // Внутри src
                System.getProperty("user.dir") + "/company_data"  // Абсолютный путь
        };

        String baseDir = null;
        for (String path : possiblePaths) {
            File dir = new File(path);
            if (dir.exists() && dir.isDirectory()) {
                baseDir = path;
                System.out.println("Найдена папка company_data по пути: " + dir.getAbsolutePath());
                break;
            }
        }

        if (baseDir == null) {
            System.out.println("Папка company_data не найдена!");
            System.out.println("Запустите сначала лабу 19 для создания файлов.");

            // Создаем тестовый файл для демонстрации
            System.out.println("\n--- Создание тестового файла для демонстрации ---");
            createTestFile();
            FileReaderManager.readFileBasic("test_file.txt");
            return;
        }

        // ЕСЛИ ПАПКА НАЙДЕНА - выполняем основной код
        String employeesDir = baseDir + File.separator + "employees";

        String simpleFile = employeesDir + File.separator + "employees_simple.txt";
        String formattedFile = employeesDir + File.separator + "employees_formatted.txt";
        String bufferFile = employeesDir + File.separator + "employees_buffer.txt";
        String infoFile = baseDir + File.separator + "company_info.txt";

        // Проверка существования файлов перед чтением
        System.out.println("\n--- Проверка файлов ---");
        checkFiles(simpleFile, formattedFile, bufferFile, infoFile);

        // 1. Чтение простого файла (способ 1)
        FileReaderManager.readFileBasic(simpleFile);

        // 2. Чтение форматированного файла (способ 2)
        FileReaderManager.readFileWithResources(formattedFile);

        // 3. Чтение и преобразование в объекты Employee
        FileReaderManager.readEmployeesFromFile(simpleFile);

        // 4. Чтение файла с информацией о компании
        System.out.println("\n--- Информация о компании ---");
        FileReaderManager.readAllLines(infoFile);

        // 5. Чтение файла через BufferedWriter
        System.out.println("\n--- Файл из BufferedWriter ---");
        FileReaderManager.readFileWithResources(bufferFile);

        // 6. Попытка чтения несуществующего файла
        System.out.println("\n--- Попытка чтения несуществующего файла ---");
        String wrongFile = "несуществующий_файл.txt";
        FileReaderManager.readFileBasic(wrongFile);

        System.out.println("\n=== Все операции чтения завершены ===");
    }

    // Метод для проверки существования файлов
    private static void checkFiles(String... filePaths) {
        for (String path : filePaths) {
            File file = new File(path);
            if (file.exists()) {
                System.out.println("✓ Файл найден: " + path);
                System.out.println("  Размер: " + file.length() + " байт");
            } else {
                System.out.println("✗ Файл не найден: " + path);
            }
        }
    }

    private static void createTestFile() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter("test_file.txt")) {
            writer.println("1;Иванов;Разработчик;85000");
            writer.println("2;Петрова;Менеджер;95000");
            writer.println("3;Сидоров;Тестировщик;65000");
            System.out.println("Тестовый файл создан: test_file.txt");
        } catch (java.io.IOException e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }
    }
}