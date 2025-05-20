package entity.enums;

public enum AttendanceStatus {
    ATTENDED("  attended  "),
    NOT_ATTENDED("not attended");

    AttendanceStatus(String description) {
        this.description = description;
    }

    private String description;
}
