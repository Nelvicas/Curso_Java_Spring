package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;

public record DatosActualizacionMedicos(
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
