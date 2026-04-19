package application.bankaccount.commands;

import java.util.UUID;

public record DepositCommand(UUID bankAccountId, long amountInCents) { }
