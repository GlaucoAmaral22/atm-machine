package application.bankaccount.commands;

import java.util.UUID;

public record WithdrawCommand(UUID bankAccountId, long amountInCents) { }
