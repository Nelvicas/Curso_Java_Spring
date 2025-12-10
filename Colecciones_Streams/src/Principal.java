import java.util.*;

public class Principal {
    public static void main(String[] args) {

        //   LISTAS
        List<String> empleados = new ArrayList<>();
        empleados.add("Maria");
        empleados.add("Juan");
        empleados.add("Maria");

        System.out.println(empleados);
        empleados.remove("Maria");     /// eliminar elemento de la lista
        System.out.println(empleados);

        //   Seleccionar elemento de la lista mediante su indice
        System.out.println(empleados.get(0));


        //   SET
        System.out.println("//////////  SET /////");

        Set<String> productos = new HashSet<>();
        productos.add("agua");
        productos.add("gaseosa");
        productos.add("boligrafo");
        productos.add("television");
        productos.add("agua");       // esta estructura de dato no nos permite la repeticion de valores

        System.out.println(productos);


        ///   Map  se identifica por clave-valor

        System.out.println("/////////  map ////////");

        Map<Integer, String> trabajadores = new HashMap<>();
        trabajadores.put(1, "Teresa");
        trabajadores.put(2, "Ivan");
        trabajadores.put(3, "Teresa");
        trabajadores.put(1, "Flavia");   /// remplaza el valor 1
        System.out.println(trabajadores);

        System.out.println(trabajadores.get(1));

        trabajadores.put(7, "Alberto");
        System.out.println(trabajadores);
        System.out.println(trabajadores.get(7));


    }
}
