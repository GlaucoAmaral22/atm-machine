package query.user.find;

import application.user.domain.models.User;
import driver.user.http.validators.ValidCpf;
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
    @Path("/{cpf}")
    public Response get(@ValidCpf String cpf) {
        User user = find.execute(cpf);
        ResponseBody response = ResponseBody.from(user);
        return Response.ok(response).build();
    }
}
