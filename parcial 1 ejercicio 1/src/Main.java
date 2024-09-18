import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del animal:");
        String dueno = JOptionPane.showInputDialog("Ingrese el nombre del dueño:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del animal:"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del animal:"));
        String veterinario = JOptionPane.showInputDialog("Ingrese el nombre del veterinario:");
        //objeto
        Turno turno1 = new Turno(nombre, edad, peso, dueno, veterinario, null);
        //menu
        String[] opciones = {"Ver estado del animal", "Realizar evaluacion", "Programar turno", "Mejorar salud", "Verificar turno", "Mostrar detalles del a consulta","Salir" };
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "selecciona una opcion",
                    "Menu Veterinaria",
                    0,
                    0,
                    null,
                    opciones,
                    opciones [0]
            );

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, turno1);
                    break;
                case 1:
                    turno1.realizarEvaluacion();
                    break;
                case 2:
                    turno1.programarTurno();
                    break;
                case 3:
                    turno1.aplicarTratamiento();
                    break;
                case 4:
                    turno1.verificarTurno();
                    break;
                case 5:
                    turno1.mostrarDetallesConsulta();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,"saliendo");
                    break;
            }
        } while (opcion != 6);
    }


    }
