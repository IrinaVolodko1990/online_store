package by.volodko.epam.online_store.model.validator;


public class UserValidator {
    private static final String PHONE_REGEX = "(\\+375)(29|25|44|33)[\\d]{7}";
    private static final String LOGIN_REGEX = "[a-zA-zА-Яа-я\\d]{2,25}";
    private static final String PASSWORD_REGEX = "[a-zA-zА-Яа-я\\d]{5,30}"; // "[\\p{Graph}&&[^\\<\\>]]+\\d]{5,20}";
    private static final String EMAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String NAME_REGEX = "[a-zA-Zа-яА-я]{2,30}";
    private static final String SURNAME_REGEX = "[a-zA-Zа-яА-я]{2,30}";

    private UserValidator() {
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }
        return phone.matches(PHONE_REGEX);
    }

    public static boolean isValidLogin(String login) {
        if (login == null) {
            return false;
        }
        return login.matches(LOGIN_REGEX);
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        boolean flag = false;
        if (!password.isEmpty() & !password.trim().isEmpty()) {
            flag = password.matches(PASSWORD_REGEX);
        }
        return flag;
    }

    public static boolean isIdenticalPasswords(String firstPassword, String secondPassword) {
        if (firstPassword == null || secondPassword == null) {
            return false;
        }
        return firstPassword.equals(secondPassword);
    }

    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        return name.matches(NAME_REGEX);
    }

    public static boolean isValidSurname(String surmane) {
        if (surmane==null){
            return false;
        }
        return surmane.matches(SURNAME_REGEX);
    }

}
