package lab8;

public class Worker extends Employee {
    private double ratePerHour;

    public Worker(String name, double ratePerHour, int hoursWorked) {
        super(name, "Рабочий", ratePerHour, hoursWorked);
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculatePay() {
        return ratePerHour * getHoursWorked();
    }

     @Override
    public String getInfo() {
        return "Рабочий: " + getName() + ", ставка: " + ratePerHour +
                ", часов: " + getHoursWorked() + ", итог: " + calculatePay();
    }
}