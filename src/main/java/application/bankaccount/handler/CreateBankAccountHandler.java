package application.bankaccount.handler;

import application.bankaccount.commands.CreateBankAccountCommand;
import application.bankaccount.domain.BankAccount;
import application.bankaccount.domain.exceptions.UserNotFoundException;
import application.bankaccount.ports.inbound.CreateBankAccount;
import application.bankaccount.ports.outbound.UserRepository;

import java.util.UUID;

public class CreateBankAccountHandler implements CreateBankAccount {

    private final UserRepository userRepository;

    public CreateBankAccountHandler (
            UserRepository userRepository,
            BankAccountRepository bankAccountRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public BankAccount handle(CreateBankAccountCommand command) {
        UUID userId = UUID.fromString(command.userId());
        if (!userRepository.exists(userId)) {
            throw new UserNotFoundException(userId);
        }

        BankAccount bankAccount = BankAccount.from(command);
        //Salvar a instancia de BankAccount com Repository

        //devolver a instancia salva

        return null;
    }
}
