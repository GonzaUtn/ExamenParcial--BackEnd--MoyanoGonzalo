package com.example.PrimerParcialDesarollo_MoyanoGonzalo.validaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.Payload;
import static org.junit.jupiter.api.Assertions.*;

class DnaValidatorTest {

    private DnaValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DnaValidator();
        ValidDna validDna = createValidDnaAnnotation();
        validator.initialize(validDna);
    }

    private ValidDna createValidDnaAnnotation() {
        return new ValidDna() {
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return ValidDna.class;
            }

            @Override
            public String message() {
                return "Secuencia de ADN invalida";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }

            @Override
            public int minLength() {
                return 1;
            }

            @Override
            public int maxLength() {
                return 100;
            }
        };
    }

    @Test
    void testIsValidWithValidDna() {
        String[] validDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(validator.isValid(validDna, null));
    }

    @Test
    void testIsValidWithInvalidDna() {
        String[] invalidDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTZ"}; // 'Z' no es un carácter válido
        assertFalse(validator.isValid(invalidDna, null));
    }

    @Test
    void testIsValidWithNullDna() {
        assertFalse(validator.isValid(null, null));
    }

    @Test
    void testIsValidWithEmptyDna() {
        String[] emptyDna = {};
        assertFalse(validator.isValid(emptyDna, null));
    }

    @Test
    void testIsValidWithDifferentLengths() {
        String[] differentLengthsDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACT"}; // Longitud diferente
        assertFalse(validator.isValid(differentLengthsDna, null));
    }
}