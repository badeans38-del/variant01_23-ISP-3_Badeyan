package lab25;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class EmployeeServer {
    public static void main(String[] args) {
        System.out.println("=== Сервер сотрудников запущен ===");

        try (ServerSocket serverSocket = new ServerSocket(5555)) {
            System.out.println("Ожидание подключения клиента...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress());

                // Обработка клиента в отдельном потоке
                new Thread(() -> handleClient(clientSocket)).start();
            }

        } catch (IOException e) {
            System.out.println("Ошибка сервера: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(in, StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(out, StandardCharsets.UTF_8), true)
        ) {
            // Читаем команду от клиента
            String command = reader.readLine();
            System.out.println("Получено от клиента: " + command);

            // Обрабатываем команду
            String response = processCommand(command);

            // Отправляем ответ
            writer.println(response);
            System.out.println("Отправлен ответ: " + response);

        } catch (IOException e) {
            System.out.println("Ошибка обработки клиента: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // Игнорируем ошибку закрытия
            }
        }
    }

    private static String processCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return "Ошибка: пустая команда";
        }

        String[] parts = command.split(":", 2);
        if (parts.length < 2) {
            return "Ошибка: неверный формат команды";
        }

        String action = parts[0].trim();
        String data = parts[1].trim();

        switch (action) {
            case "CALCULATE_SALARY":
                return calculateSalary(data);
            case "CHECK_BONUS":
                return checkBonus(data);
            case "GET_INFO":
                return getEmployeeInfo(data);
            case "HELP":
                return "Доступные команды:\n" +
                        "CALCULATE_SALARY:position:salary:hours\n" +
                        "CHECK_BONUS:salary:performance\n" +
                        "GET_INFO:id:name:position\n" +
                        "HELP";
            default:
                return "Ошибка: неизвестная команда: " + action;
        }
    }

    private static String calculateSalary(String data) {
        try {
            String[] params = data.split(":");
            String position = params[0];
            double salary = Double.parseDouble(params[1]);
            int hours = Integer.parseInt(params[2]);

            double result = salary * hours;

            if (position.equalsIgnoreCase("manager")) {
                result += 5000; // Бонус менеджерам
            }

            return String.format("Зарплата %s за %d часов: %.2f руб.",
                    position, hours, result);
        } catch (Exception e) {
            return "Ошибка расчета зарплаты: " + e.getMessage();
        }
    }

    private static String checkBonus(String data) {
        try {
            String[] params = data.split(":");
            double salary = Double.parseDouble(params[0]);
            int performance = Integer.parseInt(params[1]);

            if (performance >= 90) {
                double bonus = salary * 0.2;
                return String.format("Бонус 20%%: %.2f руб. Итого: %.2f руб.",
                        bonus, salary + bonus);
            } else if (performance >= 70) {
                double bonus = salary * 0.1;
                return String.format("Бонус 10%%: %.2f руб. Итого: %.2f руб.",
                        bonus, salary + bonus);
            } else {
                return "Бонус не начислен";
            }
        } catch (Exception e) {
            return "Ошибка расчета бонуса: " + e.getMessage();
        }
    }

    private static String getEmployeeInfo(String data) {
        try {
            String[] params = data.split(":");
            int id = Integer.parseInt(params[0]);
            String name = params[1];
            String position = params[2];

            return String.format("Сотрудник #%d: %s, %s. Статус: ACTIVE",
                    id, name, position);
        } catch (Exception e) {
            return "Ошибка получения информации: " + e.getMessage();
        }
    }
}