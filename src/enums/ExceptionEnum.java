package enums;

import java.time.LocalDate;

public enum ExceptionEnum {
    USER_NOT_FOUND(LocalDate.now(),"User not found!"),
    USER_NOT_REGISTERED(LocalDate.now(),"User not registered!"),
    EMPTY_USER_LIST(LocalDate.  now(),"There is no user in the system!"),
    WRONG_FORMAT(LocalDate.now(),"Invalid format!"),
    WRONG_OPTION(LocalDate.now(),"Invalid option!");

    private final LocalDate date;
    private final String message;

    private ExceptionEnum(LocalDate date, String message) {
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
