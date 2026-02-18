package application.domain.exceptions;

import application.domain.models.Cpf;

public class UserAlreadyExistsException extends RuntimeException {
    public final String KEY = "USER_ALREADY_EXISTS";

    public final Cpf cpf;

    public UserAlreadyExistsException(Cpf cpf) {
        this.cpf = cpf;
    }
}
