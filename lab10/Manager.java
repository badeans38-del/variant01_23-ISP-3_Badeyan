package lab10;

public class Manager extends CompanyEmployee {

    private int subordinatesCount;

    public Manager(String name, int experience, int subordinatesCount) {
        super(name, "Менеджер", experience);
        this.subordinatesCount = subordinatesCount;
    }

    @Override
    public double calculateSalary() {
        return 50000 + experienceBonus() + subordinatesCount * 2000;
    }

    @Override
    public int getProductivity() {
        return subordinatesCount * 10;
    }
}
