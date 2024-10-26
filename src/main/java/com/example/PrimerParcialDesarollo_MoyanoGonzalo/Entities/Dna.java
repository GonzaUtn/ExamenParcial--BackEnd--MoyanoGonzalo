package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities;

import jakarta.persistence.Entity;
import lombok.*;


import java.io.Serializable;

@Entity(name = "ADN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dna extends BaseDna implements Serializable {
    private String dna;
    private boolean isMutant;
}
