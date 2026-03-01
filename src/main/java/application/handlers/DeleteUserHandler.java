package application.handlers;

import application.commands.DeleteUserCommand;
import application.domain.exceptions.UserNotFoundException;
import application.domain.models.Cpf;
import application.domain.models.User;
import application.ports.inbound.DeleteUser;
import application.ports.outbound.UserRepository;

import java.util.Optional;

public class DeleteUserHandler implements DeleteUser {

    public final UserRepository repository;

    public DeleteUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DeleteUserCommand command) {
        Cpf cpf = command.cpf;
        Optional<User> user = this.repository.findBy(cpf);
        if (user.isEmpty()) throw new UserNotFoundException(cpf);
        repository.deleteBy(cpf);
    }
}
