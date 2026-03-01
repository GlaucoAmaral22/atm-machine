package config;

import application.handlers.CreateUserHandler;
import application.handlers.DeleteUserHandler;
import application.handlers.FindUserHandler;
import application.handlers.UpdateUserHandler;
import application.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class HandlersConfig {

    @Produces
    public CreateUserHandler createUserHandler(UserRepository userRepository) {
        return new CreateUserHandler(userRepository);
    }

    @Produces
    public DeleteUserHandler deleteUserHandler(UserRepository userRepository) {
        return new DeleteUserHandler(userRepository);
    }

    @Produces
    public FindUserHandler findUserHandler(UserRepository userRepository) {
        return new FindUserHandler(userRepository);
    }

    @Produces
    public UpdateUserHandler updateUserHandler(UserRepository userRepository) {
        return new UpdateUserHandler(userRepository);
    }



}
