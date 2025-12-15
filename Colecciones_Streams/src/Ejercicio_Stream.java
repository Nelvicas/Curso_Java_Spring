import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio_Stream {
    public static void main(String[] args) {

        ///  Seleccionar por nombres cortos
        List<String> empleados = List.of("Ana", "Bruno", "Carlos", "Amanda", "Alice", "Daniel", "Caroline");
        List<String> nombresCortos = empleados.stream()
                .filter(nombre -> nombre.length() > 5)
                .collect(Collectors.toList());
        System.out.println(nombresCortos);


        ///   Calculando el cuadrado de numeros

        System.out.println("///////// Cuadrado de numeros ///////////");

        List<Integer> numeros = List.of(2, 3, 5, 7, 11);
        List<Integer> cuadrado = numeros.stream()
                .map(valor -> valor * valor)
                .collect(Collectors.toList());
        System.out.println("Los cuadrasos de los numeros son: " + cuadrado);



        ///  calculando impuesto total

        System.out.println("////////// Impuesto total /////////");


        List<Double> preciosProductos = List.of(29.99, 49.50, 15.75, 99.99);

        double totalGastado = preciosProductos.stream()
                .reduce(0.0, Double::sum);

        double impuesto = totalGastado * 0.08;
        double totalConImpuesto = totalGastado + impuesto;

        System.out.println("Valor total antes del impuesto: " + String.format("%.2f", totalGastado));
        System.out.println("Valor total con impuesto de 8%: " + String.format("%.2f", totalConImpuesto));



        /// / estadisticas de notas

        System.out.println(" ///// Estadisticas de notas /////////");

        List<Double> notas = List.of(7.5, 8.0, 6.5, 9.0, 10.0);

        double sumaNotas = notas.stream().reduce(0.0, Double::sum);

        double media = sumaNotas / notas.size();

        double menorNota = notas.stream().min(Double::compare).get();

        double mayorNota = notas.stream().max(Double::compare).get();

        System.out.println("La media de las notas es: " + media);
        System.out.println("La nota más baja fue: " + menorNota);
        System.out.println("La nota más alta fue: " + mayorNota);
    }
}
