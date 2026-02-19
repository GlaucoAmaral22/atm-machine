package application.domain.exceptions;

public class InvalidBirthDateException extends RuntimeException{
    public final String KEY = "INVALID_BIRTH_DATE";

    public final String value;

    public InvalidBirthDateException(String value) {
        this.value = value;
    }
}
