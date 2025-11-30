package com.luracursos.screenmatch;


import com.luracursos.screenmatch.services.ConsumoAPI;
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
        //var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=juego+de+tronos&apikey=87dbee7d");  //  consumo de primer api
        var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");              //  consumo de segunda api

        System.out.println(json);
    }
}
