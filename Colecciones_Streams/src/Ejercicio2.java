import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    //  USO DE STREAM

    public static void main(String[] args) {


        // Filtrar por alguna letra inicial

        List<String> empleados = List.of("Ana", "Juan", "Alberto","Maria");

        List<String> empleadosLetraA = empleados.stream()
                .filter(empleado -> empleado.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(empleados);
        System.out.println(empleadosLetraA);
    }
}
