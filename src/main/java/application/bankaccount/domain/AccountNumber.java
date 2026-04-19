package application.bankaccount.domain;

import java.util.Random;

public record AccountNumber(String value) {
    public AccountNumber {
        if (!value.matches("^\\d{5}-\\d{5}$"))
            throw new IllegalArgumentException("Invalid account number: " + value);
    }

    public static AccountNumber generate() {
        int sequence = new Random().nextInt(99999);
        return new AccountNumber(String.format("00001-%05d", sequence));
    }
}
