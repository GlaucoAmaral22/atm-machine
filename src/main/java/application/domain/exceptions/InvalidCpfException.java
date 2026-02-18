package application.domain.exceptions;

public class InvalidCpfException extends RuntimeException{
    public final String KEY = "INVALID_CPF";

    public final String value;

    public InvalidCpfException(String value) {
        this.value = value;
    }
}
