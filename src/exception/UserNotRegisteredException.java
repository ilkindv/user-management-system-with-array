package exception;

import enums.ExceptionEnum;

import java.time.LocalDate;

public class UserNotRegisteredException extends RuntimeException {
    private final LocalDate date;
    private final String message;
    public UserNotRegisteredException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.date = ExceptionEnum.USER_NOT_REGISTERED.getDate();
        this.message = ExceptionEnum.USER_NOT_REGISTERED.getMessage();
    }
}
