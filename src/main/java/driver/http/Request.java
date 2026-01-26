package driver.http;

import application.domain.models.Cpf;
import application.domain.models.User;

public class Request {
    public final String cpf;
    public final String name;
    public final String birthDate;

    public Request(String cpf, String name, String birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User toCommand() {
        return new User(new Cpf(this.cpf), this.name, this.birthDate);
    }
}
