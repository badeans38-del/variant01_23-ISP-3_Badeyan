package lab17;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Работа с Enum (Статусы сотрудников) ===\n");

        // 1. Демонстрация enum
        System.out.println("1. Все возможные статусы:");
        for (EmployeeStatus status : EmployeeStatus.values()) {
            System.out.println(status.getId() + ". " + status.name() +
                    " - " + status.getDescription() +
                    " (код: " + status.getDepartmentCode() + ")");
        }

        // 2. Создание сотрудников
        System.out.println("\n2. Создание сотрудников:");
        Employee emp1 = new Employee(101, "Иванов Иван", "Разработчик", 85000);
        Employee emp2 = new Employee(102, "Петрова Анна", "Менеджер", 95000);
        Employee emp3 = new Employee(103, "Сидоров Петр", "Стажер", 40000);

        // Установка испытательного срока для стажера
        emp3.changeStatus(EmployeeStatus.PROBATION);

        // Вывод информации
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

        // 3. Изменение статусов
        System.out.println("\n3. Изменение статусов:");

        // Иванов идет в отпуск
        emp1.goOnLeave(14);
        System.out.println(emp1);

        // Петрова возвращается из отпуска (не работает, т.к. не в отпуске)
        emp2.returnFromLeave();

        // Сидоров успешно проходит испытательный срок
        System.out.println("\nСидоров проходит испытательный срок:");
        if (emp3.changeStatus(EmployeeStatus.ACTIVE)) {
            System.out.println("Испытательный срок пройден успешно!");
        }
        System.out.println(emp3);

        // 4. Некорректные смены статусов
        System.out.println("\n4. Некорректные попытки смены статуса:");

        // Попытка уволить того, кто уже уволен
        Employee firedEmp = new Employee(104, "Уволенный", "Бывший", 0);
        firedEmp.fire("Сокращение");
        firedEmp.changeStatus(EmployeeStatus.ACTIVE); // Не должно сработать

        // 5. Работа с методами enum
        System.out.println("\n5. Проверки через методы enum:");

        System.out.println("Можно ли перейти из ACTIVE в ON_LEAVE? " +
                EmployeeStatus.ACTIVE.canChangeTo(EmployeeStatus.ON_LEAVE));

        System.out.println("Можно ли перейти из FIRED в ACTIVE? " +
                EmployeeStatus.FIRED.canChangeTo(EmployeeStatus.ACTIVE));

        // 6. Поиск по id
        System.out.println("\n6. Поиск статуса по ID:");
        EmployeeStatus statusById = EmployeeStatus.getById(2);
        if (statusById != null) {
            System.out.println("Статус с ID=2: " + statusById.getDescription());
        }

        // 7. Подготовка к сериализации в файл (будущая работа)
        System.out.println("\n7. Подготовка к сохранению в файл:");
        System.out.println("Данные для файла: " + emp1.toFileString());
        System.out.println("Данные для файла: " + emp2.toFileString());

        // 8. Массив сотрудников
        System.out.println("\n8. Все сотрудники компании:");
        Employee[] employees = {emp1, emp2, emp3};
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // 9. Подсчет по статусам
        System.out.println("\n9. Статистика по статусам:");
        int activeCount = 0, onLeaveCount = 0, firedCount = 0;

        for (Employee emp : employees) {
            switch (emp.getStatus()) {
                case ACTIVE: activeCount++; break;
                case ON_LEAVE: onLeaveCount++; break;
                case FIRED: firedCount++; break;
                case PROBATION: activeCount++; break;
            }
        }

        System.out.println("Работают: " + activeCount);
        System.out.println("В отпуске: " + onLeaveCount);
        System.out.println("Уволены: " + firedCount);
    }
}