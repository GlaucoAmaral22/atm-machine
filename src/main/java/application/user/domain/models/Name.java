package application.user.domain.models;

public record Name(String value) {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 100;
    private static final String VALID_PATTERN = "^[\\p{L} .'-]+$";

    public Name {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }

        if (value.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("Name must be at least " + MIN_LENGTH + " characters");
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Name must be at most " + MAX_LENGTH + " characters");
        }

        if (!value.matches(VALID_PATTERN)) {
            throw new IllegalArgumentException("Name contains invalid characters: " + value);
        }

        value = value.trim();
    }
}
