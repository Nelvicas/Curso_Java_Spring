package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ConsultaChatGpt;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;


// la palabra entity no ayuda a decir que esto va a ser un entidad de la base de datos

@Entity
@Table(name = "series")

public class Serie {

    @Id         ///   identificador de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)      /// /indicar estrategia de generar el id automaticamente

    private Long id;
    @Column(unique = true)       /// /  para que no se repitan los valores  que sean unicos
    private String  titulo;
    private Integer totalTemporada;
    private Double evaluacion;
    private String poster;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String actores;
    private String sinopsis;
    // @Transient
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios;

    //   Consructor

    public Serie(){

    }

    public Serie(DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalTemporada = datosSerie.totalTemporadas();
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
        this.poster = datosSerie.poster();
        this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        this.actores = datosSerie.actores();
        this.sinopsis = datosSerie.sinopsis();
        //this.sinopsis = ConsultaChatGpt.obtenerTraduccion(datosSerie.sinopsis());
    }


    // getter y setters


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporada() {
        return totalTemporada;
    }

    public void setTotalTemporada(Integer totalTemporada) {
        this.totalTemporada = totalTemporada;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  " genero=" + genero +
                " titulo='" + titulo + '\'' +
                ", totalTemporada=" + totalTemporada +
                ", evaluacion=" + evaluacion +
                ", poster='" + poster + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", episodios='" + episodios + '\'';
    }


    public List<Episodio> getEpisodios(){
        return episodios;
    }

    public void setEpisodio(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSeries(this));
        this.episodios = episodios;       ///  se agrego este metodo para solucioanar el error del dia 24/12
    }
}
