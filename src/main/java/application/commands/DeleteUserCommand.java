package application.commands;

import application.domain.models.Cpf;

public class DeleteUserCommand {
    public final Cpf cpf;

    public DeleteUserCommand(Cpf cpf) {
        this.cpf = cpf;
    }

    public static DeleteUserCommand from(String cpf) {
        return new DeleteUserCommand(new Cpf(cpf));
    }
}
