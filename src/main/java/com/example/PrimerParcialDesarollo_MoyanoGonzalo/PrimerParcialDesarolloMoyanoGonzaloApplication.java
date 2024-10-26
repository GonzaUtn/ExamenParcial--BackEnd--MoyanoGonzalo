package com.example.PrimerParcialDesarollo_MoyanoGonzalo;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities.Dna;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service.dnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimerParcialDesarolloMoyanoGonzaloApplication {

	@Autowired
	private dnaService dnaService;

	public static void main(String[] args) {
		SpringApplication.run(PrimerParcialDesarolloMoyanoGonzaloApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// Insertar algunos registros de ADN
			String[] dna1 = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
			String[] dna2 = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};


			//Analizamos los adn
			dnaService.analizarDna(dna1);
			dnaService.analizarDna(dna2);


		};
	}
}