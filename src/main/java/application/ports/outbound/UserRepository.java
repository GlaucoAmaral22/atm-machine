package application.ports.outbound;

import application.domain.models.Cpf;
import application.domain.models.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findBy(Cpf cpf);
    void update(User user);
    void deleteBy(Cpf cpf);
}
