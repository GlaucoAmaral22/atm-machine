package application.domain.models;

import application.domain.exceptions.InvalidCpfException;
import application.domain.validators.CpfValidator;

public class Cpf {
    public final String value;

    public Cpf(String value) {
        if (!CpfValidator.isValid(value)) throw new InvalidCpfException(value);
        this.value = value;
    }
}
