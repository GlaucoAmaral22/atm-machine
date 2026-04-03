package application.user.domain.models;

import application.user.domain.exceptions.InvalidBirthDateException;
import application.user.domain.validators.BirthDateValidator;

public record BirthDate(String value) {

    public BirthDate {
        if (!BirthDateValidator.isValid(value)) throw new InvalidBirthDateException(value);
    }
}
