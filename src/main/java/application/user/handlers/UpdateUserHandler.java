package application.user.handlers;

import application.user.commands.UpdateUserCommand;
import application.user.domain.models.User;
import application.user.ports.inbound.UpdateUser;
import application.user.ports.outbound.UserRepository;

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
