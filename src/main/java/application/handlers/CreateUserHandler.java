package application.handlers;

import application.commands.CreateUserCommand;
import application.domain.models.User;
import application.ports.inbound.CreateUser;
import application.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateUserHandler implements CreateUser {

    public final UserRepository userRepository;

    public CreateUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(CreateUserCommand command) {
        User user = User.from(command);
        userRepository.save(user);
        return user;
    }
}
