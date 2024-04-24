
import javax.swing.*;
public class ConversorDeTemperatura {
    public static void ConvertirTemperaturas() {
            // Variables para controlar el bucle
            boolean realizarOtraConversion = true;

            do {
                // Preguntar al usuario si desea realizar otra conversión
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta != JOptionPane.YES_OPTION) {
                    realizarOtraConversion = false;
                    JOptionPane.showMessageDialog(null, "Gracias");
                    break; // Salir del bucle
                }

                // Opciones de conversión
                String[] opciones = {
                        "Convertir de Celsius a Kelvin",
                        "Convertir de Celsius a Fahrenheit",
                        "Convertir de Kelvin a Celsius",
                        "Convertir de Kelvin a Fahrenheit",
                        "Convertir de Fahrenheit a Celsius",
                        "Convertir de Fahrenheit a Kelvin"
                };

                // Mostrar el menú select y obtener la selección del usuario
                String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                        "Conversor de Temperaturas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                // Verificar si el usuario cancela la selección
                if (seleccion == null) {
                    realizarOtraConversion = false;
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                    break; // Salir del bucle
                }

                // Obtener la temperatura válida
                double temperatura = obtenerTemperaturaValida();

                double resultado = 0;

                switch (seleccion) {
                    case "Convertir de Celsius a Kelvin":
                        resultado = convertirCelsiusAKelvin(temperatura);
                        break;
                    case "Convertir de Celsius a Fahrenheit":
                        resultado = convertirCelsiusAFahrenheit(temperatura);
                        break;
                    case "Convertir de Kelvin a Celsius":
                        resultado = convertirKelvinACelsius(temperatura);
                        break;
                    case "Convertir de Kelvin a Fahrenheit":
                        resultado = convertirKelvinAFahrenheit(temperatura);
                        break;
                    case "Convertir de Fahrenheit a Celsius":
                        resultado = convertirFahrenheitACelsius(temperatura);
                        break;
                    case "Convertir de Fahrenheit a Kelvin":
                        resultado = convertirFahrenheitAKelvin(temperatura);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        return;
                }

                JOptionPane.showMessageDialog(null, "Resultado: " + resultado);

            } while (realizarOtraConversion);
        }

        // Método para convertir de Celsius a Kelvin
        public static double convertirCelsiusAKelvin(double celsius) {
            return celsius + 273.15;
        }

        // Método para convertir de Celsius a Fahrenheit
        public static double convertirCelsiusAFahrenheit(double celsius) {
            return (celsius * 9 / 5) + 32;
        }

        // Método para convertir de Kelvin a Celsius
        public static double convertirKelvinACelsius(double kelvin) {
            return kelvin - 273.15;
        }

        // Método para convertir de Kelvin a Fahrenheit
        public static double convertirKelvinAFahrenheit(double kelvin) {
            return (kelvin - 273.15) * 9 / 5 + 32;
        }

        // Método para convertir de Fahrenheit a Celsius
        public static double convertirFahrenheitACelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }

        // Método para convertir de Fahrenheit a Kelvin
        public static double convertirFahrenheitAKelvin(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9 + 273.15;
        }

        // Método para obtener una temperatura válida (valor numérico)
        public static double obtenerTemperaturaValida() {
            while (true) {
                try {
                    String temperaturaStr = JOptionPane.showInputDialog("Introduce la temperatura:");
                    if (temperaturaStr == null) {
                        throw new NullPointerException(); // Lanza una excepción para manejar la cancelación
                    }
                    double temperatura = Double.parseDouble(temperaturaStr);
                    return temperatura;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un valor numérico válido.");
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                    throw e; // Relanza la excepción para manejar la cancelación
                }
            }
        }


    }


