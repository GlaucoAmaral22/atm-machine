package driver.bankaccount.http.create;

import application.bankaccount.commands.CreateBankAccountCommand;
import application.bankaccount.ports.inbound.CreateBankAccount;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/bankAccount")
public class Endpoint {

    private final CreateBankAccount handler;

    public Endpoint (CreateBankAccount handler) {
        this.handler = handler;
    }

    @POST
    public Response post(Request request) {
        CreateBankAccountCommand command = request.toCommand();
        handler.handle(command);
        return Response.status(Response.Status.CREATED).build();
    }
}
