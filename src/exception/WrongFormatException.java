package exception;

import enums.ExceptionEnum;

import java.time.LocalDate;

public class WrongFormatException extends RuntimeException {
    private final LocalDate date;
    private final String message;

    public WrongFormatException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.date = ExceptionEnum.WRONG_FORMAT.getDate();
        this.message = ExceptionEnum.WRONG_FORMAT.getMessage();
    }

}
