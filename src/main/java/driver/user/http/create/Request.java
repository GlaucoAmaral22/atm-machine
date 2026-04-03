package driver.user.http.create;

import application.user.commands.RegisterUserCommand;
import application.user.domain.models.BirthDate;
import application.user.domain.models.Cpf;
import driver.user.http.validators.ValidBirthDate;
import driver.user.http.validators.ValidCpf;

public record Request(@ValidCpf String cpf, String name, @ValidBirthDate String birthDate) {

    public RegisterUserCommand toCommand() {
        return new RegisterUserCommand(new Cpf(this.cpf), this.name, new BirthDate(this.birthDate));
    }
}
