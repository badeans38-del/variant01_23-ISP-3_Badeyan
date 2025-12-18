package lab16;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Анонимные классы ===\n");

        // 1. Обычная реализация (для сравнения)
        System.out.println("1. Обычная реализация класса:");
        RegularWorker regular = new RegularWorker();
        regular.doWork();
        System.out.println(regular.getTask());

        // 2. Анонимный класс от интерфейса
        System.out.println("\n2. Анонимный класс от интерфейса:");
        Workable anonymous = new Workable() {
            @Override
            public void doWork() {
                System.out.println("Анонимная работа (без отдельного класса)");
            }

            @Override
            public String getTask() {
                return "Задача в анонимном классе";
            }
        };
        anonymous.doWork();
        System.out.println(anonymous.getTask());

        // 3. Анонимный класс от абстрактного класса
        System.out.println("\n3. Анонимный класс от абстрактного Employee:");
        Employee emp = new Employee("Петров") {
            @Override
            public void work() {
                System.out.println(name + " работает по-особому");
            }
        };
        emp.work();

        // 4. Передача анонимного объекта в метод
        System.out.println("\n4. Передача анонимного объекта в метод:");
        processEmployee(new Employee("Сидоров") {
            @Override
            public void work() {
                System.out.println(name + " работает на проекте");
            }
        });

        // 5. Лямбда для функционального интерфейса (сравнение)
        System.out.println("\n5. Лямбда vs анонимный класс:");

        // Анонимный класс
        Calculator anonCalc = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Анонимный: " + anonCalc.calculate(5, 3));

        // Лямбда (тоже самое, но короче)
        Calculator lambdaCalc = (a, b) -> a * b;
        System.out.println("Лямбда: " + lambdaCalc.calculate(5, 3));

        // 6. Несколько разных анонимных реализаций
        System.out.println("\n6. Разные анонимные реализации:");
        Workable[] workers = {
                new Workable() { // 1-я реализация
                    public void doWork() { System.out.println("Работа 1"); }
                    public String getTask() { return "Задача 1"; }
                },
                new Workable() { // 2-я реализация
                    public void doWork() { System.out.println("Работа 2"); }
                    public String getTask() { return "Задача 2"; }
                }
        };

        for (Workable w : workers) {
            w.doWork();
            System.out.println(w.getTask());
        }
    }

    static void processEmployee(Employee emp) {
        emp.showInfo();
        emp.work();
    }
}

// Обычная реализация (для сравнения с анонимной)
class RegularWorker implements Workable {
    @Override
    public void doWork() {
        System.out.println("Обычная работа");
    }

    @Override
    public String getTask() {
        return "Обычная задача";
    }
}

// Функциональный интерфейс для лямбды
interface Calculator {
    int calculate(int a, int b);
}