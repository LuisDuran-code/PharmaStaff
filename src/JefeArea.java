import java.time.LocalDate;

public class JefeArea extends Empleado {
    public JefeArea(String nombre, String primerApellido, String segundoApellido, Double sueldo,
            LocalDate fechaDeNacimiento, Genero genero) {
        super(nombre, primerApellido, segundoApellido, sueldo, fechaDeNacimiento, genero);
    }

    @Override
    public Double sueldoConDescuento(Double sueldo) {
        Double afp = sueldo * 0.0775;
        Double isss = sueldo * 0.075;

        if (sueldo > 472.0 && sueldo < 895.25) {
            sueldo = sueldo - afp - isss - (sueldo * 0.10);
            return sueldo;
        } else if (sueldo >= 895.25 && sueldo <= 2038.10) {
            sueldo = sueldo - afp - isss - (sueldo * 0.20);
            return sueldo;
        } else if (sueldo > 2038.10) {
            sueldo = sueldo - afp - isss - (sueldo * 0.30);
            return sueldo;
        }
        return sueldo - afp - isss;
    }
}