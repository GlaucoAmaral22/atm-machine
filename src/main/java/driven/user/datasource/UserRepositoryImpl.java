package driven.user.datasource;

import application.user.domain.models.Cpf;
import application.user.domain.models.User;
import application.user.ports.outbound.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {
    public final List<User> userList = new ArrayList<>();

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public Optional<User> findBy(Cpf cpf) {
        return userList.stream()
                .filter(user -> user.cpf().value().equals(cpf.value()))
                .findFirst();
    }

    @Override
    public void update(User updatedUser) {
        Optional<User> userFiltered = userList.stream()
                .filter(user -> user.cpf().value().equals(updatedUser.cpf().value()))
                .findFirst();

        if (userFiltered.isEmpty()) throw new IllegalStateException("User does not exists");
        userList.remove(userFiltered.get());
        userList.add(updatedUser);
    }
}
