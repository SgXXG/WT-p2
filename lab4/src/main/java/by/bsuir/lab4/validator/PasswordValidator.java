package by.bsuir.lab4.validator;

public class PasswordValidator implements Validator {

    private static final String PASSWORD_REGEX_PATTERN = "^(?=.*\\d)(?=.*\\p{Lower})(?=.*\\p{Upper})(?=.*\\p{Punct})"
            + "(?=\\S+$).{8,20}$";

    @Override
    public boolean isValidated(String passsword) {

        boolean result = false;
        if (passsword != null && !passsword.isEmpty()) {
            result = passsword.matches(PASSWORD_REGEX_PATTERN);
        }
        return result;
    }
}
