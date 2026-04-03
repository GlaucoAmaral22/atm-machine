package application.user.domain.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public final String KEY = "USER_NOT_FOUND";

    public final UUID id;

    public UserNotFoundException(UUID id) {
        this.id = id;
    }
}
