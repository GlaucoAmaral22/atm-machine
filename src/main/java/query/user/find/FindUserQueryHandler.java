package query.user.find;

import application.user.domain.exceptions.UserNotFoundException;
import application.user.domain.models.Cpf;
import application.user.domain.models.User;
import application.user.ports.outbound.UserRepository;

import java.util.Optional;

public record FindUserQueryHandler(UserRepository repository) {

    /*
    quando houver datasource para o banco, injetar ele ao inves do repository,
    dado que a camada query deve ser uma fina camada para consulta de dados
    e nao quero atrelar ao fluxo de dominio dos comandos.
     */

    public User execute(String stringCpf) {
        Cpf cpf = new Cpf(stringCpf);
        Optional<User> userOptional = repository.findBy(cpf);
        if (userOptional.isEmpty()) throw new UserNotFoundException(cpf);
        return userOptional.get();
    }
}
