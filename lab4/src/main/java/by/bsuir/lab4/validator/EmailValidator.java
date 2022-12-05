package by.bsuir.lab4.validator;

public class EmailValidator implements Validator {

    private static final String EMAIL_REGEX_PATTERN = "[-0-9a-zA-Z.+_]{2,64}+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";

    @Override
    public boolean isValidated(String email) {
        boolean result = false;
        if (email != null && !email.isEmpty()) {
            result = email.matches(EMAIL_REGEX_PATTERN);
        }
        return result;
    }
}
