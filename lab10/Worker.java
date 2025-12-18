package lab10;

public class Worker extends CompanyEmployee {

    private int hoursWorked;

    public Worker(String name, int experience, int hoursWorked) {
        super(name, "Рабочий", experience);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * 300 + experienceBonus();
    }

    @Override
    public int getProductivity() {
        return hoursWorked;
    }
}