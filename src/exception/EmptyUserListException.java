package exception;

import enums.ExceptionEnum;

import java.time.LocalDate;

public class EmptyUserListException extends RuntimeException{
    private final LocalDate date;
    private final String message;

    public EmptyUserListException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.date = ExceptionEnum.EMPTY_USER_LIST.getDate();
        this.message = ExceptionEnum.EMPTY_USER_LIST.getMessage();
    }
}
