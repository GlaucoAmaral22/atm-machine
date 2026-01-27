package driver.http.user.update;

import application.commands.UpdateUserCommand;
import application.domain.models.Cpf;

public class Request {
    public final String name;
    public final String birthDate;

    public Request(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public UpdateUserCommand toCommand(String cpf) {
        return new UpdateUserCommand(new Cpf(cpf), this.name, this.birthDate);
    }
}
