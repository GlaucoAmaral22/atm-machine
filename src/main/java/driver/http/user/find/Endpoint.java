package driver.http.user.find;

import application.commands.FindUserCommand;
import application.domain.models.User;
import application.ports.inbound.FindUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/user")
public class Endpoint {

    public final FindUser find;

    public Endpoint(FindUser find) {
        this.find = find;
    }

    @GET
    @Path("/{cpf}")
    public ResponseBody get(String cpf) {
        FindUserCommand command = FindUserCommand.from(cpf);
        User user = find.execute(command);
        return ResponseBody.from(user);
    }
}
