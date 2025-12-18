package lab8;

public abstract class Employee {
    private String name;
    private String position;
    private double salary;
    private int hoursWorked;


    public Employee(String name, String position, double salary, int hoursWorked) {
        setName(name);
        setPosition(position);
        setSalary(salary);
        setHoursWorked(hoursWorked);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
        else
            this.name = "Неизвестный";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position != null && !position.isEmpty())
            this.position = position;
        else
            this.position = "Без должности";
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0)
            this.salary = salary;
        else
            this.salary = 0;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

//    public void setHoursWorked(int hoursWorked) {
//        if (hoursWorked >= 0)
//            this.hoursWorked = hoursWorked;
//        else
//            this.hoursWorked = 0;
//    }


    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay() {
        return salary * hoursWorked;
    }

    public String getInfo() {
        return "Сотрудник: " + name + ", должность: " + position + ", ставка: " + salary;
    }


}