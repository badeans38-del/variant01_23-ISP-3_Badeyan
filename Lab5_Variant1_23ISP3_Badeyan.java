public class Lab5_Variant1_23ISP3_Badeyan {
    // 1. Метод max(int a, int b) — возвращает большее число
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 2. Метод isEven(int n) — возвращает true, если число чётное
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // 3. Метод sign(int x) — возвращает -1, 0 или 1
    public static int sign(int x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println("max(10, 20) = " + max(10, 20));
        System.out.println("max(-5, -3) = " + max(-5, -3));

        System.out.println("isEven(4) = " + isEven(4));
        System.out.println("isEven(7) = " + isEven(7));

        System.out.println("sign(15) = " + sign(15));
        System.out.println("sign(-8) = " + sign(-8));
        System.out.println("sign(0) = " + sign(0));
    }
}

