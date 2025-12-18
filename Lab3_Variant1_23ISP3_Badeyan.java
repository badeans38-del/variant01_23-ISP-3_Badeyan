import java.util.Scanner;
public class Lab3_Variant1_23ISP3_Badeyan {
    public static void main(String[] args)
    {
        // Задача 1
        Scanner Chisla = new Scanner(System.in);
        System.out.print("Введите число: ");
        double chislo = Chisla.nextDouble();
        String resultat;
        if (chislo > 0) {
            resultat = "Положительное";
        } else if (chislo < 0) {
            resultat = "Отрицательное";
        } else {
            resultat = "Ноль";
        }
        System.out.println( + chislo + "  " + resultat);

        //Задача 14
        Scanner roli = new Scanner(System.in);
        System.out.print("Введите роль (admin, manager, user, иное): ");
        String role = roli.nextLine();
        String dostup = switch (role) {
            case "admin" -> "full";
            case "manager" -> "limited";
            case "user" -> "basic";
            default -> "denied";
        };

        System.out.println("Уровень доступа: " + dostup);



        // Задача 16

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число x: ");
        int x = scanner.nextInt();
        String result = (x > 0) ? "+" : (x < 0 ? "-" : "0");
        System.out.println("Знак числа: " + result);}}




