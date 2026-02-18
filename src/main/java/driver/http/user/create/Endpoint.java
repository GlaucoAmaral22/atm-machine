package driver.http.user.create;

import application.commands.CreateUserCommand;
import application.domain.models.User;
import application.ports.inbound.CreateUser;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Endpoint {
    public final CreateUser handler;

    public Endpoint(CreateUser handler) {
        this.handler = handler;
    }

    @POST
    public Response post(@Valid Request request) {
        CreateUserCommand command = request.toCommand();
        User user = this.handler.execute(command);
        ResponseBody responseBody = ResponseBody.from(user);
        return Response.status(Response.Status.CREATED)
                .entity(responseBody)
                .build();
    }
}
