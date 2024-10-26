package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Controller;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.dnaRequest;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.dnaResponse;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service.dnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.ConstraintViolationException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/mutant")
@Validated
public class dnaController {

    //Inyeccion de dependencias
    @Autowired
    private dnaService servicio;

    // Metodo post
    @PostMapping
    public ResponseEntity<dnaResponse> checkMutant(@RequestBody @Valid dnaRequest dnarequest) {
        boolean isMutant = servicio.analizarDna(dnarequest.getDna()); // analizamos el DNA y el booleanos que nos retorna lo almacenamos en isMutant
        dnaResponse dnaresponse = new dnaResponse(isMutant); // le pasamos el valor del analisiss al response
        if (isMutant) {
            return ResponseEntity.ok(dnaresponse); //Si es mutante pasamos el response y con 200 ok
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaresponse); // sino es mutante le pasamos el false y nos devuelve un 403 forbidden
        }
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) { //Nos lanza un badRequest cuando usamos caracteres que no son especificados en mi DNAValidator
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Secuencia de ADN invalida");
    }
}