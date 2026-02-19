package driver.http.user.find;

import application.domain.models.User;

public class ResponseBody {
    public final String cpf;
    public final String name;
    public final String birthDate;

    public ResponseBody(String cpf, String name, String birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static ResponseBody from (User user) {
        return new ResponseBody(user.cpf().value(), user.name(), user.birthDate().value());
    }
}
