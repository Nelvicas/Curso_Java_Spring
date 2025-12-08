package com.luracursos.screenmatch.principal;

import com.luracursos.screenmatch.model.DatosEpisodio;
import com.luracursos.screenmatch.model.DatosSerie;
import com.luracursos.screenmatch.model.DatosTemporadas;
import com.luracursos.screenmatch.model.Episodio;
import com.luracursos.screenmatch.services.ConsumoAPI;
import com.luracursos.screenmatch.services.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=87dbee7d";
    private ConvierteDatos conversor = new ConvierteDatos();

    //  declarar metodo
    public void muestraElMenu(){
        System.out.println("Por favor esriba el nombre de la serie que desea buscar: ");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        ///  Busca los datos de todas las temporadas
        ///  Treaer solo las episodios de la temporada

        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+i+API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }

        //temporadas.forEach(System.out::println);


        // Mostrar solo el titulo de los episodios para las temporadas
        /*
        for (int i = 0; i < datos.totalDeTemporadas(); i++){
            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }
        */


        // Funciones lamda

        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));


        ///   Convertir todas las informaciones a una lista del tipo DatosEpisodios

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        /*
        // Top 5 episodios  uso de filros
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primer filtro N/A " + e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("Segundo filtro ordenacion (M>m)" + e))
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("Tercer filtro Mayusculas (m>M)" + e))
                .limit(5)
                .forEach(System.out::println);


         */

        ///  Convirtiendo los datos a una lista de tipo episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(),d)))
                .collect(Collectors.toList());

        //episodios.forEach(System.out::println);


        /// / Busqueda de episodios a partir de x año

        System.out.println("Indica el año a partir del cual deseas ver los episodios ");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1,1);


        /*
        // fecha de busqueda
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada " + e.getTemporada() +
                                "Episodio " + e.getTitulo() +
                                "Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
                ));


         */


        /*
        //  busca epsodios por un pedazo de titulos

        System.out.println("Escriba el titulo del episodio que desea ver:");
        var pedazoTitulo = teclado.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if(episodioBuscado.isPresent()){
            System.out.println("Episodio encontrado");
            System.out.println("Los datos son: " + episodioBuscado.get());
        }else {
            System.out.println("Episodio no encontrado");
        }

         */


        //  Uso de map

        Map<Integer, Double>evaluacionesPorTemporadas = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporadas);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));

        System.out.println("Media de las evaluaciones: " + est.getAverage());
        System.out.println("Episodio mejor evaluado: " + est.getMax());
        System.out.println("Episodio peor evaluado: " + est.getMin());
    }

}
