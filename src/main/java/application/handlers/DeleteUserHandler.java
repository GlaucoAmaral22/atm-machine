package application.handlers;

import application.commands.DeleteUserCommand;
import application.commands.FindUserCommand;
import application.domain.models.Cpf;
import application.domain.models.User;
import application.ports.inbound.DeleteUser;
import application.ports.inbound.FindUser;
import application.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class DeleteUserHandler implements DeleteUser {

    public final UserRepository repository;

    public DeleteUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DeleteUserCommand command) {
        Cpf cpf = command.cpf;
        repository.deleteBy(cpf);
    }
}
