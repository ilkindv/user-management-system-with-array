package helper;

import enums.ExceptionEnum;
import exception.*;
import globaldata.GlobalData;
import model.User;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

import static util.InputUtil.*;

public class UserServiceHelper {
    private static long id;
    private static long registrationId;
    private static int countIndex;

    public static void registerHelper(){
        User user = UserServiceHelper.fillUser();
        if (user != null){
            GlobalData.users[countIndex] = user;
            countIndex++;
        }
        else{
            throw new UserNotRegisteredException(ExceptionEnum.USER_NOT_REGISTERED);
        }
    }

    public static User fillUser(){
        try {
            System.out.println("--------------------------------\n" + ++registrationId + ".Registration" );
            String name = getInstance().inputString("Enter the name of the user: ");
            String surname = getInstance().inputString("Enter the surname of the user: ");
            LocalDate birthDate = birthDateHelper();
            LocalDateTime registrationTime = LocalDateTime.now();
            System.out.println("--------------------------------");
            if (name != null && surname != null && birthDate != null) {
                return new User(++id, name, surname, birthDate, registrationTime);
            } else {
                throw new UserNotRegisteredException(ExceptionEnum.USER_NOT_REGISTERED);
            }
        } catch (UserNotRegisteredException | DateTimeException | InputMismatchException exception) {
            System.out.println(exception.getMessage() + LocalDate.now());
        }
        return null;
    }

    public static LocalDate birthDateHelper(){
        try {
            String inputBirthDate = getInstance().inputString("Enter the birth date of the user(Year-Month-Day): ");
            LocalDate parsedBirthDate = LocalDate.parse(inputBirthDate);
            int day = parsedBirthDate.getDayOfMonth();
            int month = parsedBirthDate.getMonthValue();
            int year = parsedBirthDate.getYear();
            return LocalDate.of(year, month, day);
        } catch (DateTimeException exception) {
            System.out.println("Incorrect date format. Desired format: Year-Month-Day");
        }
        return null;
    }

    public static void searchByIdForRemove(){
        try {
            System.out.println("--------------------------------");
            long id = getInstance().inputLong("Enter the id of the user you want to remove: ");
            System.out.println("--------------------------------");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == id) {
                    GlobalData.users[i] = null;
                    return;
                }
            }
            throw new UserNotFoundException(ExceptionEnum.USER_NOT_FOUND);
        } catch (WrongFormatException | InputMismatchException | UserNotFoundException exception ) {
            System.out.println(exception.getMessage());
        }
    }

    public static User searchByIdForUpdate(){
        User user = null;
        if (GlobalData.users == null || GlobalData.users.length == 0) {
            throw new EmptyUserListException(ExceptionEnum.EMPTY_USER_LIST);
        }
        else {
            long id = getInstance().inputLong("Enter the id of the user you want to update: ");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i]!= null && GlobalData.users[i].getId() == id) {
                    user = GlobalData.users[i];
                    break;
                }
            }
        }
        return user;
    }
}
