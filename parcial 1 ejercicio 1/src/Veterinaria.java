import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Veterinaria {
    //Atributos
    private String nombre;
    private int edad;
    private double peso;
    private String dueno;
    private String veterinario;
    private LocalDate fechaTurno;
    private boolean tratamiento;
    private boolean estadoDeSalud;


    //Constructor con todo

    public Veterinaria (String nombre, int edad,double peso,String dueno,String veterinario,LocalDate fechaTurno,boolean tratamiento,boolean estadoDeSalud){
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
        this.dueno=dueno;
        this.veterinario=veterinario;
        this.fechaTurno=fechaTurno;
        this.tratamiento=tratamiento;
        this.estadoDeSalud=estadoDeSalud;
    }
    //Constructor con informacion basica

    public Veterinaria (String nombre,String dueno){
        this.nombre=nombre;
        this.dueno=dueno;
        this.fechaTurno=LocalDate.now();
        this.tratamiento=false;
        this.estadoDeSalud =false;
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

    //metodos


    public void realizarEvaluacion(){
        JOptionPane.showMessageDialog(null,"Comenzando la evaluacion");

        if(this.estadoDeSalud){
            JOptionPane.showMessageDialog(null,"El animal esta en buen estado de salud y no requiere tratamiento");
            this.tratamiento=false;
        }else{
            JOptionPane.showMessageDialog(null,"El animal necesita tratamiento");
            this.tratamiento=true;

        }
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Queres agendar un turno?", "Programar Turno", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            programarTurno();
        }

    }

    public void aplicarTratamiento(){
        if(this.tratamiento){
            this.estadoDeSalud=true;
            this.tratamiento=false;
            JOptionPane.showMessageDialog(null,"El tratamiento fue efectivo el animal ya no necesita tratamiento");
        }else{
            JOptionPane.showMessageDialog(null,"el animal esta bien");
        }
    }
    public void programarTurno(){
        String[] opciones = {"Agendar de aca a 1 semana", "Agendar fecha personalizada", "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(null, "¿Para cuando queres agendar el turno?", "Agendar Turno",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
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
        if(LocalDate.now().isAfter(this.fechaTurno)){
            JOptionPane.showMessageDialog(null,"La fecha del turno ya paso, necesita repogramar");
        }else{
            Period tiempoRestante = Period.between(LocalDate.now(),this.fechaTurno);
            JOptionPane.showMessageDialog(null,"Faltan: "+tiempoRestante.getDays()+" dias para el turno");
        }
    }
    public String validarCaracteres(String mensaej) {
        String palabra = "";
        while (palabra.equals("")) {
            palabra = JOptionPane.showInputDialog(mensaej);
        }
        return palabra;
    }
    public int validarNumeros(String mensaje) {
        boolean flag ;
        String num ="";
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




    @Override
    public String toString() {
        return "Veterinaria{" +
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
