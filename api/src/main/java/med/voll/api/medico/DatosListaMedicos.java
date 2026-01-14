package med.voll.api.medico;

public record DatosListaMedicos(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad
    ) {

    public DatosListaMedicos(Medico medico) {
        this(
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad()
        );
    }
}
