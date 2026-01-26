package driver.http;

import application.domain.models.User;
import application.ports.inbound.CreateUser;
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
    public Response post(Request request) {
        User user = request.toCommand();
        this.handler.execute(user);
        ResponseBody responseBody = ResponseBody.from(user);
        return Response.status(Response.Status.CREATED)
                .entity(responseBody)
                .build();
    }
}
