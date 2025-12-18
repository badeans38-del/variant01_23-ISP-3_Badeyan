package LAB12;



public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int hoursWorked, double bonus) {
        super(name, "Менеджер", salary, hoursWorked);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return (getSalary() * getHoursWorked()) + bonus;
    }

    @Override
    public String getInfo() {
        return "Менеджер: " + getName() +
                ", ставка: " + getSalary() +
                ", бонус: " + bonus +
                ", зарплата: " + calculatePay();
    }

    public double getBonus() {
        return bonus;
    }
}