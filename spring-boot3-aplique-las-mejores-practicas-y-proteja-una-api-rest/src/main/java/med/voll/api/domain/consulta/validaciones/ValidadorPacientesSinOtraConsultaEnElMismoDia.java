package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacientesSinOtraConsultaEnElMismoDia implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var primerHora = datos.fecha().withHour(7);
        var ultimoHora = datos.fecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHora, ultimoHora);
        if(pacienteTieneOtraConsultaEnElDia){
            throw new ValidacionException("Paciente ya tiene una consulta reservada para ese dia");
        }
    }


}
