import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Icon icon = new ImageIcon("src/img/vet.png");

        String nombre = validarCaracteres("Ingrese el nombre del animal:");
        String dueno = validarCaracteres("Ingrese el nombre del dueño:");
        int edad = validarNum("Ingrese la edad del animal:");
        double peso = validarNum("Ingrese el peso del animal:");
        String veterinario = validarCaracteres("Ingrese el nombre del veterinario:");

        //objeto

        Turno turno1 = new Turno(nombre, edad, peso, dueno, veterinario);

        //menu

        String[]opciones = {"Ver estado del animal", "Realizar evaluacion", "Programar turno", "Mejorar salud", "Verificar turno", "Mostrar detalles del a consulta","Salir" };
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "selecciona una opcion",
                    "Menu Veterinaria",
                    0,
                    0,
                    icon,
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
    public static String validarCaracteres(String mensaje){
        String palabra = "";
        while (palabra.equals("")) {
            palabra = JOptionPane.showInputDialog(mensaje);
        }
        return palabra;
    }
    public static int validarNum(String mensaje){
        boolean flag ;
        String num ="" ;
        do {
            flag =true;
            num = JOptionPane.showInputDialog(mensaje);
            while (num.isEmpty()) {
                num = JOptionPane.showInputDialog(mensaje);
            }
            for (int i = 0; i < num.length(); i++) {
                if (!Character.isDigit(num.charAt(i))) {
                    flag = false;
                    break;
                }
            }
        } while (!flag);

        return Integer.parseInt(num);
    }

}




