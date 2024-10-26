package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.StatsResponse;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository.dnaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter


@Service
public class statsService {

    private final dnaRepository repository;

    @Autowired
    public statsService(dnaRepository repository) {
        this.repository = repository;
    }

    public StatsResponse getStats(){

        long CantidadMutantes = repository.countByisMutant(true); // desde el repository contamos los mutantes
        long CantidadHumanos = repository.countByisMutant(false); // desde el repository contamos los humanos
        double ratio = CantidadHumanos == 0 ? 0: (double)CantidadMutantes / CantidadHumanos; //Obtenemos el ratio
        return new StatsResponse (CantidadMutantes,CantidadHumanos,ratio); // retornamos un response

    }

}
