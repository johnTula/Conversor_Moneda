import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SolicitudDatos {

    private String apiKey = "ac863a5ae632bd4e57957847";
    private String monedaBase;
    private String monedaDestino;
    private double valorConvertir;

    public SolicitudDatos(String monedaBase, String monedaDestino, double valorConvertir) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.valorConvertir = valorConvertir;
    }

    public MonedaConvertida solicitarDatos() throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/" +
                apiKey + "/pair/" + monedaBase +
                "/" + monedaDestino +
                "/" + valorConvertir;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), (Type) MonedaConvertida.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo convertir", e);
        }
    }




}
