import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa una persona con DNI, nombre, apellido y fecha
 * de nacimiento.
 * Permite calcular la edad, mostrar sus datos y determinar
 * si está cumpliendo años.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 23/08/2026
 */
public class Persona
{
    private int nroDni;
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;

    /**
     * Construye una persona recibiendo solamente el año de nacimiento.
     * Este constructor se mantiene para que continúen funcionando las clases desarrolladas anteriormente.
     *
     * @param p_dni número de DNI
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_anio año de nacimiento
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }

    /**
     * Construye una persona recibiendo su fecha completa de nacimiento.
     *
     * @param p_dni número de DNI
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_fecha fecha completa de nacimiento
     */
    public Persona(int p_dni, String p_nombre, String p_apellido,Calendar p_fecha) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }

    /** Getters */
    public int getDNI() {return this.nroDni;} //Devuelve el número de DNI.
    public String getNombre() {return this.nombre;} //Devuelve el nombre de la persona.
    public String getApellido() {return this.apellido;} //Devuelve el apellido de la persona.
    public int getAnioNacimiento() {return this.fechaNacimiento.get(Calendar.YEAR);} //Devuelve el año de nacimiento.
    public Calendar getFechaNacimiento() {return this.fechaNacimiento;} //Devuelve la fecha completa de nacimiento.

    /** Setters */
    private void setDNI(int p_dni) {this.nroDni = p_dni;} //Asigna el número de DNI.
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre.
    private void setApellido(String p_apellido) {this.apellido = p_apellido;} //Asigna el apellido.
    private void setFechaNacimiento(Calendar p_fecha) {this.fechaNacimiento = p_fecha;} //Asigna la fecha de nacimiento.

    /**
     * Asigna el año de nacimiento creando un objeto Calendar.
     * Se utiliza el primero de enero porque el constructor anterior
     * solamente proporciona el año.
     *
     * @param p_anio año de nacimiento
     */
    private void setAnioNacimiento(int p_anio) {
        Calendar fecha = new GregorianCalendar(p_anio, 0, 1);
        this.setFechaNacimiento(fecha);
    }

    /**
     * Calcula la edad de la persona considerando solamente
     * la diferencia entre los años.
     *
     * @return edad de la persona
     */
    public int edad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);

        return anioHoy - this.getAnioNacimiento();
    }

    /**
     * Devuelve el nombre y apellido de la persona.
     *
     * @return nombre y apellido separados por una coma
     */
    public String nomYApe()
    {
        return this.getNombre() + " , " + this.getApellido();
    }

    /**
     * Devuelve el apellido y nombre de la persona.
     *
     * @return apellido y nombre separados por una coma
     */
    public String apeYNom()
    {
        return this.getApellido() + " , " + this.getNombre();
    }

    /**
     * Muestra los datos de la persona.
     */
    public void mostrar()
    {
        System.out.println( "Nombre y Apellido: " + this.nomYApe());

        System.out.println( "DNI: " + this.getDNI() + " Edad: " + this.edad() + " años");
    }

    /**
     * Determina si la fecha actual coincide con el día y el
     * mes de nacimiento de la persona.
     *
     * @return true si hoy es su cumpleaños; false en caso contrario
     */
    public boolean esCumpleaños()
    {
        Calendar fechaHoy = new GregorianCalendar();
        
        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mesHoy = fechaHoy.get(Calendar.MONTH);

        int diaNacimiento = this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH);

        int mesNacimiento = this.getFechaNacimiento().get(Calendar.MONTH);

        return diaHoy == diaNacimiento && mesHoy == mesNacimiento;
            
    }
}