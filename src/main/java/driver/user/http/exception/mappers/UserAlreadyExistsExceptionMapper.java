package driver.user.http.exception.mappers;

import application.user.domain.exceptions.UserAlreadyExistsException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class UserAlreadyExistsExceptionMapper {

    @ServerExceptionMapper
    public Response toResponse(UserAlreadyExistsException exception) {
        String message = "User with Id %s already exists.".formatted(exception.id.toString());
        ErrorResponse responseBody = new ErrorResponse(exception.KEY, message);
        return Response
                .status(Response.Status.CONFLICT)
                .entity(responseBody)
                .build();
    }
}
