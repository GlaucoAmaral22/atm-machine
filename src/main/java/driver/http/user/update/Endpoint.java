package driver.http.user.update;

import application.commands.UpdateUserCommand;
import application.ports.inbound.UpdateUser;
import driver.http.validators.ValidCpf;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Endpoint {
    public final UpdateUser handler;

    public Endpoint(UpdateUser handler) {
        this.handler = handler;
    }

    @PUT
    @Path("/{cpf}")
    public Response put(@ValidCpf String cpf, Request request) {
        UpdateUserCommand command = request.toCommand(cpf);
        this.handler.execute(command);
        return Response.noContent().build();
    }
}
