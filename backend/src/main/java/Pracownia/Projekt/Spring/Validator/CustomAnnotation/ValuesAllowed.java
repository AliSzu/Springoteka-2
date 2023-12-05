package Pracownia.Projekt.Spring.Validator.CustomAnnotation;

import Pracownia.Projekt.Spring.Validator.ValuesAllowedValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValuesAllowedValidator.class})
public @interface ValuesAllowed {

    String message() default "Field value should be from list of ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] values() default {};
}
