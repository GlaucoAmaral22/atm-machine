package query.user.find;

import application.user.domain.models.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Endpoint {

    public final FindUserQueryHandler find;

    public Endpoint(FindUserQueryHandler find) {
        this.find = find;
    }

    @GET
    @Path("/{id}")
    public Response get(String id) {
        User user = this.find.execute(id);
        ResponseBody response = ResponseBody.from(user);
        return Response.ok(response).build();
    }
}
