package com.luracursos.screenmatch.principal;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

public class ConstructorPeronalizado {

    // declarar atibutos
    public class Carro {
        private String marca;
        private String modelo;
        private int ano;

        // Constructor personalizado
        public Carro(String marca, String modelo, int ano) {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
        }
    }

    // Crear nuevo objeto


    Carro miCarro = new Carro("Toyota", "Corolla", 2015);


}
