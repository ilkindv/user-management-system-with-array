package exception;

import enums.ExceptionEnum;

import java.time.LocalDate;

public class WrongOptionException extends RuntimeException {
    private final LocalDate date;
    private final String message;

    public WrongOptionException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.date = ExceptionEnum.WRONG_OPTION.getDate();
        this.message = ExceptionEnum.WRONG_OPTION.getMessage();
    }
}
