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
@Pattern(regexp = "^\\d{11}$")
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface ValidCpf {

    String message() default "CPF should contains exactly 11 digits";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
