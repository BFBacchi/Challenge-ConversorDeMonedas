import javax.swing.*;
import java.net.http.HttpResponse;

public class ConversorDeMonedas {

    public static void ConvertirDePesosA() {
        ObtenerDatos obtenerDatos = new ObtenerDatos();
        Convertir convertir = new Convertir();

        // Obtener los datos de la API
        HttpResponse<String> response = obtenerDatos.ObtenerDatosApi("https://v6.exchangerate-api.com/v6/31e0c5ddc5211cf106cefcd4/latest/USD");

        // Convertir JSON a objeto Moneda
        Moneda moneda = convertir.aObjectJava(response);

        // Variables para controlar el bucle
        boolean realizarOtraConversion = true;

        do {
            // Opciones de conversión
            String[] opciones = {
                    "Convertir de pesos Argentinos a Dólar",
                    "Convertir de pesos Argentinos a Euros",
                    "Convertir de pesos Argentinos a Libras Esterlinas",
                    "Convertir de pesos Argentinos a Yen Japonés",
                    "Convertir de pesos Argentinos a Won sul-coreano",
                    "Convertir de Dólar a pesos Argentinos",
                    "Convertir de Euros a pesos Argentinos",
                    "Convertir de Libras Esterlinas a pesos Argentinos",
                    "Convertir de Yen Japonés a pesos Argentinos",
                    "Convertir de Won sul-coreano a pesos Argentinos"
            };

            // Mostrar el menú select y obtener la selección del usuario
            String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                    "Conversor de Monedas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            // Verificar si el usuario cancela la selección
            if (seleccion == null) {
                realizarOtraConversion = false;
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                break; // Salir del bucle
            }

            double resultado;

            switch (seleccion) {
                case "Convertir de pesos Argentinos a Dólar":
                    resultado = convertir.convertirMoneda(1, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de pesos Argentinos a Euros":
                    resultado = convertir.convertirMoneda(2, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de pesos Argentinos a Libras Esterlinas":
                    resultado = convertir.convertirMoneda(3, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de pesos Argentinos a Yen Japonés":
                    resultado = convertir.convertirMoneda(4, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de pesos Argentinos a Won sul-coreano":
                    resultado = convertir.convertirMoneda(5, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de Dólar a pesos Argentinos":
                    resultado = convertir.convertirMoneda(6, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de Euros a pesos Argentinos":
                    resultado = convertir.convertirMoneda(7, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de Libras Esterlinas a pesos Argentinos":
                    resultado = convertir.convertirMoneda(8, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de Yen Japonés a pesos Argentinos":
                    resultado = convertir.convertirMoneda(9, obtenerCantidadValida(), moneda);
                    break;
                case "Convertir de Won sul-coreano a pesos Argentinos":
                    resultado = convertir.convertirMoneda(10, obtenerCantidadValida(), moneda);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    return;
            }

            JOptionPane.showMessageDialog(null, "Resultado: " + resultado);

            // Preguntar al usuario si desea realizar otra conversión
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta != JOptionPane.YES_OPTION) {
                realizarOtraConversion = false;
                JOptionPane.showMessageDialog(null, "Gracias");
            }

        } while (realizarOtraConversion);
    }

    // Método para obtener una cantidad válida (valor numérico)
    public static double obtenerCantidadValida() {
        while (true) {
            try {
                String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad a convertir:");
                if (cantidadStr == null) {
                    throw new NullPointerException(); // Lanza una excepción para manejar la cancelación
                }
                return Double.parseDouble(cantidadStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un valor numérico válido.");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                throw e; // Relanza la excepción para manejar la cancelación
            }
        }
    }
}
