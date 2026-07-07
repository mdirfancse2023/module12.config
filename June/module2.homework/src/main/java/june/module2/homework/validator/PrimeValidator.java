package june.module2.homework.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import june.module2.homework.anotation.Prime;

public class PrimeValidator implements ConstraintValidator<Prime, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value == null || value < 2) return false;
        for(int i = 2 ; i <= Math.sqrt(value) ; i++){
            if(value % i == 0) return false;
        }
        return true;
    }
}
