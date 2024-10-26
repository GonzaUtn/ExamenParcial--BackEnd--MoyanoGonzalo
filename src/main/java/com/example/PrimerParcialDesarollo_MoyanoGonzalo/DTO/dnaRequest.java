package com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.validaciones.ValidDna;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dnaRequest {
    //Validamos la cadena que recibimos del controlador con el post
    @ValidDna
    private String[] dna;
}