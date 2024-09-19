import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Turno {
    //Atributos
    private String nombre;
    private int edad;
    private double peso;
    private String dueno;
    private String veterinario;
    private LocalDate fechaTurno;
    private boolean tratamiento;
    private boolean estadoDeSalud;
    private String detallesConsulta;


    //Constructores

    public Turno(String nombre, int edad, double peso, String dueno, String veterinario,
                 LocalDate fechaTurno, boolean tratamiento, boolean estadoDeSalud,String detallesConsulta){
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
        this.dueno=dueno;
        this.veterinario=veterinario;
        this.fechaTurno=LocalDate.now();
        this.tratamiento=tratamiento;
        this.estadoDeSalud=estadoDeSalud;
        this.detallesConsulta=detallesConsulta;

    }

    public Turno(String nombre, int edad, double peso,
                 String dueno, String veterinario, LocalDate fechaTurno) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.dueno = dueno;
        this.veterinario = veterinario;
        this.fechaTurno = fechaTurno; // aca no sabia si ponerlo en null o dejarlo asi
        this.tratamiento = false; // valor "preconsulta"
        this.estadoDeSalud = true; // valor "preconsulta"
        this.detallesConsulta="No asignado"; // valor "preconsulta"
    }

    //get y set


    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getDueno() {
        return dueno;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public boolean isTratamiento() {
        return tratamiento;
    }

    public boolean isEstadoDeSalud() {
        return estadoDeSalud;
    }

    public String getDetallesConsulta() {
        return detallesConsulta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public void setTratamiento(boolean tratamiento) {
        this.tratamiento = tratamiento;
    }

    public void setEstadoDeSalud(boolean estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public void setDetallesConsulta(String detallesConsulta) {
        this.detallesConsulta = detallesConsulta;
    }
    //metodos

    // metodo para evaluar la salud del animal

    public void realizarEvaluacion(){
        JOptionPane.showMessageDialog(null, "Comenzando la consulta...");
        int salud = JOptionPane.showConfirmDialog(null, "¿El animal esta en buen estado de salud?");

        if (salud == JOptionPane.YES_OPTION) {
            this.estadoDeSalud = true;
            this.tratamiento = false;
            JOptionPane.showMessageDialog(null, "El animal esta en buen estado de salud. No requiere tratamiento.");
        } else {
            this.estadoDeSalud = false;
            this.tratamiento = true;
            JOptionPane.showMessageDialog(null, "El animal necesita tratamiento :( ");
        }
        registrarDetallesConsulta();
        if (this.tratamiento) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Quienes agendar un turno para el tratamiento?");
            if (respuesta == JOptionPane.YES_OPTION) {
                programarTurno();
            }
        }
    }
    public void aplicarTratamiento(){
        if(this.tratamiento){
            this.estadoDeSalud=true;
            this.tratamiento=false;
            JOptionPane.showMessageDialog(null,"El tratamiento fue efectivo el animal ya no necesita tratamiento");
        }else{
            JOptionPane.showMessageDialog(null,"el animal esta bien, no necesita tratamiento :D");
        }
    }
    public void programarTurno(){
        Icon icon = new ImageIcon("src/img/turno.png");
        String[] opciones = {"Agendar de aca a 1 semana", "Agendar fecha personalizada", "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(null,
                "¿Para cuando queres agendar el turno?",
                "Agendar Turno",
                0,
                0,
                icon,
                opciones,
                opciones[0]);

        switch (opcion) {
            case 0:
                this.fechaTurno = LocalDate.now().plusWeeks(1);
                JOptionPane.showMessageDialog(null, "El turno esta programado para: " + this.fechaTurno);
                break;
            case 1:
                boolean fechaValida = false;
                int anio = 0, mes = 0, dia = 0;
                do {
                    anio = validarNumeros("Ingrese año:");
                    mes = validarNumeros("Ingrese mes:");
                    dia = validarNumeros("Ingrese día:");
                    if (validarFecha(anio, mes, dia)) {
                        this.fechaTurno = LocalDate.of(anio, mes, dia);
                        JOptionPane.showMessageDialog(null, "El turno esta programado para: " + this.fechaTurno);
                        fechaValida = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La fecha debe ser posterior a la fecha actual");
                    }
                } while (!fechaValida);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "No se agendo ningun turno.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                break;
        }
    }
    public void verificarTurno(){
        if (this.fechaTurno == null) { //  preguntar despues si pasar el null en el contstructor estaria bien
            JOptionPane.showMessageDialog(null, "No hay un turno aun.");
        } else {
            if (LocalDate.now().isAfter(this.fechaTurno)) {
                JOptionPane.showMessageDialog(null, "La fecha del turno ya paso, eliga otra fecha");
            } else {
                Period tiempoRestante = Period.between(LocalDate.now(), this.fechaTurno);
                JOptionPane.showMessageDialog(null, "Faltan " + tiempoRestante.getDays() + " días para el turno.");
            }
        }
    }

    public int validarNumeros(String mensaje) {
        boolean flag ;
        String num = "";
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
    public boolean validarFecha (int anio,int mes, int dia){
        LocalDate fechaIngresada = LocalDate.of(anio, mes, dia);
        return fechaIngresada.isAfter(LocalDate.now());

    }
    public void registrarDetallesConsulta(){
        String detallesConsulta = JOptionPane.showInputDialog(null,"Ingrese los detalles de la consulta");
        String pesoIngresado = JOptionPane.showInputDialog(null, "Ingrese el peso actual del animal:");
        double pesoActual = Double.parseDouble(pesoIngresado);
        this.peso = pesoActual;

        int vacunado = JOptionPane.showConfirmDialog( null, "¿El animal esta vacunado?");
        String vacunacion = (vacunado == JOptionPane.YES_OPTION) ?"Si":"No"; // expresion ternaria que explico el profe

        int cortarUnias = JOptionPane.showConfirmDialog(null, "¿El animal necesita cortarse las uñas?");
        String corteUnias = (cortarUnias == JOptionPane.YES_OPTION) ?"Si":"No";

        this.detallesConsulta = "Detalles generales: "+detallesConsulta+
                "\nPeso actual: "+ this.peso+" kg"+
                "\nVacunado: "+vacunacion+
                "\n¿Necesita cortarse las uñas?: "+corteUnias;

        JOptionPane.showMessageDialog(null, "Detalles de la consulta registrados .");


    }
    public void mostrarDetallesConsulta(){
        JOptionPane.showMessageDialog(null, "Detalles de las consultas:\n" + this.detallesConsulta);

    }

    @Override
    public String toString() {
        return "Turno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", dueno='" + dueno + '\'' +
                ", veterinario='" + veterinario + '\'' +
                ", fechaTurno=" + fechaTurno +
                ", tratamiento=" + tratamiento +
                ", estadoDeSalud=" + estadoDeSalud +
                '}';
    }
}
