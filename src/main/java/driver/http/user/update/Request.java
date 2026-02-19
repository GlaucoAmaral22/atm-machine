package driver.http.user.update;

import application.commands.UpdateUserCommand;
import application.domain.models.BirthDate;
import application.domain.models.Cpf;
import driver.http.validators.ValidBirthDate;

public record Request(String name, @ValidBirthDate String birthDate) {

    public UpdateUserCommand toCommand(String cpf) {
        return new UpdateUserCommand(new Cpf(cpf), this.name, new BirthDate(this.birthDate));
    }
}
