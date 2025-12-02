package com.luracursos.screenmatch;


import com.luracursos.screenmatch.model.DatosSerie;
import com.luracursos.screenmatch.services.ConsumoAPI;
import com.luracursos.screenmatch.services.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    //private String url;

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoAPI();
        var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=87dbee7d");     //  consumo de primer api
        //var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");                     //  consumo de segunda api

        System.out.println(json);





        ConvierteDatos conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

    }
}



/*

Un método set sirve para cambiar / asignar un valor a un atributo privado.
Un método get sirve para obtener / leer el valor de un atributo privado.


&Season=1&episode=1
 */

//  en el archivo pom.xml se agrgan las librerias a ocupar en esta pagina se buscal las liberias https://mvnrepository.com/search?q=jackson