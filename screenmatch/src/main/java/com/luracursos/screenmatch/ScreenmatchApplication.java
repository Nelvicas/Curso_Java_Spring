package com.luracursos.screenmatch;


import com.luracursos.screenmatch.model.DatosEpisodio;
import com.luracursos.screenmatch.model.DatosSerie;
import com.luracursos.screenmatch.model.DatosTemporadas;
import com.luracursos.screenmatch.principal.Principal;
import com.luracursos.screenmatch.services.ConsumoAPI;
import com.luracursos.screenmatch.services.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    //private String url;

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.muestraElMenu();

        /*
        var consumoApi = new ConsumoAPI();
        var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=87dbee7d");     //  consumo de primer api
        //var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");                     //  consumo de segunda api
        System.out.println(json);


         ///   Traer datos de la serie
        ConvierteDatos conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        ///    traer datos de solo un episodio
        json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=87dbee7d");
        DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
        System.out.println(episodios);


        ///  Treaer solo las episodios de la temporada

        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=" + i +"&apikey=87dbee7d");
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }

        temporadas.forEach(System.out::println);*/

    }
}



/*

Un método set sirve para cambiar / asignar un valor a un atributo privado.
Un método get sirve para obtener / leer el valor de un atributo privado.


&Season=1&episode=1
 */

//  en el archivo pom.xml se agrgan las librerias a ocupar en esta pagina se buscal las liberias https://mvnrepository.com/search?q=jackson