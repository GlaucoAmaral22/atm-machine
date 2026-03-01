package application.handlers;

import application.commands.CreateUserCommand;
import application.domain.exceptions.UserAlreadyExistsException;
import application.domain.models.User;
import application.ports.inbound.CreateUser;
import application.ports.outbound.UserRepository;
import java.util.Optional;

public class CreateUserHandler implements CreateUser {

    public final UserRepository userRepository;

    public CreateUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(CreateUserCommand command) {
        User user = User.from(command);
        Optional<User> optionalUser = this.userRepository.findBy(command.cpf());
        if (optionalUser.isPresent()) throw new UserAlreadyExistsException(command.cpf());
        userRepository.save(user);
        return user;
    }
}
