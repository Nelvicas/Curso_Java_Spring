package com.aluracursos.screenmatch_frases.service;


import com.aluracursos.screenmatch_frases.dto.FraseDTO;
import com.aluracursos.screenmatch_frases.model.Frases;
import com.aluracursos.screenmatch_frases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repository;

    public FraseDTO obtenerFraseAleatoria() {
        Frases frases = repository.obtenerFraseAleatoria();
        return new FraseDTO(frases.getTitulo(), frases.getFrase(), frases.getPersonaje(), frases.getPoster());
    }
}
