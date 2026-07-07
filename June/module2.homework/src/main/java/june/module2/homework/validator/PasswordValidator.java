package june.module2.homework.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import june.module2.homework.anotation.Password;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;
        return password.length() >= 10 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[^a-zA-Z0-9].*");
    }
}
