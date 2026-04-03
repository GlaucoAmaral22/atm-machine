package application.user.ports.outbound;

import application.user.domain.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    Optional<User> findBy(UUID id);
    void update(User user);
}
