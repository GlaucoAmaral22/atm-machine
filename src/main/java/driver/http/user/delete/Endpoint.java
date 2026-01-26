package driver.http.user.delete;

import application.commands.DeleteUserCommand;
import application.handlers.DeleteUserHandler;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Endpoint {
    public final DeleteUserHandler handler;

    public Endpoint(DeleteUserHandler handler) {
        this.handler = handler;
    }

    @DELETE
    @Path("/{cpf}")
    public Response delete(String cpf) {
        DeleteUserCommand command = DeleteUserCommand.from(cpf);
        handler.execute(command);
        return Response.noContent().build();
    }
}
