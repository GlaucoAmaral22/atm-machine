package application.user.ports.outbound;

import application.user.domain.models.Cpf;
import application.user.domain.models.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findBy(Cpf cpf);
    void update(User user);
}
