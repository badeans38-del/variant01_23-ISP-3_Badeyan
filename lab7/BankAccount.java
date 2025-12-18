package lab7;

public class BankAccount {
    private double balance;


    public BankAccount(double startBalance) {
        balance = startBalance;
    }


    public void deposit(int amount) {
        balance += amount;
    }


    public void deposit(double amount) {
        balance += amount;
    }


    public void deposit(int rub, int kop) {
        balance += rub + kop / 100.0;
    }


    public double getBalance() {
        return balance;
    }


    public String toString() {
        return "BankAccount: баланс = " + balance + " руб.";
    }
}