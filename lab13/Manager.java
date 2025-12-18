package lab13;

public class Manager extends Employee implements BonusCalculable {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    // реализация абстрактного метода Employee
    @Override
    public double calculatePay() {
        return salary + bonus;
    }

    // реализация методов интерфейса
    @Override
    public double calculateBonus() {
        return bonus * 1.5;
    }

    @Override
    public String getBonusInfo() {
        return "Бонус менеджера: " + bonus;
    }

    // собственный метод
    public void conductMeeting() {
        System.out.println(name + " проводит совещание");
    }
}