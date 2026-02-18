package driver.http.exception.mappers;

import application.domain.exceptions.InvalidCpfException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class InvalidCpfExceptionMapper {

    @ServerExceptionMapper
    public Response toResponse(InvalidCpfException exception) {
        String message = "Invalid CPF value: %s".formatted(exception.value);
        ErrorResponse responseBody = new ErrorResponse(exception.KEY, message);
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(responseBody)
                .build();
    }
}
