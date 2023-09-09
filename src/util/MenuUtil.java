package util;

public class MenuUtil {

    public static byte entryMenu(){
        System.out.print("""
                ----------------------------------------------------------------
                [0] - Exit
                [1] - Registration
                [2] - Show registered Users
                [3] - Delete User
                [4] - Update User
                [5] - Search registered User
                ----------------------------------------------------------------
                """);
        return InputUtil.getInstance().inputByte("Select the option: ");
    }

    public static String updateMenu(){
        System.out.print("""
                [0] - Exit
                [1] - Update User name
                [2] - Update User surname
                [3] - Update User birthdate
                """);
        return InputUtil.getInstance().inputString("If you want to update 2 or more data, put a ',' in the options.\n" +
                                                      "Select the option : ");
    }
}
