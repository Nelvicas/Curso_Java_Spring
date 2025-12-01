package com.luracursos.screenmatch.services;

public interface IConverteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);   ///   <> se utilza este simbolo para datos genericos

}
