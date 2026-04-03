package driver.user.http.exception.mappers;

import application.user.domain.exceptions.UserNotFoundException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class UserNotFoundExceptionMapper {

    @ServerExceptionMapper
    public Response toResponse(UserNotFoundException exception) {
        String message = "User with Id %s not found.".formatted(exception.id.toString());
        ErrorResponse responseBody = new ErrorResponse(exception.KEY, message);
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(responseBody)
                .build();
    }
}
