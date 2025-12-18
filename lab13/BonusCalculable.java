package lab13;



public interface BonusCalculable {
    // абстрактные методы
    double calculateBonus();
    String getBonusInfo();

    // default метод
    default String getDefaultBonusMessage() {
        return "Бонусная система активна";
    }

    // static метод
    static double calculateTax(double amount) {
        return amount * 0.13;
    }
}