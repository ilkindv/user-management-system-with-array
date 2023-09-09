package service.impl;

import enums.ExceptionEnum;
import enums.StatusEnum;
import exception.EmptyUserListException;
import exception.UserNotFoundException;
import exception.WrongOptionException;
import globaldata.GlobalData;
import model.User;
import service.UserService;
import util.MenuUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static util.InputUtil.*;
import static helper.UserServiceHelper.*;

public class UserServiceImpl implements UserService {
    @Override
    public void registerUser() {
        int count = getInstance().inputInt("How many user do you register? ");
        if (GlobalData.users == null) {
            GlobalData.users = new User[count];
            for (int i = 0; i < count; i++) {
                registerHelper();
            }
            System.out.println(StatusEnum.REGISTER_SUCCESS.getMessage());
        } else {
            User[] tempUsers = GlobalData.users;
            GlobalData.users = new User[count + tempUsers.length];
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (i < tempUsers.length){
                    GlobalData.users[i] = tempUsers[i];
                }else {
                    registerHelper();
                }
            }
            System.out.println(StatusEnum.REGISTER_SUCCESS.getMessage());
        }

    }

    @Override
    public void showUser() {
        if (GlobalData.users!= null) {
            for (User user : GlobalData.users) {
                if (user.getUpdateDate() == null){
                    user.getInfo();
                }else {
                    user.getInfoWithUpdateDate();
                }
            }
        }else{
            throw new EmptyUserListException(ExceptionEnum.EMPTY_USER_LIST);
        }
    }

    @Override
    public void deleteUser() {
        showUser();
        if (GlobalData.users != null) {
            searchByIdForRemove();
            int nullIndex = -1;
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i] == null) {
                    nullIndex = i;
                    break;
                }
            }
            if (nullIndex >= 0) {
                for (int i = nullIndex; i < GlobalData.users.length - 1; i++) {
                    GlobalData.users[i] = GlobalData.users[i + 1];
                }
                GlobalData.users[GlobalData.users.length - 1] = null;
            } else {
                throw new UserNotFoundException(ExceptionEnum.USER_NOT_FOUND);
            }
            System.out.println(StatusEnum.DELETE_SUCCESS.getMessage());
        } else {
            throw new EmptyUserListException(ExceptionEnum.EMPTY_USER_LIST);
        }
    }

    @Override
    public void updateUser() {
        if (GlobalData.users!= null) {
            showUser();
            User user = searchByIdForUpdate();
            String options = MenuUtil.updateMenu();
            String[] optionArr = options.trim().split(",");
            for (int i = 0; i < optionArr.length; i++) {
                byte option = Byte.parseByte(optionArr[i]);
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        String name = getInstance().inputString("Enter the name: ");
                        user.setName(name);
                        break;
                    case 2:
                        String surname = getInstance().inputString("Enter the surname: ");
                        user.setSurname(surname);
                        break;
                    case 3:
                        LocalDate birthDate = birthDateHelper();
                        user.setBirthdate(birthDate);
                        break;
                    default:
                        throw new WrongOptionException(ExceptionEnum.WRONG_OPTION);
                }
            }
            user.setUpdateDate(LocalDateTime.now());
            System.out.println(StatusEnum.UPDATE_SUCCESS.getMessage());
        } else {
            throw new EmptyUserListException(ExceptionEnum.EMPTY_USER_LIST);
        }
    }

    @Override
    public void searchUser() {
        if (GlobalData.users != null) {
            String key = getInstance().inputString("Enter the name or surname of the user: ");
            for (User user : GlobalData.users) {
                if (user.getName().equals(key) || user.getSurname().equals(key)) {
                    if (user.getUpdateDate() == null){
                        user.getInfo();
                    }else {
                        user.getInfoWithUpdateDate();
                    }
                }
                throw new UserNotFoundException(ExceptionEnum.USER_NOT_FOUND);
            }
        }else {
            throw new EmptyUserListException(ExceptionEnum.EMPTY_USER_LIST);
        }
    }
}
