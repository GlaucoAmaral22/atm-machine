package application.user.domain.models;

import application.user.domain.exceptions.InvalidBirthDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public record BirthDate(LocalDate value) {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static BirthDate of(String rawDate) {
        if (rawDate == null || rawDate.isBlank()) {
            throw new InvalidBirthDateException("Birth date cannot be null or blank");
        }

        try {
            return new BirthDate(LocalDate.parse(rawDate, FORMATTER));
        } catch (DateTimeParseException e) {
            throw new InvalidBirthDateException("Birth date must be in the format yyyy-MM-dd, received: " + rawDate);
        }
    }

    public BirthDate {
        if (value.isAfter(LocalDate.now())) {
            throw new InvalidBirthDateException("Birth date cannot be in the future");
        }

        if (value.isAfter(LocalDate.now().minusYears(18))) {
            throw new InvalidBirthDateException("User must be at least 18 years old");
        }

        if (value.isBefore(LocalDate.now().minusYears(150))) {
            throw new InvalidBirthDateException("Birth date is unrealistically old");
        }
    }
}
