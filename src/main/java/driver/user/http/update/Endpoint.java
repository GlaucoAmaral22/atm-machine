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
    @Path("/{id}")
    public Response put(String id, @Valid Request request) {
        UpdateUserCommand command = request.toCommand(id);
        this.handler.execute(command);
        return Response.noContent().build();
    }
}
