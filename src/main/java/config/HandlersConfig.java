package config;

import application.user.handlers.RegisterUserHandler;
import application.user.handlers.UpdateUserHandler;
import application.user.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import query.user.find.FindUserQueryHandler;

@ApplicationScoped
public class HandlersConfig {

    @Produces
    public RegisterUserHandler createUserHandler(UserRepository userRepository) {
        return new RegisterUserHandler(userRepository);
    }

    @Produces
    public FindUserQueryHandler findUserQueryHandler(UserRepository userRepository) {
        return new FindUserQueryHandler(userRepository);
    }

    @Produces
    public UpdateUserHandler updateUserHandler(UserRepository userRepository) {
        return new UpdateUserHandler(userRepository);
    }
}
