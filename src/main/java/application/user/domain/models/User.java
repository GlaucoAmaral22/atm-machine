package application.user.domain.models;

import application.user.commands.RegisterUserCommand;
import application.user.commands.UpdateUserCommand;

public record User(Cpf cpf, String name, BirthDate birthDate) {

    public static User from(RegisterUserCommand command) {
        return new User(command.cpf(), command.name(), command.birthDate());
    }

    public static User from(UpdateUserCommand command) {
        return new User(command.cpf(), command.name(), command.birthDate());
    }
}
