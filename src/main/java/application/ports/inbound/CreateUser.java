package application.ports.inbound;

import application.domain.models.User;

public interface CreateUser {
    void execute(User user);
}
