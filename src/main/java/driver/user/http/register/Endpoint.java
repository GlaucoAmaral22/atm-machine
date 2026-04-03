package driver.user.http.register;

import application.user.commands.RegisterUserCommand;
import application.user.domain.models.User;
import application.user.ports.inbound.RegisterUser;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Endpoint {
    public final RegisterUser handler;

    public Endpoint(RegisterUser handler) {
        this.handler = handler;
    }

    @POST
    public Response post(@Valid Request request) {
        RegisterUserCommand command = request.toCommand();
        User user = this.handler.execute(command);
        ResponseBody responseBody = ResponseBody.from(user);
        return Response.status(Response.Status.CREATED)
                .entity(responseBody)
                .build();
    }
}
