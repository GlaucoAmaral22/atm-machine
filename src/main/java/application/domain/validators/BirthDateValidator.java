package application.domain.validators;

import com.aayushatharva.brotli4j.common.annotations.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class BirthDateValidator {

    private static final String BIRTH_DATE_FORMAT = "\\d{4}-\\d{2}-\\d{2}";
    private static final int MAX_AGE = 110;
    private static final int MIN_AGE = 18;

    public static boolean isValid(String value) {
        if (value == null) return false;

        if (!value.matches(BIRTH_DATE_FORMAT)) return false;

        try {
            LocalDate now = LocalDate.now();
            LocalDate birthDate = LocalDate.parse(value);

            int age = Period.between(birthDate, now).getYears();

            return age >= MIN_AGE && age <= MAX_AGE;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }
}
