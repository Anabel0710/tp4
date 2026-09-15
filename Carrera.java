import java.util.Scanner;

/**
 * Clase ejecutable para administrar los alumnos de un curso
 * mediante datos ingresados por consola.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 12/09/2026
 */
public class Carrera
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = teclado.nextLine();

        Curso curso = new Curso(nombreCurso);

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        // Crear e inscribir los alumnos
        for (int i = 1; i <= cantidad; i++)
        {
            System.out.println();
            System.out.println("Datos del alumno " + i);

            System.out.print("LU: ");
            int lu = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Apellido: ");
            String apellido = teclado.nextLine();

            System.out.print("Nota 1: ");
            double nota1 = teclado.nextDouble();

            System.out.print("Nota 2: ");
            double nota2 = teclado.nextDouble();
            teclado.nextLine();

            Alumno alumno = new Alumno(lu, nombre, apellido);

            alumno.setNota1(nota1);
            alumno.setNota2(nota2);

            curso.inscribirAlumno(alumno);
        }

        // Mostrar cantidad y lista inicial
        System.out.println();
        System.out.println( "**** Cantidad de inscriptos: " + curso.cantidadDeAlumnos());

        curso.mostrarInscriptos();

        // Dar de baja un alumno
        System.out.println();
        System.out.print("Ingrese la LU del alumno que desea dar de baja: ");

        int luBaja = teclado.nextInt();

        Alumno alumnoEliminado =
            curso.quitarAlumno(luBaja);

        if (alumnoEliminado != null)
        {
            System.out.println("Se dio de baja a " + alumnoEliminado.getNombre() + " " + alumnoEliminado.getApellido());
        }
        else
        {
            System.out.println("No existe un alumno con esa LU.");
        }

        System.out.println();
        System.out.println("¿Está inscripto el alumno con LU " + luBaja + "? --> " + curso.estaInscripto(luBaja));

        // Mostrar lista actualizada
        System.out.println();
        System.out.println("**** Alumnos inscriptos actualmente: " + curso.cantidadDeAlumnos());

        curso.mostrarInscriptos();

        // Buscar un alumno
        System.out.println();
        System.out.print("Ingrese la LU del alumno que desea buscar: ");

        int luBuscar = teclado.nextInt();

        Alumno alumnoBuscado = curso.buscarAlumno(luBuscar);

        if (alumnoBuscado != null)
        {
            alumnoBuscado.mostrar();
        }
        else
        {
            System.out.println(
                "No existe un alumno con esa LU."
            );
        }

        // Mostrar el promedio de un alumno
        System.out.println();
        System.out.print( "Ingrese la LU para consultar su promedio: " );

        int luPromedio = teclado.nextInt();

        curso.imprimirPromedioDelAlumno(luPromedio);

        teclado.close();
    }
}