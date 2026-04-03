package application.user.domain.exceptions;

import application.user.domain.models.Cpf;

import java.util.UUID;

public class UserAlreadyExistsException extends RuntimeException {
    public final String KEY = "USER_ALREADY_EXISTS";

    public final UUID id;

    public UserAlreadyExistsException(UUID id) {
        this.id = id;
    }
}
