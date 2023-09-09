package exception;

import enums.ExceptionEnum;

import java.time.LocalDate;

public class UserNotFoundException extends RuntimeException {

    private final LocalDate date;
    private final String message;
    public UserNotFoundException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.date = ExceptionEnum.USER_NOT_FOUND.getDate();
        this.message = ExceptionEnum.USER_NOT_FOUND.getMessage();
    }
}
