package service.impl;

import enums.ExceptionEnum;
import exception.*;
import service.UserService;
import service.UserServiceManagement;
import util.MenuUtil;

import java.time.LocalDateTime;

public class UserServiceManagementImpl implements UserServiceManagement {
    @Override
    public void management() {
        while (true) {
            byte option = MenuUtil.entryMenu();
            UserService userService = new UserServiceImpl();
            try {
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        userService.registerUser();
                        break;
                    case 2:
                        userService.showUser();
                        break;
                    case 3:
                        userService.deleteUser();
                        break;
                    case 4:
                        userService.updateUser();
                        break;
                    case 5:
                        userService.searchUser();
                        break;
                    default:
                        throw new WrongOptionException(ExceptionEnum.WRONG_OPTION);
                }
            } catch (WrongOptionException | IllegalArgumentException | WrongFormatException
                    | UserNotFoundException | UserNotRegisteredException | EmptyUserListException exception) {
                System.out.println(exception.getMessage() + "\n" + LocalDateTime.now());
            }
        }
    }
}
