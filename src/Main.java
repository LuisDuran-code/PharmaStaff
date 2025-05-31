import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Gerente("Juan", "Perez", "Lopez", 5000.0, LocalDate.of(1980, 5, 10), Empleado.Genero.Masculino));
        empleados.add(new Gerente("Maria", "Gonzalez", "Ruiz", 5000.0, LocalDate.of(1975, 8, 22), Empleado.Genero.Femenino));
        
        empleados.add(new JefeArea("Luis", "Ramirez", "Sanchez", 1500.0, LocalDate.of(1985, 7, 20), Empleado.Genero.Masculino));
        empleados.add(new JefeArea("Ana", "Castro", "Mendez", 1500.0, LocalDate.of(1982, 2, 14), Empleado.Genero.Femenino));
        empleados.add(new JefeArea("Carlos", "Vega", "Morales", 1500.0, LocalDate.of(1988, 11, 30), Empleado.Genero.Masculino));
        
        empleados.add(new Supervisor("Pedro", "Lopez", "Diaz", 750.0, LocalDate.of(1992, 1, 25), Empleado.Genero.Masculino));
        empleados.add(new Supervisor("Lucia", "Martinez", "Cruz", 750.0, LocalDate.of(1993, 4, 12), Empleado.Genero.Femenino));
        empleados.add(new Supervisor("Miguel", "Santos", "Herrera", 750.0, LocalDate.of(1991, 6, 18), Empleado.Genero.Masculino));
        empleados.add(new Supervisor("Sofia", "Reyes", "Flores", 750.0, LocalDate.of(1990, 9, 5), Empleado.Genero.Femenino));
        empleados.add(new Supervisor("Diego", "Jimenez", "Pineda", 750.0, LocalDate.of(1989, 12, 3), Empleado.Genero.Masculino));
        
        empleados.add(new Tecnico("Andrea", "Torres", "Campos", 350.0, LocalDate.of(1995, 3, 10), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Jorge", "Navarro", "Aguilar", 350.0, LocalDate.of(1994, 7, 21), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Paola", "Molina", "Vargas", 350.0, LocalDate.of(1993, 8, 15), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Ricardo", "Ortiz", "Salazar", 350.0, LocalDate.of(1992, 10, 5), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Valeria", "Paz", "Mendez", 350.0, LocalDate.of(1991, 12, 12), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Sergio", "Cruz", "Rivas", 350.0, LocalDate.of(1990, 2, 28), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Camila", "Herrera", "Gomez", 350.0, LocalDate.of(1989, 4, 17), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Oscar", "Flores", "Castro", 350.0, LocalDate.of(1988, 6, 23), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Gabriela", "Morales", "Vega", 350.0, LocalDate.of(1987, 8, 30), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Kevin", "Sanchez", "Navarro", 350.0, LocalDate.of(1986, 11, 11), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Daniela", "Aguilar", "Torres", 350.0, LocalDate.of(1985, 1, 19), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Mauricio", "Campos", "Ortiz", 350.0, LocalDate.of(1984, 3, 27), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Fernanda", "Salazar", "Paz", 350.0, LocalDate.of(1983, 5, 6), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Roberto", "Mendez", "Cruz", 350.0, LocalDate.of(1982, 7, 14), Empleado.Genero.Masculino));
        empleados.add(new Tecnico("Patricia", "Rivas", "Herrera", 350.0, LocalDate.of(1981, 9, 22), Empleado.Genero.Femenino));
        empleados.add(new Tecnico("Alejandro", "Gomez", "Flores", 350.0, LocalDate.of(1980, 11, 30), Empleado.Genero.Masculino));

        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú de Empleados ---");
            System.out.println("1. Ordenar empleados por primer apellido");
            System.out.println("2. Ordenar empleados por sueldo neto");
            System.out.println("3. Mostrar cantidad de empleados por rol");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    empleados.sort(Comparator.comparing(Empleado::getPrimerApellido));
                    empleados.forEach(e -> System.out.println(e.getNombre() + " " + e.getPrimerApellido() + " " + e.getSegundoApellido()));
                    break;
                case 2:
                    empleados.sort(Comparator.comparing(e -> e.sueldoConDescuento(e.getSueldo())));
                    empleados.forEach(e -> System.out.println(e.getNombre() + " " + e.getPrimerApellido() + " " + e.getSegundoApellido() + " - $" + e.sueldoConDescuento(e.getSueldo())));
                    break;
                case 3:
                    Map<String, Integer> conteo = new HashMap<>();
                    for (Empleado e : empleados) {
                        String rol = e.getClass().getSimpleName();
                        conteo.put(rol, conteo.getOrDefault(rol, 0) + 1);
                    }
                    conteo.forEach((rol, cantidad) -> System.out.println(rol + ": " + cantidad));
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}