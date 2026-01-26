package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorFueraHorarioConsulta implements  ValidadorDeConsultas{

    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeAperturaClinica = fechaConsulta.getHour() < 7;
        var horarioDespuesDeCierreCLinica = fechaConsulta.getHour() > 18;
        if(domingo || horarioAntesDeAperturaClinica || horarioDespuesDeCierreCLinica){
            throw new ValidacionException("Horario seleccionado fuera del horario de atencion de la clinica");
        }
    }
}
