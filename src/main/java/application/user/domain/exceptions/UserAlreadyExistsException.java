package application.user.domain.exceptions;

import application.user.domain.models.Cpf;

public class UserAlreadyExistsException extends RuntimeException {
    public final String KEY = "USER_ALREADY_EXISTS";

    public final Cpf cpf;

    public UserAlreadyExistsException(Cpf cpf) {
        this.cpf = cpf;
    }
}
