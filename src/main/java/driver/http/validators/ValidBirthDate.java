package driver.http.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@NotNull
@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface ValidBirthDate {

    String message() default "BirthDate format should be: YYYY-MM-DD";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
