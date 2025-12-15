import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    //  USO DE STREAM

    public static void main(String[] args) {


        // Filtrar por alguna letra inicial

        List<String> empleados = List.of("Ana", "Juan", "Alberto","Maria");

        List<String> empleadosLetraA = empleados.stream()
                .filter(empleado -> empleado.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(empleados);
        System.out.println(empleadosLetraA);



        // con operaciones matematicas

        List<Double> valorDeVentas = List.of(200.0, 4000.0, 50.0);
        List<Double> comision = valorDeVentas.stream()
                .map(valor -> valor * 0.05)
                .collect(Collectors.toList());
        System.out.println(valorDeVentas);
        System.out.println(comision);



        ///    En encadenar operaciones


        List<Double> comisionFilter = valorDeVentas.stream()
                .map(valor -> valor * 0.05)
                .filter(valor -> valor > 12.0)
                .collect(Collectors.toList());
        System.out.println(comisionFilter);


        /// /  Suma de las comiciones


        double valorTotalDeVentas = valorDeVentas.stream()
                .reduce(0.0, Double::sum);
        System.out.println(valorTotalDeVentas);

    }
}
