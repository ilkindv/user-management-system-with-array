package enums;

import java.time.LocalDate;

public enum StatusEnum {
    REGISTER_SUCCESS(LocalDate.now(),"Register successfully!"),
    UPDATE_SUCCESS(LocalDate.now(),"Update successfully!"),
    DELETE_SUCCESS(LocalDate.now(),"Delete successfully!");

    private final LocalDate date;
    private final String message;

    StatusEnum(LocalDate date, String message) {
        this.date = date;
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
