package lab10;

public abstract class CompanyEmployee extends Employee {

    protected int experience; // стаж в годах

    public CompanyEmployee(String name, String position, int experience) {
        super(name, position);
        this.experience = experience;
    }

    // реализуем часть логики
    public double experienceBonus() {
        return experience * 1000;
    }

    // новый абстрактный метод
    public abstract int getProductivity();
}
