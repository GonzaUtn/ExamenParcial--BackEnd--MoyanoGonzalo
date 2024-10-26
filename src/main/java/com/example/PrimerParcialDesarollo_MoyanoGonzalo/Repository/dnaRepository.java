package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities.Dna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface dnaRepository extends JpaRepository<Dna,Long> {
    // Metodo para obtener un ADN si es que existe
    Optional<Dna> findByDna(String dnaSequence);
    //  Metodo para contabilizar los mutante con true y humanos con false
    long countByisMutant(boolean isMutant);

}
