package application.bankaccount.domain;

import application.bankaccount.commands.CreateBankAccountCommand;

import java.util.UUID;

public record BankAccount(
        UUID id,
        AccountNumber accountNumber,
        UUID userId,
        Balance balanceInCents,
        AccountType accountType
) {

    public static final long INITIAL_BALANCE = 0L;

    public static BankAccount from(CreateBankAccountCommand command) {
        return new BankAccount(
                UUID.randomUUID(),
                AccountNumber.generate(),
                UUID.fromString(command.userId()),
                new Balance(INITIAL_BALANCE),
                AccountType.valueOf(command.accountType())
        );
    }

}
