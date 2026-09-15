import java.util.HashMap;

/**
 * Clase que representa un curso y administra
 * una colección de alumnos inscriptos.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 12/09/2026
 */
public class Curso
{
    private String nombre;
    private HashMap<Integer, Alumno> alumnos;

    /**
     * Constructor que crea un curso sin alumnos inscriptos.
     *
     * @param p_nombre nombre del curso
     */
    public Curso(String p_nombre)
    {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap<Integer, Alumno>());
    }

    /**
     * Constructor que crea un curso con una colección de alumnos.
     *
     * @param p_nombre nombre del curso
     * @param p_alumnos colección de alumnos
     */
    public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos)
    {
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    /**
     * Devuelve el nombre del curso.
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Devuelve la colección de alumnos.
     */
    public HashMap<Integer, Alumno> getAlumnos()
    {
        return this.alumnos;
    }

    /**
     * Modifica el nombre del curso.
     */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /**
     * Modifica la colección de alumnos.
     */
    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos)
    {
        this.alumnos = p_alumnos;
    }

    /**
     * Inscribe un alumno utilizando su LU como clave.
     *
     * @param p_alumno alumno que se desea inscribir
     */
    public void inscribirAlumno(Alumno p_alumno)
    {
        this.getAlumnos().put(p_alumno.getLu(),p_alumno);
    }

    /**
     * Quita un alumno mediante su LU.
     *
     * @param p_lu libreta universitaria del alumno
     * @return alumno eliminado o null si no existe
     */
    public Alumno quitarAlumno(int p_lu)
    {
        return this.getAlumnos().remove(p_lu);
    }

    /**
     * Devuelve la cantidad de alumnos inscriptos.
     */
    public int cantidadDeAlumnos()
    {
        return this.getAlumnos().size();
    }

    /**
     * Verifica si una LU está inscripta.
     *
     * @param p_lu libreta universitaria
     * @return true si está inscripta
     */
    public boolean estaInscripto(int p_lu)
    {
        return this.getAlumnos().containsKey(p_lu);
    }

    /**
     * Verifica si un alumno está inscripto.
     *
     * @param p_alumno alumno que se desea consultar
     * @return true si está inscripto
     */
    public boolean estaInscripto(Alumno p_alumno)
    {
        return this.getAlumnos().containsKey(p_alumno.getLu());
    }

    /**
     * Busca un alumno mediante su LU.
     *
     * @param p_lu libreta universitaria
     * @return alumno encontrado o null
     */
    public Alumno buscarAlumno(int p_lu)
    {
        return this.getAlumnos().get(p_lu);
    }

    /**
     * Muestra el promedio de un alumno mediante su LU.
     *
     * @param p_lu libreta universitaria
     */
    public void imprimirPromedioDelAlumno(int p_lu)
    {
        Alumno alumno = this.buscarAlumno(p_lu);

        if (alumno != null)
        {
            System.out.println( "Promedio: " + alumno.promedio());
        }
        else
        {
            System.out.println( "No existe un alumno con LU " + p_lu);
        }
    }

    /**
     * Muestra todos los alumnos inscriptos.
     */
    public void mostrarInscriptos()
    {
        for (Alumno alumno : this.getAlumnos().values())
        {
            System.out.println(alumno.getLu() + " " + alumno.getNombre() + " " + alumno.getApellido());
        }
    }
}