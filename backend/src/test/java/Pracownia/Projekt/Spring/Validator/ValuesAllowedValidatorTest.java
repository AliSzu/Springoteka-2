package Pracownia.Projekt.Spring.Validator;

import Pracownia.Projekt.Spring.Validator.CustomAnnotation.ValuesAllowed;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ValuesAllowedValidatorTest {

    private static final String[] ALLOWED_SORT_FIELDS = new String[]{"title", "author", "createdAt", "status"};
//    private static final String ALLOWED_SORT_FIELDS_DELIMITED = String.join(",", Arrays.asList(ALLOWED_SORT_FIELDS));
//
//    private static Validator validator;
//
//    @BeforeAll
//    public static void setupValidator() throws Exception {
//        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
//            validator = factory.getValidator();
//        }
//    }
//
//    @Test
//    public void testValidationWithSpringValidator() {
//        ValuesAllowed valuesAllowed = ValuesAllowed.class.getAnnotation(ValuesAllowed.class);
//
//        Set<ConstraintViolation<ValuesAllowed>> violations = validator.validate(valuesAllowed);
//
//        assertEquals(0, violations.size());
//    }

}