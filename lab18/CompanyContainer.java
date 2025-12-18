package lab18;
import java.util.ArrayList;

public class CompanyContainer<T> {
    private ArrayList<T> items;
    private String containerName;

    // Конструктор 1: пустой контейнер
    public CompanyContainer(String containerName) {
        this.containerName = containerName;
        this.items = new ArrayList<>();
    }

    // Конструктор 2: с начальным элементом
    public CompanyContainer(String containerName, T initialItem) {
        this.containerName = containerName;
        this.items = new ArrayList<>();
        this.items.add(initialItem);
    }

    // 1. Обычный метод (без параметра типа в сигнатуре)
    public void printContainerInfo() {
        System.out.println("Контейнер: " + containerName);
        System.out.println("Количество элементов: " + items.size());
    }

    // 2. Метод с использованием параметра типа T
    public void addItem(T item) {
        items.add(item);
        System.out.println("Добавлен: " + item);
    }

    // 3. Метод возвращающий элемент по индексу
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    // 4. Метод для вывода всех элементов
    public void printAllItems() {
        System.out.println("\nВсе элементы в " + containerName + ":");
        for (T item : items) {
            System.out.println("  - " + item);
        }
    }

    // 5. Метод подсчета элементов
    public int getCount() {
        return items.size();
    }
}