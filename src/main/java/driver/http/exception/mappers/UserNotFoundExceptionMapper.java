package driver.http.exception.mappers;

import application.domain.exceptions.UserNotFoundException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class UserNotFoundExceptionMapper {

    @ServerExceptionMapper
    public Response toResponse(UserNotFoundException exception) {
        String message = "User with CPF %s not found.".formatted(exception.cpf.value);
        ErrorResponse responseBody = new ErrorResponse(UserNotFoundException.KEY, message);
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(responseBody)
                .build();
    }
}
