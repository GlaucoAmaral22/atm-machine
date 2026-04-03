package application.user.domain.models;

import application.user.domain.exceptions.InvalidCpfException;
import application.user.domain.validators.CpfValidator;

public record Cpf(String value) {

    public Cpf {
        if (!CpfValidator.isValid(value)) throw new InvalidCpfException(value);
    }
}
