import java.time.LocalDate;

public abstract class Empleado {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Double sueldo;
    private LocalDate fechaDeNacimiento;

    public enum Genero{
        Masculino, Femenino;
    }
    private Genero genero;

    public Empleado(String nombre, String primerApellido, String segundoApellido, Double sueldo, LocalDate fechaDeNacimiento, Genero genero) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sueldo = sueldo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Double sueldoConDescuento(Double sueldo){
        Double afp = sueldo * 0.0775;
        Double isss = sueldo * 0.075;

        if(sueldo > 472.0 && sueldo < 895.25){
            sueldo = sueldo - afp - isss - (sueldo * 0.10);
            return sueldo;
        } else if (sueldo >= 895.25 && sueldo <= 2038.10 ) {
            sueldo = sueldo - afp - isss - (sueldo * 0.20);
            return sueldo;
        } else if (sueldo > 2038.10 ) {
            sueldo = sueldo - afp - isss - (sueldo * 0.30);
            return  sueldo;
        }
        else return null;
    }
}