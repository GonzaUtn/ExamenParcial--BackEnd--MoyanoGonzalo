package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.StatsResponse;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities.Dna;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository.dnaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class statsServiceTest {

    @Autowired
    private  statsService servicio;

    @Autowired
    private dnaRepository repository;

    @BeforeEach
    void setUp() {
        // Limpiar la base de datos antes de cada prueba
        repository.deleteAll();
    }

    @Test
    void testGetStats() {
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));

         StatsResponse response = servicio.getStats();
         assertEquals(4L, response.getCantidadMutantes() );
         assertEquals(6L, response.getCantidadHumanos() );
         assertEquals(0.6666666666666666, response.getRatio());

    }

    @Test
    void testGetRepository() {
        // Verificar que el repositorio se inyecte correctamente en el servicio
        assertNotNull(servicio.getRepository());
        assertEquals(repository, servicio.getRepository());
    }
}