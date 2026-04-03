package application.user.ports.inbound;

import application.user.commands.RegisterUserCommand;
import application.user.domain.models.User;

public interface RegisterUser {
    User execute(RegisterUserCommand command);
}
