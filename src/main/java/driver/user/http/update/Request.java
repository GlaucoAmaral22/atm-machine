package driver.user.http.update;

import application.user.commands.UpdateUserCommand;
import driver.user.http.validators.ValidBirthDate;

public record Request(String name, @ValidBirthDate String birthDate) {

    public UpdateUserCommand toCommand(String id) {
        return new UpdateUserCommand(id, name(), birthDate());
    }
}
