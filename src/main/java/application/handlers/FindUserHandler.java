package application.handlers;

import application.commands.FindUserCommand;
import application.domain.exceptions.UserNotFoundException;
import application.domain.models.Cpf;
import application.domain.models.User;
import application.ports.inbound.FindUser;
import application.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class FindUserHandler implements FindUser {

    public final UserRepository repository;

    public FindUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User execute(FindUserCommand command) {
        Cpf cpf = command.cpf;
        Optional<User> userOptional = repository.findBy(cpf);
        if (userOptional.isEmpty()) throw new UserNotFoundException(cpf);
        return userOptional.get();
    }
}
