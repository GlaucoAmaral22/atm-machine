package application.ports.inbound;

import application.commands.FindUserCommand;
import application.domain.models.User;

public interface FindUser {
    User execute(FindUserCommand command);
}
