package driver.user.http.update;

import application.user.commands.UpdateUserCommand;
import application.user.domain.models.BirthDate;
import application.user.domain.models.Cpf;
import driver.user.http.validators.ValidBirthDate;

public record Request(String name, @ValidBirthDate String birthDate) {

    public UpdateUserCommand toCommand(String cpf) {
        return new UpdateUserCommand(new Cpf(cpf), this.name, new BirthDate(this.birthDate));
    }
}
