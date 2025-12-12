import java.util.*;

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



        ///   Estructura que no nos permita repetir valos   Set
        System.out.println("///////  Estructura Set para no repetir valores   /////");
        Set<String> eventos = new HashSet<>();
        eventos.add("IA Conference");
        eventos.add("AI Summit");
        eventos.add("DevFest");
        eventos.add("Cloud Expo");
        eventos.add("IA Conference");
        eventos.add("DevFest");

        System.out.println(eventos);



        ///   Estructura que no nos  ayude a almacenar con clave-valor  Map
        System.out.println("///////  Estructura Map clave-valor   /////");

        Map<Integer, String> trabajadores = new HashMap<>();
        trabajadores.put(1, "Teresa");
        trabajadores.put(2, "Ivan");
        trabajadores.put(3, "Juan");
        System.out.println(trabajadores.get(2));



        ///   Estructura Map
        System.out.println("///////  Estructura Map   /////");
        Map<Integer, String> clientes = new HashMap<>();
        clientes.put(1, "María");
        clientes.put(2, "Marcos");
        clientes.put(3, "Ana");
        clientes.put(4, "Juana");
        clientes.put(5, "Karen");

        int idCliente = 3;

        if (clientes.containsKey(idCliente)) {
            String nombreCliente = clientes.get(idCliente);
            System.out.println("El nombre del cliente con ID " + idCliente + " es: " + nombreCliente);
        } else {
            System.out.println("Cliente con ID " + idCliente + " no encontrado.");
        }


    }
}
