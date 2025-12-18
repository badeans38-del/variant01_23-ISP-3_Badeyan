package lab17;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String position;
    private double salary;
    private EmployeeStatus status;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.status = EmployeeStatus.ACTIVE; // Статус по умолчанию
    }

    // Метод изменения статуса с проверкой
    public boolean changeStatus(EmployeeStatus newStatus) {
        if (status.canChangeTo(newStatus)) {
            System.out.println(name + ": статус изменен с " + status.getDescription() +
                    " на " + newStatus.getDescription());
            this.status = newStatus;
            return true;
        } else {
            System.out.println("Ошибка: нельзя изменить статус " + status.getDescription() +
                    " на " + newStatus.getDescription());
            return false;
        }
    }

    // Метод для увольнения (специальный случай)
    public void fire(String reason) {
        if (status != EmployeeStatus.FIRED) {
            this.status = EmployeeStatus.FIRED;
            System.out.println(name + " уволен. Причина: " + reason);
        }
    }

    // Метод для выхода в отпуск
    public void goOnLeave(int days) {
        if (status == EmployeeStatus.ACTIVE && changeStatus(EmployeeStatus.ON_LEAVE)) {
            System.out.println(name + " ушел в отпуск на " + days + " дней");
        }
    }

    // Метод для возврата из отпуска
    public void returnFromLeave() {
        if (status == EmployeeStatus.ON_LEAVE) {
            changeStatus(EmployeeStatus.ACTIVE);
            System.out.println(name + " вернулся из отпуска");
        }
    }

    // Геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public EmployeeStatus getStatus() { return status; }

    // Сеттеры
    public void setPosition(String position) { this.position = position; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Имя: " + name +
                ", Должность: " + position +
                ", Зарплата: " + salary +
                ", Статус: " + status.getDescription() +
                " (код: " + status.getDepartmentCode() + ")";
    }

    // Метод для будущей сериализации в файл
    public String toFileString() {
        return id + ";" + name + ";" + position + ";" + salary + ";" + status.name();
    }
}