import java.util.ArrayList;

public class Lab9_Variant1_23ISP3_Badeyan {

    static class Sportsmen {
        private int Kod;
        private String Imya;
        private int Vozrast;
        private int Reyting;

        public Sportsmen(int kod, String imya, int vozrast, int reyting) {
            this.Kod = kod;
            this.Imya = imya;
            this.Vozrast = vozrast;
            this.Reyting = reyting;
        }

        public int getKod() { return Kod; }
        public String getImya() { return Imya; }
        public int getVozrast() { return Vozrast; }
        public int getReyting() { return Reyting; }

        public void setImya(String imya) { this.Imya = imya; }
        public void setVozrast(int vozrast) { this.Vozrast = vozrast; }
        public void setReyting(int reyting) { this.Reyting = reyting; }

        @Override
        public String toString() {
            return String.format("Sportsmen{Kod=%d, Imya='%s', Vozrast=%d, Reyting=%d}", Kod, Imya, Vozrast, Reyting);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Sportsmen)) return false;
            Sportsmen drugoy = (Sportsmen) o;
            return this.Kod == drugoy.Kod;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(Kod);
        }
    }

    public static void main(String[] args) {
        
        ArrayList<Sportsmen> SpisokSport = new ArrayList<>();

        Sportsmen s1 = new Sportsmen(1, "Ivan Petrov", 22, 78);
        Sportsmen s2 = new Sportsmen(2, "Petr Sokolov", 27, 85);
        Sportsmen s3 = new Sportsmen(3, "Sergey Ivanov", 30, 90);
        Sportsmen s4 = new Sportsmen(4, "Alexey Morozov", 24, 73);
        Sportsmen s5 = new Sportsmen(5, "Dmitry Fedorov", 19, 82);

        SpisokSport.add(s1);
        SpisokSport.add(s2);
        SpisokSport.add(s3);
        SpisokSport.add(s4);
        SpisokSport.add(s5);

        System.out.println("1) Начальный список спортсменов:");


        System.out.println("\n2a) Через цикл for:");
        for (int i = 0; i < SpisokSport.size(); i++) {
            System.out.println("index " + i + ": " + SpisokSport.get(i));
        }

        System.out.println("\n2b) Через цикл for-each:");
        for (Sportsmen sport : SpisokSport) {
            System.out.println(sport);
        }


        Sportsmen perviyNoviy = new Sportsmen(10, "Nikolay Startov", 26, 76);
        Sportsmen posledniyNoviy = new Sportsmen(11, "Maksim Konov", 28, 88);

        SpisokSport.add(0, perviyNoviy);
        SpisokSport.add(posledniyNoviy);

        System.out.println("\n3) После добавления в начало и конец:");
        for (int i = 0; i < SpisokSport.size(); i++) {
            System.out.println("index " + i + ": " + SpisokSport.get(i));
        }


        Sportsmen udalenPoIndex = SpisokSport.remove(2);
        boolean udalenPoZnacheniyu = SpisokSport.remove(s4);

        System.out.println("\n4) После удаления:");
        System.out.println("Удалён по индексу: " + udalenPoIndex);
        System.out.println("Удалён по значению (s4): " + (udalenPoZnacheniyu ? "да" : "нет"));

        for (Sportsmen sport : SpisokSport) {
            System.out.println(sport);
        }


        System.out.println("\n5) Текущий размер списка: " + SpisokSport.size());


        int indexPoluchit = 3;
        if (indexPoluchit >= 0 && indexPoluchit < SpisokSport.size()) {
            Sportsmen vibor = SpisokSport.get(indexPoluchit);
            System.out.println("\n6) Элемент по индексу " + indexPoluchit + ": " + vibor);
            System.out.println("Имя: " + vibor.getImya());
        }


        if (indexPoluchit >= 0 && indexPoluchit < SpisokSport.size()) {
            Sportsmen stariy = SpisokSport.get(indexPoluchit);
            Sportsmen noviy = new Sportsmen(stariy.getKod(), stariy.getImya() + " (izmenen)", stariy.getVozrast(), stariy.getReyting() + 1);
            SpisokSport.set(indexPoluchit, noviy);
            System.out.println("\n7) После изменения:");
            System.out.println("Новый элемент: " + SpisokSport.get(indexPoluchit));
        }


        System.out.println("\n8) Поиск спортсмена с рейтингом > 80:");
        Sportsmen nayden = null;
        for (Sportsmen sport : SpisokSport) {
            if (sport.getReyting() > 80) {
                nayden = sport;
                break;
            }
        }
        if (nayden != null) {
            System.out.println("Найден: " + nayden);
        } else {
            System.out.println("Не найден.");
        }


        System.out.println("\n9) Проверка содержит ли список s2 и s4:");
        System.out.println("Содержится s2? " + SpisokSport.contains(s2));
        System.out.println("Содержится s4? " + SpisokSport.contains(s4));


        SpisokSport.clear();
        System.out.println("\n10) После очистки размер списка: " + SpisokSport.size());
    }
}