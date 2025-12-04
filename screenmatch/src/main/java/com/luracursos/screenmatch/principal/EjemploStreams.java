package com.luracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestrEjemplo(){
        List<String> nombres = Arrays.asList("Brenda","Luis","MariaFernanda", "Eric","Genesys");

        nombres.stream()                   //  nos permite hacer varios operaciones encadenadas
                .sorted()                  //  ordenar por orden alfabetico
                .limit(4)                  // limitar lista
                .filter(n -> n.startsWith("L"))      // busca en datos con la primer letra seleccionada
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

    }
}
