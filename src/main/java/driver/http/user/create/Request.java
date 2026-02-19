package driver.http.user.create;

import application.commands.CreateUserCommand;
import application.domain.models.BirthDate;
import application.domain.models.Cpf;
import driver.http.validators.ValidBirthDate;
import driver.http.validators.ValidCpf;

public record Request(@ValidCpf String cpf, String name, @ValidBirthDate String birthDate) {

    public CreateUserCommand toCommand() {
        return new CreateUserCommand(new Cpf(this.cpf), this.name, new BirthDate(this.birthDate));
    }
}
