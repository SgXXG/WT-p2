package by.bsuir.lab4.validator;

import java.time.LocalDate;
import java.time.Month;

public class BirthdayValidator implements Validator {

    private static final int MIN_AGE = 3;
    private static final int MAX_AGE = 120;
    private static final String DATE_REGEX = "([1][9][0-9]{2}||[2][0][0-3][0-9])-([0][1-9]||[1][0-2])-([0][1-9]||[1-2][0-9]||[3][0-1])";
    private static final String SPLIT_DATE = "-";
    private static final int FEBR_DAYS = 28;
    private static final int VYS_FEBR_DAYS = 29;
    private static final int DAYS_31 = 31;

    @Override
    public boolean isValidated(String str) {
        boolean status = false;
        if (str != null && str.matches(DATE_REGEX)) {
            String[] temp = str.split(SPLIT_DATE);
            int years = Integer.parseInt(temp[0]);
            int month = Integer.parseInt(temp[1]);
            int day = Integer.parseInt(temp[2]);
            if (day <= FEBR_DAYS) {
                status = checkRange(str);
            } else {
                if (month == Month.FEBRUARY.getValue()) {
                    if (day == VYS_FEBR_DAYS) {
                        if (years % 4 == 0) {
                            status = checkRange(str);
                        }
                    }
                } else {
                    if (day < DAYS_31) {
                        status = checkRange(str);
                    } else {
                        if ((month == Month.JANUARY.getValue()) || (month == Month.MARCH.getValue())
                                || (month == Month.MAY.getValue()) || (month == Month.JULY.getValue())
                                || (month == Month.SEPTEMBER.getValue()) || (month == Month.DECEMBER.getValue())) {
                            status = checkRange(str);
                        }
                    }
                }
            }
        }
        return status;
    }

    private boolean checkRange(String str) {
        boolean status = false;
        LocalDate birthday = LocalDate.parse(str);
        LocalDate current = LocalDate.now();
        LocalDate minDate = current.minusYears(MIN_AGE);
        LocalDate maxDate = current.minusYears(MAX_AGE);
        if (birthday.isAfter(maxDate) && birthday.isBefore(minDate)) {
            status = true;
        }
        return status;
    }
}
