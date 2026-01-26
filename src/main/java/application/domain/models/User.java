package application.domain.models;

import application.commands.CreateUserCommand;

public final class User {
    public final String name;
    public final String birthDate;
    public final Cpf cpf;

    public User(Cpf cpf, String name, String birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static User from(CreateUserCommand command) {
        return new User(command.cpf, command.name, command.birthDate);
    }
}
