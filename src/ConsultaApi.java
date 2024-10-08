import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Moneda buscaMoneda(String monedaDeOrigen, String monedaDeDestino, double montoAConvertir){
        URI api_url = URI.create("https://v6.exchangerate-api.com/v6/b50324a7908978d4615cb652/pair/" +
                monedaDeOrigen + "/" +
                monedaDeDestino + "/" +
                montoAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api_url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No se pudo encontrar la moneda");
        }
    }
}
