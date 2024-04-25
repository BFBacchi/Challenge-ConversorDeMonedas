import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtenerDatos {

    public HttpResponse<String> ObtenerDatosApi(String url)  {

        //Direccion de solicitud a la API
        URI direccion = URI.create(url);

        //Crear el cliente http
        HttpClient client = HttpClient.newHttpClient();

        //Crear el httpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        //Crear el HttpResponse
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
