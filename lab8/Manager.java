package lab8;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int hoursWorked, double bonus) {
        super(name, "Менеджер", salary, hoursWorked);
        this.bonus = bonus;
    }

    // Переопределение метода расчёта зарплаты
   @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }

   @Override
    public String getInfo() {
        return "Менеджер: " + getName() + ", ставка: " + getSalary() +
                ", бонус: " + bonus + ", итог: " + calculatePay();
    }
}