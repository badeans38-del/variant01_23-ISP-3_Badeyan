package LAB11;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int hoursWorked, double bonus) {
        super(name, "Менеджер", salary, hoursWorked);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return this.getSalary() * this.getHoursWorked() + this.bonus;
    }

    @Override
    public String getInfo() {
        return "Менеджер: " + this.getName() +
                ", ставка: " + this.getSalary() +
                ", бонус: " + this.bonus +
                ", итог: " + this.calculatePay();
    }
}