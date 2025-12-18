package LAB12;



public class Worker extends Employee {
    public Worker(String name, double ratePerHour, int hoursWorked) {
        super(name, "Рабочий", ratePerHour, hoursWorked);
    }

    @Override
    public double calculatePay() {
        return getSalary() * getHoursWorked();
    }

    @Override
    public String getInfo() {
        return "Рабочий: " + getName() +
                ", ставка: " + getSalary() +
                ", часов: " + getHoursWorked() +
                ", зарплата: " + calculatePay();
    }
}