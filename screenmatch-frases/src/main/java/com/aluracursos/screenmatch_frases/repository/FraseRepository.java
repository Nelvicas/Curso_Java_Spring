package com.aluracursos.screenmatch_frases.repository;

import com.aluracursos.screenmatch_frases.dto.FraseDTO;
import com.aluracursos.screenmatch_frases.model.Frases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FraseRepository extends JpaRepository<Frases, Long> {


    @Query("SELECT f FROM Frases f ORDER BY function('RANDOM') LIMIT 1")
    public Frases obtenerFraseAleatoria();
}
