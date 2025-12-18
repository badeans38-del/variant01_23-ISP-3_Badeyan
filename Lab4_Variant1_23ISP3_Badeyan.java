import java.util.Scanner;
public class Lab4_Variant1_23ISP3_Badeyan {
    static void printArray(int[] a) {
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 зад
        System.out.print("Введите размер массива (не больше 100): ");
        int n = sc.nextInt();
        if (n > 100) {
            System.out.println("Ошибка размер больше 100.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2 зад
        int max = arr[0];
        int indexMax = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                indexMax = i;
            }
        }

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Его индекс: " + indexMax);

        // 3 зад
        System.out.println("Массив в прямом порядке:");
        printArray(arr);


        System.out.println("Массив в обратном порядке:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
