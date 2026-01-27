package application.ports.inbound;

import application.commands.UpdateUserCommand;
import application.domain.models.User;

public interface UpdateUser {
    void execute(UpdateUserCommand command);
}
