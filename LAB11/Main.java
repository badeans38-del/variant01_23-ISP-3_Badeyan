package LAB11;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Работа со списком LinkedList ===");

        // 1. Создаём список и добавляем 5–7 объектов
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Worker("Иванов", 300.0, 160));
        employees.add(new Manager("Петров", 600.0, 160, 5000.0));
        employees.add(new Worker("Сидоров", 280.0, 150));
        employees.add(new Manager("Кузнецов", 700.0, 155, 6000.0));
        employees.add(new Worker("Михайлов", 310.0, 145));

        employees.removeIf(i->  i.getHoursWorked() <150);

        // Используем addFirst и addLast
        employees.addFirst(new Manager("Смирнов", 800.0, 170, 7000.0));
        employees.addLast(new Worker("Васильев", 290.0, 165));

        // 2. Выводим весь список
        System.out.println("\n--- Список после добавления ---");
        for (Employee e : employees) {
            System.out.println(e.getInfo());
        }

        // 3. Добавляем ещё элементы в начало и конец
        employees.addFirst(new Worker("Алексеев", 295.0, 140));
        employees.addLast(new Manager("Николаев", 750.0, 160, 5500.0));

        System.out.println("\n--- Список после addFirst/addLast ---");
        for (Employee e : employees) {
            System.out.println(e.getInfo());
        }

        // 4. Удаляем первый и последний элементы
        employees.removeFirst();
        employees.removeLast();

        System.out.println("\n--- Список после удаления первого и последнего ---");
        for (Employee e : employees) {
            System.out.println(e.getInfo());
        }

        // 5. Получаем первый и последний элементы без удаления
        System.out.println("\n--- Первый элемент ---");
        System.out.println(employees.getFirst().getInfo());

        System.out.println("\n--- Последний элемент ---");
        System.out.println(employees.getLast().getInfo());

        // 6. Находим первый элемент, удовлетворяющий условию
        // Условие: зарплата больше 600
        Employee firstHighSalary = employees.stream()
                .filter(e -> e.getSalary() > 600.0)
                .findFirst()
                .orElse(null);

        if (firstHighSalary != null) {
            System.out.println("\n--- Первый с зарплатой > 600 ---");
            System.out.println(firstHighSalary.getInfo());
        }

        // 7. Удаляем все элементы, удовлетворяющие условию
        // Условие: отработано меньше 155 часов
        employees.removeIf(e -> e.getHoursWorked() < 155);

        System.out.println("\n--- Список после удаления работников с hoursWorked < 155 ---");
        for (Employee e : employees) {
            System.out.println(e.getInfo());
        }

        // 8. Проверяем, пуст ли список, выводим размер
        System.out.println("\n--- Проверка списка ---");
        System.out.println("Список пуст? " + employees.isEmpty());
        System.out.println("Размер списка: " + employees.size());
    }
}