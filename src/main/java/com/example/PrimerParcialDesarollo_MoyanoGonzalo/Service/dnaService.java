package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities.Dna;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository.dnaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.IntStream;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class dnaService {

    @Autowired
    private dnaRepository repository;
    private static final int SEQUENCE_LENGTH = 4; // Longitud de la secuencia de ADN mutante

    // Método para verificar si un ADN es mutante
    public static boolean isMutant(String[] dna) {
        int n = dna.length;

        // Usa IntStream para verificar todas las posibles secuencias
        return IntStream.range(0, n).anyMatch(i ->
                IntStream.range(0, n).anyMatch(j ->
                        checkSequence(dna, i, j, 0, 1, SEQUENCE_LENGTH) || // Horizontal
                                checkSequence(dna, i, j, 1, 0, SEQUENCE_LENGTH) || // Vertical
                                checkSequence(dna, i, j, 1, 1, SEQUENCE_LENGTH) || // Diagonal descendente
                                checkSequence(dna, i, j, 1, -1, SEQUENCE_LENGTH)  // Diagonal ascendente
                )
        );
    }

    // Método para analizar el ADN y determinar si es mutante
    public boolean analizarDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        // Verifica si el ADN ya existe en la base de datos
        Optional<Dna> existingDna = repository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        // Determina si el ADN es mutante
        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        repository.save(dnaEntity);

        return isMutant;
    }

    // Método para verificar una secuencia específica en el ADN
    private static boolean checkSequence(String[] dna, int x, int y, int dx, int dy, int length) {
        int n = dna.length;

        // Verifica si la posición está dentro de los límites del ADN
        if (x + (length - 1) * dx >= n || y + (length - 1) * dy >= n || y + (length - 1) * dy < 0) {
            return false;
        }

        // Obtiene el primer carácter de la secuencia
        char first = dna[x].charAt(y);

        // Usa IntStream para verificar la secuencia
        return IntStream.range(0, length).allMatch(i -> {
            int newX = x + i * dx;
            int newY = y + i * dy;
            return dna[newX].charAt(newY) == first;
        });
    }
}