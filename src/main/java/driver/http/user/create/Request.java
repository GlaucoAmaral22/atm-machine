package driver.http.user.create;

import application.commands.CreateUserCommand;
import application.domain.models.Cpf;
import driver.http.validators.ValidCpf;

public class Request {
    @ValidCpf
    public final String cpf;
    public final String name;
    public final String birthDate;

    public Request(String cpf, String name, String birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
    }

    public CreateUserCommand toCommand() {
        return new CreateUserCommand(new Cpf(this.cpf), this.name, this.birthDate);
    }
}
