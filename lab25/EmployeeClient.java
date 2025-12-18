package lab25;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EmployeeClient {
    public static void main(String[] args) {
        System.out.println("=== Клиент сотрудников ===");

        Scanner scanner = new Scanner(System.in);

        try {
            // Подключаемся к серверу
            Socket socket = new Socket("localhost", 5555);
            System.out.println("Подключились к серверу");

            // Получаем потоки
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(out, StandardCharsets.UTF_8), true);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in, StandardCharsets.UTF_8));

            // Меню команд
            while (true) {
                System.out.println("\n--- Меню ---");
                System.out.println("1. Рассчитать зарплату");
                System.out.println("2. Проверить бонус");
                System.out.println("3. Получить информацию о сотруднике");
                System.out.println("4. Помощь");
                System.out.println("0. Выход");
                System.out.print("Выберите действие: ");

                String choice = scanner.nextLine();

                if (choice.equals("0")) {
                    System.out.println("Выход...");
                    break;
                }

                String command = "";

                switch (choice) {
                    case "1":
                        System.out.print("Введите должность: ");
                        String position = scanner.nextLine();
                        System.out.print("Введите ставку: ");
                        String salary = scanner.nextLine();
                        System.out.print("Введите часы: ");
                        String hours = scanner.nextLine();
                        command = "CALCULATE_SALARY:" + position + ":" + salary + ":" + hours;
                        break;

                    case "2":
                        System.out.print("Введите зарплату: ");
                        String salary2 = scanner.nextLine();
                        System.out.print("Введите эффективность (0-100): ");
                        String performance = scanner.nextLine();
                        command = "CHECK_BONUS:" + salary2 + ":" + performance;
                        break;

                    case "3":
                        System.out.print("Введите ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Введите имя: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите должность: ");
                        String position2 = scanner.nextLine();
                        command = "GET_INFO:" + id + ":" + name + ":" + position2;
                        break;

                    case "4":
                        command = "HELP";
                        break;

                    default:
                        System.out.println("Неверный выбор");
                        continue;
                }

                // Отправляем команду на сервер
                writer.println(command);
                System.out.println("Отправлено: " + command);

                // Получаем ответ от сервера
                String response = reader.readLine();
                System.out.println("Ответ сервера: " + response);
            }

            // Закрываем соединение
            writer.close();
            reader.close();
            socket.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
            System.out.println("Убедитесь, что сервер запущен на localhost:5555");
        }
    }
}