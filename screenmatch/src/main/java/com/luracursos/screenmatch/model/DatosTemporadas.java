package com.luracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)   // se utiliza para ignorar algunas propiedades que contiene el jsosn

public record DatosTemporadas(
        @JsonAlias("Season") Integer numero,
        @JsonAlias("Episodes")List<DatosEpisodio> episodios
        ) {
}
