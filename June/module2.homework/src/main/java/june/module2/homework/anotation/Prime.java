package june.module2.homework.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import june.module2.homework.validator.PrimeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PrimeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Prime {
    String message() default "Not a prime number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
