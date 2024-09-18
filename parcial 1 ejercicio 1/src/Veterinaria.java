import java.time.LocalDate;

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

    // metodo para el estado de salud

    public String mostrarEstado (boolean estado){
        if(estado){
            return "No necesita tratamiento";
        }
        return "El animal necesita tratamiento";
    }





}
