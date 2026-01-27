package application.handlers;

import application.commands.UpdateUserCommand;
import application.domain.models.User;
import application.ports.inbound.UpdateUser;
import application.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UpdateUserHandler implements UpdateUser {
    public final UserRepository repository;

    public UpdateUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UpdateUserCommand command) {
        User user = User.from(command);
        this.repository.update(user);
    }
}
