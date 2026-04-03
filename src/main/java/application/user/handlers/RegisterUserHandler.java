package application.user.handlers;

import application.user.commands.RegisterUserCommand;
import application.user.domain.exceptions.UserAlreadyExistsException;
import application.user.domain.models.User;
import application.user.ports.inbound.RegisterUser;
import application.user.ports.outbound.UserRepository;
import java.util.Optional;

public class RegisterUserHandler implements RegisterUser {

    public final UserRepository userRepository;

    public RegisterUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(RegisterUserCommand command) {
        User user = User.from(command);
        Optional<User> optionalUser = this.userRepository.findBy(command.cpf());
        if (optionalUser.isPresent()) throw new UserAlreadyExistsException(command.cpf());
        userRepository.save(user);
        return user;
    }
}
