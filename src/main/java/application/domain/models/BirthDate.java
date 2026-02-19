package application.domain.models;

import application.domain.exceptions.InvalidBirthDateException;
import application.domain.validators.BirthDateValidator;

public record BirthDate(String value) {

    public BirthDate {
        if (!BirthDateValidator.isValid(value)) throw new InvalidBirthDateException(value);
    }
}
