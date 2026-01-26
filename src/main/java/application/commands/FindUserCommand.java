package application.commands;

import application.domain.models.Cpf;

public class FindUserCommand {
    public final Cpf cpf;

    public FindUserCommand(Cpf cpf) {
        this.cpf = cpf;
    }

    public static FindUserCommand from(String cpf) {
        return new FindUserCommand(new Cpf(cpf));
    }
}
