import service.UserServiceManagement;
import service.impl.UserServiceManagementImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceManagement userServiceManagement = new UserServiceManagementImpl();
        userServiceManagement.management();
    }
}