
import javax.swing.JOptionPane;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String[] optionMenu = {
                "Conversor de monedas",
                "Conversor de temperaturas"
        };
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                "Conversor de unidades", JOptionPane.QUESTION_MESSAGE, null, optionMenu, optionMenu[0]);

        if (Objects.equals(seleccion, "Conversor de monedas")){
            ConversorDeMonedas.ConvertirDePesosA();
        } else {
            ConversorDeTemperatura.ConvertirTemperaturas();
        };

    };
}



