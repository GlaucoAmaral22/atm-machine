package driver.user.http.register;

import application.user.commands.RegisterUserCommand;
import driver.user.http.validators.ValidBirthDate;
import driver.user.http.validators.ValidCpf;

public record Request(@ValidCpf String cpf, String name, @ValidBirthDate String birthDate) {

    public RegisterUserCommand toCommand() {
        return new RegisterUserCommand(this.cpf(), this.name(), this.birthDate());
    }
}
