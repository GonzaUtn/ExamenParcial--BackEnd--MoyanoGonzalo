package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Controller;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.StatsResponse;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service.statsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class statsController {

    private final statsService statsServ;
    // Inyeccion de dependencias
    @Autowired
    public statsController(statsService statsServ) {
        this.statsServ = statsServ;
    }
    // Metodo para realizar el get de las estadisticas
    @GetMapping
    public ResponseEntity<StatsResponse> getStats() {
        StatsResponse statsResponse = statsServ.getStats();
        return ResponseEntity.ok(statsResponse);
    }
}
