package LAB11;

public class Worker extends Employee {
    private double ratePerHour;

    public Worker(String name, double ratePerHour, int hoursWorked) {
        super(name, "Рабочий", ratePerHour, hoursWorked);
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculatePay() {
        return this.ratePerHour * this.getHoursWorked();
    }

    @Override
    public String getInfo() {
        return "Рабочий: " + this.getName() +
                ", ставка: " + this.ratePerHour +
                ", часов: " + this.getHoursWorked() +
                ", итог: " + this.calculatePay();
    }
}