package lab8;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация инкапсуляции, наследования и полиморфизма ===");



        Manager man1 = new Manager("Петров", 600, 22, 5000);
        Worker w1 = new Worker("Ондоров", 300, 25);

        // Полиморфизм — общий тип Employee, но разное поведение
        Employee[] employees = { man1, w1 }; // добавляем только Manager и Worker

        for (Employee e : employees) {
            System.out.println(e.getInfo());
        }
    }
}