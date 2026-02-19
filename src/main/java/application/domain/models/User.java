package application.domain.models;

import application.commands.CreateUserCommand;
import application.commands.UpdateUserCommand;

public record User(Cpf cpf, String name, BirthDate birthDate) {

    public static User from(CreateUserCommand command) {
        return new User(command.cpf(), command.name(), command.birthDate());
    }

    public static User from(UpdateUserCommand command) {
        return new User(command.cpf(), command.name(), command.birthDate());
    }
}
