package driver.user.http.update;

import application.user.commands.UpdateUserCommand;
import application.user.ports.inbound.UpdateUser;
import driver.user.http.validators.ValidCpf;
import jakarta.validation.Valid;
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
    public Response put(@ValidCpf String cpf, @Valid Request request) {
        UpdateUserCommand command = request.toCommand(cpf);
        this.handler.execute(command);
        return Response.noContent().build();
    }
}
