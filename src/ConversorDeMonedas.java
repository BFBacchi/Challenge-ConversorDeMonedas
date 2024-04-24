import javax.swing.*;

public class ConversorDeMonedas {

    public static void ConvertirDePesosA() {
        // Variables para controlar el bucle
        boolean realizarOtraConversion = true;

        do {
            // Opciones de conversión
            String[] opciones = {
                    "Convertir de pesos a Dólar",
                    "Convertir de pesos a Euros",
                    "Convertir de pesos a Libras Esterlinas",
                    "Convertir de pesos a Yen Japonés",
                    "Convertir de pesos a Won sul-coreano",
                    "Convertir de Dólar a pesos",
                    "Convertir de Euros a pesos",
                    "Convertir de Libras Esterlinas a pesos",
                    "Convertir de Yen Japonés a pesos",
                    "Convertir de Won sul-coreano a pesos"
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
            // Determinar la conversión basada en la selección del usuario
            double cantidad = obtenerCantidadValida();
            double resultado = 0;

            switch (seleccion) {
                case "Convertir de pesos a Dólar":
                    resultado = convertirAMonedaExtranjera(cantidad, 873.75);
                    break;
                case "Convertir de pesos a Euros":
                    resultado = convertirAMonedaExtranjera(cantidad, 934.17);
                    break;
                case "Convertir de pesos a Libras Esterlinas":
                    resultado = convertirAMonedaExtranjera(cantidad, 1088.17);
                    break;
                case "Convertir de pesos a Yen Japonés":
                    resultado = convertirAMonedaExtranjera(cantidad, 5.72);
                    break;
                case "Convertir de pesos a Won sul-coreano":
                    resultado = convertirAMonedaExtranjera(cantidad, 0.63);
                    break;
                case "Convertir de Dólar a pesos":
                    resultado = convertirAMonedaExtranjera(cantidad, 0.0011450071268668);
                    break;
                case "Convertir de Euros a pesos":
                    resultado = convertirAMonedaExtranjera(cantidad, 0.00107);
                    break;
                case "Convertir de Libras Esterlinas a pesos":
                    resultado = convertirAMonedaExtranjera(cantidad, 0.00091869150854297);
                    break;
                case "Convertir de Yen Japonés a pesos":
                    resultado = convertirAMonedaExtranjera(cantidad, 0.17779993353274);
                    break;
                case "Convertir de Won sul-coreano a pesos":
                    resultado = convertirAMonedaExtranjera(cantidad, 1.58);
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

    // Método para convertir de la moneda de tu país a una moneda extranjera
    public static double convertirAMonedaExtranjera(double cantidad, double tasa) {
        return cantidad * tasa;
    };

    // Método para obtener una cantidad válida (valor numérico)
    public static double obtenerCantidadValida() {
        while (true) {
            try {
                String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad a convertir:");
                if (cantidadStr == null) {
                    throw new NullPointerException(); // Lanza una excepción para manejar la cancelación
                }
                double cantidad = Double.parseDouble(cantidadStr);
                return cantidad;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un valor numérico válido.");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                throw e; // Relanza la excepción para manejar la cancelación
            }
        }
    }

}
