
import javax.swing.JOptionPane;

public class Main {

        public static void main(String[] args) {
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

                // Determinar la conversión basada en la selección del usuario
                double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad a convertir:"));
                double resultado = 0;

                switch (seleccion) {
                    case "Convertir de pesos a Dólar":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.84);
                        break;
                    case "Convertir de pesos a Euros":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.72);
                        break;
                    case "Convertir de pesos a Libras Esterlinas":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.84);
                        break;
                    case "Convertir de pesos a Yen Japonés":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.72);
                        break;
                    case "Convertir de pesos a Won sul-coreano":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.84);
                        break;
                    case "Convertir de Dólar a pesos":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.72);
                        break;
                    case "Convertir de Euros a pesos":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.72);
                        break;
                    case "Convertir de Libras Esterlinas a pesos":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.84);
                        break;
                    case "Convertir de Yen Japonés a pesos":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.72);
                        break;
                    case "Convertir de Won sul-coreano a pesos":
                        resultado = convertirAMonedaExtranjera(cantidad, 0.72);
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
                }

            } while (realizarOtraConversion);
        }

        // Método para convertir de la moneda de tu país a una moneda extranjera
        public static double convertirAMonedaExtranjera(double cantidad, double tasa) {
            return cantidad * tasa;
        }

        // Método para convertir de una moneda extranjera a la moneda de tu país
        // Puedes implementarlo de manera similar al método anterior
    }

