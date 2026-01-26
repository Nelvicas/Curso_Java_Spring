package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorConsultaConAnticipacion implements ValidadorDeConsultas{

    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();
        if(diferenciEnMinutos < 30){
            throw new ValidacionException("Horario seleccionado con menos de 30 minutos de anticipacion ");
        }
    }
}
