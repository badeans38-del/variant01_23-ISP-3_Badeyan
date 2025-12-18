package lab18;
public class SalaryCalculator<T extends Employee> {
    private T employee;

    public SalaryCalculator(T employee) {
        this.employee = employee;
    }

    public void printSalaryInfo() {
        System.out.println("Расчет зарплаты для: " + employee.getName());
        System.out.println("Должность: " + employee.getPosition());
        System.out.println("Зарплата: " + employee.getSalary() + " руб.");

        double tax = employee.getSalary() * 0.13;
        double netSalary = employee.getSalary() - tax;
        System.out.println("Налог (13%): " + tax + " руб.");
        System.out.println("Чистая зарплата: " + netSalary + " руб.");
    }

    // Исправлено: bonusPercent вместо bonbonPercent
    public <U extends Number> void calculateBonus(U bonusPercent) {
        double bonus = employee.getSalary() * (bonusPercent.doubleValue() / 100);
        System.out.println("Бонус (" + bonusPercent + "%): " + bonus + " руб.");
    }
}