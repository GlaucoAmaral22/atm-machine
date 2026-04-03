package application.user.handlers;

import application.user.commands.UpdateUserCommand;
import application.user.domain.exceptions.UserNotFoundException;
import application.user.domain.models.User;
import application.user.ports.inbound.UpdateUser;
import application.user.ports.outbound.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class UpdateUserHandler implements UpdateUser {
    public final UserRepository repository;

    public UpdateUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UpdateUserCommand command) {
        UUID id = UUID.fromString(command.id());
        Optional<User> user = this.repository.findBy(id);
        if (user.isEmpty()) throw new UserNotFoundException(id);
        User updatedUser = user.get().update(command.name(), command.birthDate());
        this.repository.update(updatedUser);
    }
}
