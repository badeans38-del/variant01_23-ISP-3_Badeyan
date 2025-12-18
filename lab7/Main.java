package lab7;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация перегрузки и переопределения ===");

        BankAccount acc1 = new BankAccount(1000);
        acc1.deposit(500);
        acc1.deposit(200.75);
        acc1.deposit(10, 50);

        System.out.println(acc1.toString());

        PremiumAccount acc2 = new PremiumAccount(1000);
        acc2.deposit(500);
        acc2.deposit(200.75);
        acc2.deposit(10, 50);

        System.out.println(acc2.toString());
    }}