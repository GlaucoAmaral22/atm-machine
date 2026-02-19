package driver.http.exception.mappers;

import application.domain.exceptions.InvalidBirthDateException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class InvalidBirthDateExceptionMapper {

    @ServerExceptionMapper
    public Response toResponse(InvalidBirthDateException exception) {
        String message = "Invalid BirthDate value: %s".formatted(exception.value);
        ErrorResponse responseBody = new ErrorResponse(exception.KEY, message);
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(responseBody)
                .build();
    }
}
