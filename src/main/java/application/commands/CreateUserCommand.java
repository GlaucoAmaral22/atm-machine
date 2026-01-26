package application.commands;

import application.domain.models.Cpf;

public class CreateUserCommand {
    public final Cpf cpf;
    public final String name;
    public final String birthDate;

    public CreateUserCommand(Cpf cpf, String name, String birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
    }
}
