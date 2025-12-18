public class Lab6_Variant1_23ISP3_Badeyan {

    public static class Point2D {
        private int x;
        private int y;

        // a) Конструктор по умолчанию
        public Point2D() {
            this(0,0);
        }

        // b) Параметризованный конструктор
        public Point2D(int x1, int y) {
            x = x1;
            this.y = y;
        }

        // c) Копирующий конструктор
        public Point2D(Point2D dfgf) {
            this.x = dfgf.x;
            this.y = dfgf.y;
        }

        // Метод 1: Манхэттенское расстояние
        public int manhattan() {
            return Math.abs(x) + Math.abs(y);
        }

        // Метод 2: Обычное расстояние до начала координат
        public double distanceToOrigin() {
            return Math.sqrt(x * x + y * y);
        }

        // Переопределение toString()
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Главный метод main
    public static void main(String[] args) {
        // Объект с конструктором по умолчанию
        Point2D p1 = new Point2D();
        int f = 5;
        System.out.println("p1 (по умолчанию): " + p1);

        // Объект с параметрами
        Point2D p2 = new Point2D(3, 4);
        System.out.println("p2 (параметры): " + p2);

        // Копия объекта p2
        Point2D p3 = new Point2D(p2);
        System.out.println("p3 (копия p2): " + p3);

        // Вызов методов
        System.out.println("Манхэттенское расстояние p2: " + p2.manhattan());
        System.out.println("Обычное расстояние p2: " + p2.distanceToOrigin());
    }
}
