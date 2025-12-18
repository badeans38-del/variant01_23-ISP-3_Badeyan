package lab7;

public class PremiumAccount extends BankAccount {

    public PremiumAccount(double startBalance) {
        super(startBalance);
    }


    @Override
    public void deposit(double amount) {
        double bonus = amount * 0.05;
        super.deposit(amount + bonus);
    }


     @Override
    public String toString() {
        return "PremiumAccount: баланс (с бонусами) = " + getBalance() + " руб.";
    }
}