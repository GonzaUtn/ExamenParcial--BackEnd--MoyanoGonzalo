package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Controller;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.dnaRequest;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.dnaResponse;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository.dnaRepository;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service.dnaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class dnaControllerTest {

    @Autowired
    private dnaController controller;

    @Autowired
    private dnaService servicio;

    @Autowired
    private dnaRepository repository;

    @Autowired
    private LocalValidatorFactoryBean validatorFactoryBean;

    private Validator validator;

    @BeforeEach
    void setUp() {
        // Limpiar la base de datos antes de cada prueba
        repository.deleteAll();
        validator = validatorFactoryBean.getValidator();
    }

    @Test
    void testCheckMutant_WhenMutant_ReturnsOk() {
        dnaRequest request = new dnaRequest();
        request.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        ResponseEntity<dnaResponse> response = controller.checkMutant(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isMutant());
    }

    @Test
    void testCheckMutant_WhenNotMutant_ReturnsForbidden() {
        dnaRequest request = new dnaRequest();
        request.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"});

        ResponseEntity<dnaResponse> response = controller.checkMutant(request);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertFalse(response.getBody().isMutant());
    }

    @Test
    void testHandleConstraintViolationException_ReturnsBadRequest() {
        dnaRequest request = new dnaRequest();
        request.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACX"}); // Secuencia inválida con 'X'

        try {
            ResponseEntity<dnaResponse> response = controller.checkMutant(request);
        } catch (ConstraintViolationException e) {
            ResponseEntity<String> exceptionResponse = controller.handleConstraintViolationException(e);
            assertEquals(HttpStatus.BAD_REQUEST, exceptionResponse.getStatusCode());
            assertEquals("Secuencia de ADN invalida", exceptionResponse.getBody());
        }
    }
}