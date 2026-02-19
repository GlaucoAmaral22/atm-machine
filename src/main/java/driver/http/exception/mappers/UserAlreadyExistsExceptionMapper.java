package driver.http.exception.mappers;

import application.domain.exceptions.UserAlreadyExistsException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class UserAlreadyExistsExceptionMapper {

    @ServerExceptionMapper
    public Response toResponse(UserAlreadyExistsException exception) {
        String message = "User with CPF %s already exists.".formatted(exception.cpf.value());
        ErrorResponse responseBody = new ErrorResponse(exception.KEY, message);
        return Response
                .status(Response.Status.CONFLICT)
                .entity(responseBody)
                .build();
    }
}
