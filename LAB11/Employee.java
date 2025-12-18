package LAB11;

public abstract class Employee {
    private String name;
    private String position;
    private double salary;
    private int hoursWorked;

    public Employee(String name, String position, double salary, int hoursWorked) {
        this.setName(name);
        this.setPosition(position);
        this.setSalary(salary);
        this.setHoursWorked(hoursWorked);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = "Неизвестный";
        }
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        if (position != null && !position.isEmpty()) {
            this.position = position;
        } else {
            this.position = "Без должности";
        }
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        } else {
            this.salary = 0.0;
        }
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public abstract double calculatePay();

    public abstract String getInfo();
}