import com.google.gson.Gson;
import java.net.http.HttpResponse;


public class Convertir {

    // Método para convertir monedas según la cantidad ingresada
    public double convertirMoneda(int opcion, double cantidad, Moneda moneda) {
        switch (opcion) {
            case 1: // Convertir de pesos Argentinos a Dólar
                return cantidad / moneda.ars();
            case 2: // Convertir de pesos Argentinos a Euros
                return cantidad / (moneda.eur() * moneda.ars());
            case 3: // Convertir de pesos Argentinos a Libras Esterlinas
                return cantidad / (moneda.gbp() * moneda.ars());
            case 4: // Convertir de pesos Argentinos a Yen Japonés
                return cantidad / (moneda.jpy() * moneda.ars());
            case 5: // Convertir de pesos Argentinos a Won sul-coreano
                return cantidad / (moneda.krw() * moneda.ars());
            case 6: // Convertir de Dólar a pesos Argentinos
                return cantidad * moneda.ars();
            case 7: // Convertir de Euros a pesos Argentinos
                return cantidad * moneda.usd() / moneda.eur();
            case 8: // Convertir de Libras Esterlinas a pesos Argentinos
                return cantidad * moneda.usd() / moneda.gbp();
            case 9: // Convertir de Yen Japonés a pesos Argentinos
                return cantidad * moneda.usd() / moneda.jpy();
            case 10: // Convertir de Won sul-coreano a pesos Argentinos
                return cantidad * moneda.usd() / moneda.krw();
            default:
                throw new IllegalArgumentException("Opción inválida");
        }
    }




    // Método para convertir JSON a objeto Moneda
    public Moneda aObjectJava(HttpResponse<String> response) {
        Gson gson = new Gson();
        Data data = gson.fromJson(response.body(), Data.class);
        return data.conversion_rates();
    }
}
