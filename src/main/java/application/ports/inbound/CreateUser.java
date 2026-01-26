package application.ports.inbound;

import application.commands.CreateUserCommand;
import application.domain.models.User;

public interface CreateUser {
    User execute(CreateUserCommand command);
}
