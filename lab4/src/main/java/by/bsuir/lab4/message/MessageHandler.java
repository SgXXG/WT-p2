package by.bsuir.lab4.message;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageHandler {

    private static final String MESSAGES = "messages";
    private static final Locale DEFAULT_LOCALE = new Locale("ru", "RU");

    public static String getMessage(String key, String locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGES, formatLocale(locale));
        return resourceBundle.getString(key);
    }

    private static Locale formatLocale(String locale) {
        if (locale != null) {
            String[] languageCountry = locale.split("_");
            return new Locale(languageCountry[0], languageCountry[0]);
        } else {
            Locale.setDefault(DEFAULT_LOCALE);
            return DEFAULT_LOCALE;
        }
    }
}
