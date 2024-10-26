package com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StatsResponse {
    // Valores que devolvemos con cantidad de Humanos y mutantes
    @JsonProperty("count_mutant_adn")
    private Long cantidadMutantes;
    @JsonProperty("count_human_adn")
    private Long cantidadHumanos;
    private double ratio;
}
