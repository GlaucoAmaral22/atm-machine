package driver.user.http.register;

import application.user.domain.models.User;

public record ResponseBody(String id, String cpf, String name, String birthDate) {

    public static ResponseBody from(User user) {
        return new ResponseBody(
                user.id().toString(),
                user.cpf().value(),
                user.name().value(),
                user.birthDate().value().toString()
        );
    }
}
