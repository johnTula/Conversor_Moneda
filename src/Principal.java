import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Bienvendo al Conversor de Moneda");
        System.out.println("*********************************");
        System.out.println("Por favor seleccione el numero correspondiente a la moneda que desea convertir:");

        Moneda opciones = new Moneda();
        opciones.mostrarOpcionesDeMoneda();

        Scanner lector = new Scanner(System.in);
        int divisaConvertir = lector.nextInt();
        System.out.println(opciones.mostarMoneda(divisaConvertir));


        System.out.println("Por favor seleccione el numero correspondiente a la moneda actual:");
        opciones.mostrarOpcionesDeMoneda();
        int divisaActual = lector.nextInt();
        System.out.println(opciones.mostarMoneda(divisaActual));

        System.out.println("Por favor ingrese la cantidad que va a convertir: ");
        double valorAConvertir = lector.nextDouble();

        System.out.println("vas a convertir "+ valorAConvertir + " de " +
                opciones.mostarMoneda(divisaActual) +
                " a " + opciones.mostarMoneda(divisaConvertir));


        SolicitudDatos consulta = new SolicitudDatos(opciones.mostarMoneda(divisaActual),opciones.mostarMoneda(divisaConvertir),valorAConvertir);
        try {
            MonedaConvertida resultado = consulta.solicitarDatos();
            System.out.println("El resultado de la conversión es: " + resultado.getConversionResult());
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }




    }
}
