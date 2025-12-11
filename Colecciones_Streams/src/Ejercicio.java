import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
    public static void main(String[] args) {

        System.out.println("///////  Listas   /////");

        List<String> empleados = new ArrayList<>();
        empleados.add("Juan");
        empleados.add("Maria");
        empleados.add("Carlos");
        empleados.add("Ana");

        System.out.println(empleados);

        ///   Eliminano elementos
        System.out.println("///////  Eliminando elementos   /////");

        List<String> inicial = new ArrayList<>();
        inicial.add("Juana");
        inicial.add("Lucas");
        inicial.add("Pedro");
        inicial.add("Antonio");

        System.out.println(inicial);
        System.out.println(inicial.remove("Pedro"));
        System.out.println(inicial);



        ///   Accediendo a elementos
        System.out.println("///////  Accediendo a elementos   /////");

        List<String> empleados2 = new ArrayList<>();
        empleados2.add("Juan");
        empleados2.add("María");
        empleados2.add("Ana");
        empleados2.add("Pedro");
        empleados2.add("Antonio");

        System.out.println("La segunda persona de la lista es: "+ empleados2.get(1));
        System.out.println("Total de empleados: " + empleados2.toArray().length);

    }
}
