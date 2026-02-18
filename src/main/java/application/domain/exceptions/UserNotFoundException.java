package application.domain.exceptions;

import application.domain.models.Cpf;

public class UserNotFoundException extends RuntimeException {
    public final String KEY = "USER_NOT_FOUND";

    public final Cpf cpf;

    public UserNotFoundException(Cpf cpf) {
        this.cpf = cpf;
    }
}
