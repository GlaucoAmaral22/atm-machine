package application.user.domain.models;

import application.user.commands.RegisterUserCommand;

import java.util.UUID;

public record User(UUID id, Cpf cpf, Name name, BirthDate birthDate) {

    public static User from(RegisterUserCommand command) {
        return new User(
                UUID.randomUUID(),
                new Cpf(command.cpf()),
                new Name(command.name()),
                BirthDate.of(command.birthDate())
        );
    }

    public User update(String name, String birthDate) {
        return new User(
                this.id(),
                this.cpf(),
                new Name(name),
                BirthDate.of(birthDate)
        );
    }
}
