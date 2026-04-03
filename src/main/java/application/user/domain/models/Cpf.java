package application.user.domain.models;

import application.user.domain.exceptions.InvalidCpfException;

public record Cpf(String value) {

    public Cpf {
        if (value == null || value.isBlank()) {
            throw new InvalidCpfException("CPF cannot be null or blank");
        }

        String digits = value.replaceAll("[.\\-]", "");

        if (!digits.matches("\\d{11}")) {
            throw new InvalidCpfException("CPF must contain exactly 11 digits");
        }

        if (digits.chars().distinct().count() == 1) {
            throw new InvalidCpfException("CPF cannot have all identical digits");
        }

        value = digits;
    }
}
