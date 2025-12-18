package lab21;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Обработка исключений ===");

        // 1. Деление на ноль
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("1. Ошибка деления: " + e.getMessage());
        }

        // 2. Массив
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("2. Ошибка массива: " + e.getMessage());
        }

        // 3. Ввод
        System.out.print("3. Введите число: ");
        try {
            int num = scanner.nextInt();
            System.out.println("Вы ввели: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Не число!");
            scanner.next();
        }

        // 4. Свое исключение
        try {
            checkSalary(-1000);
        } catch (Exception e) {
            System.out.println("4. Моя ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    static void checkSalary(double salary) throws Exception {
        if (salary < 0) {
            throw new Exception("Зарплата < 0");
        }
        System.out.println("Зарплата OK: " + salary);
    }
}