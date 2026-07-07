package june.module2.homework.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import june.module2.homework.validator.PasswordValidator;
import june.module2.homework.validator.PrimeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password is in invalid format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
