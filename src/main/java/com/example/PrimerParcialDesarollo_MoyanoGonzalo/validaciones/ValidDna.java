
package com.example.PrimerParcialDesarollo_MoyanoGonzalo.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DnaValidator.class)
public @interface ValidDna {
    // Inicializamos el mensaje por default
    String message() default "Secuencia de ADN invalida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    //Inicizalizamos los valores de min y max
    int minLength() default 1;
    int maxLength() default 100;
}