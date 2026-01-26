package application.handlers;

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
    public void execute(User user) {
        userRepository.save(user);
    }
}
