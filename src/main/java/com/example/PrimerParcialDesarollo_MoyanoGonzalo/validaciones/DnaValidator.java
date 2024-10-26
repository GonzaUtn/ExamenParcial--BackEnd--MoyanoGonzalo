package com.example.PrimerParcialDesarollo_MoyanoGonzalo.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class DnaValidator implements ConstraintValidator<ValidDna, String[]> {

    public static final String CaracteresValidos = "AGCT";

    private int minLength;
    private int maxLength;

    @Override //Inicializacmos las variables min y max
    public void initialize(ValidDna constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
        this.maxLength = constraintAnnotation.maxLength();
    }

    @Override //Vemos lo casos en que son validas las cadenas
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {
        if (dna == null) { //Si ingresamos una cadena Null nos devuelve False
            return false;
        }

        int n = dna.length;
        if (n == 0) {
            return false; // Si ingresamos una cadena vacia nos devuelve False
        }
        // Recorremos el ADN por string y verificamos que no sean null y la que la secuencia no haya llegado al final
        for (String sequence : dna) {
            if (sequence == null || sequence.length() != n) {
                return false;
            }
            for (char c : sequence.toCharArray()) {
                if (CaracteresValidos.indexOf(c) == -1) {
                    return false;
                }
            }
        }

        return true;
    }
}