package application.ports.inbound;

import application.commands.DeleteUserCommand;
import application.domain.models.User;

public interface DeleteUser {
    void execute(DeleteUserCommand command);
}
