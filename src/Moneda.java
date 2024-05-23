public class Moneda {

    private String[] opciones = {
            "1. Dolares USD",
            "2. Peso Colombiano COP",
            "3. Real Brasileño BRL",
            "4. Euro EUR",
            "5. Peso Mexicano MXN"
    };

    private String[] moneda = {"USD","COP","BRL","EUR","MXN"};
    public void mostrarOpcionesDeMoneda() {
        for (String opcion : opciones) {
            System.out.println(opcion);
        }
    }

    public String mostarMoneda(int opcion){
        String divisa = moneda[opcion-1];
        return divisa;
    }

}
