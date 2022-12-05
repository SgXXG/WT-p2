package by.bsuir.lab4.validator;

public class LoginValidator implements Validator {

    private static final String LOGIN_REGEX_PATTERN = "^[(\\w)-]{4,20}";

    @Override
    public boolean isValidated(String login) {

        boolean result = false;
        if (login != null && !login.isEmpty()) {
            result = login.matches(LOGIN_REGEX_PATTERN);
        }
        return result;
    }
}
