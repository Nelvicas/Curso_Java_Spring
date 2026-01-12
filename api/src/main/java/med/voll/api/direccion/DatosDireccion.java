package med.voll.api.direccion;


//Metodo POST
public record DatosDireccion(String calle,
                             String numero,
                             String complemento,
                             String barrio,
                             String ciudad,
                             String codigo_postal,
                             String estado) {
}
