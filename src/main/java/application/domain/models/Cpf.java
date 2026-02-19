package application.domain.models;

import application.domain.exceptions.InvalidCpfException;
import application.domain.validators.CpfValidator;

public record Cpf(String value) {

    public Cpf {
        if (!CpfValidator.isValid(value)) throw new InvalidCpfException(value);
    }
}
