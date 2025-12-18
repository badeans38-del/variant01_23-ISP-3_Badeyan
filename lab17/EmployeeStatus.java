package lab17;

public enum EmployeeStatus {
    // Значения с id, описанием и кодом отдела
    ACTIVE(1, "Работает", "A"),
    ON_LEAVE(2, "В отпуске", "L"),
    FIRED(3, "Уволен", "F"),
    PROBATION(4, "Испытательный срок", "P");

    private final int id;
    private final String description;
    private final String departmentCode;

    // Конструктор
    EmployeeStatus(int id, String description, String departmentCode) {
        this.id = id;
        this.description = description;
        this.departmentCode = departmentCode;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    // Метод с логикой: проверка допустимости перехода статуса
    public boolean canChangeTo(EmployeeStatus newStatus) {
        switch (this) {
            case ACTIVE:
                return newStatus == ON_LEAVE || newStatus == FIRED;
            case ON_LEAVE:
                return newStatus == ACTIVE || newStatus == FIRED;
            case PROBATION:
                return newStatus == ACTIVE || newStatus == FIRED;
            case FIRED:
                return false; // Уволенного нельзя перевести в другой статус
            default:
                return false;
        }
    }

    // Статический метод для поиска по id
    public static EmployeeStatus getById(int id) {
        for (EmployeeStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        return null;
    }
}