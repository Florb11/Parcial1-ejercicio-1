import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del animal:");
        String dueno = JOptionPane.showInputDialog("Ingrese el nombre del dueño:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del animal:"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del animal:"));
        String veterinario = JOptionPane.showInputDialog("Ingrese el nombre del veterinario:");
        Veterinaria veterinaria1 = new Veterinaria(nombre, edad, peso, dueno, veterinario, null, false, false);

        String[] menu = {"Ver estado del animal", "Realizar evaluacion", "Programar turno", "Mejorar salud", "Verificar turno", "Salir" };
        int opcion = 0;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Elija una opción", "Menu Veterinaria", JOptionPane.DEFAULT_OPTION, 0, null, menu, menu[0]);

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, veterinaria1);
                    break;
                case 1:
                    veterinaria1.realizarEvaluacion();
                    break;
                case 2:
                    veterinaria1.programarTurno();
                    break;
                case 3:
                    veterinaria1.aplicarTratamiento();
                    break;
                case 4:
                    veterinaria1.verificarTurno();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema.", "", JOptionPane.DEFAULT_OPTION);
                    break;
            }
        } while (opcion != 5);
    }


    }
