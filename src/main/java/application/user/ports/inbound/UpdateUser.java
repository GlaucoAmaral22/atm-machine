package application.user.ports.inbound;

import application.user.commands.UpdateUserCommand;

public interface UpdateUser {
    void execute(UpdateUserCommand command);
}
