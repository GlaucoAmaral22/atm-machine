package driver.http.user.find;

import application.commands.FindUserCommand;
import application.domain.models.User;
import application.ports.inbound.FindUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Endpoint {

    public final FindUser find;

    public Endpoint(FindUser find) {
        this.find = find;
    }

    @GET
    @Path("/{cpf}")
    public Response get(String cpf) {
        FindUserCommand command = FindUserCommand.from(cpf);
        User user = find.execute(command);
        ResponseBody response = ResponseBody.from(user);
        return Response.ok(response).build();
    }
}
