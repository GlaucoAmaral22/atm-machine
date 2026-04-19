package application.bankaccount.ports.inbound;

import application.bankaccount.commands.CreateBankAccountCommand;
import application.bankaccount.domain.BankAccount;

public interface CreateBankAccount {
    BankAccount handle(CreateBankAccountCommand command);
}
