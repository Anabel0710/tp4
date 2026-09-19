import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa a un empleado de una empresa.
 * Permite calcular su antigüedad, adicional, descuento,
 * sueldo neto y determinar si cumple un nuevo aniversario
 * dentro de la empresa.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 23/08/2026
 */
public class Empleado
{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;

    /**
     * Construye un empleado recibiendo solamente el año de ingreso.
     * Este constructor conserva el protocolo de la clase definida
     * anteriormente en el TP 2.
     *
     * @param p_cuil número de CUIL del empleado
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe sueldo básico
     * @param p_anio año de ingreso a la empresa
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe,int p_anio){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        /**Se establece el 1 de enero del año recibido */
        //this.fechaIngreso = new GregorianCalendar (p_anio, Calendar.JANUARY,1);
        this.setAnioIngreso(p_anio);
    }

    /**
     * Construye un empleado recibiendo la fecha completa
     * de ingreso.
     *
     * @param p_cuil número de CUIL del empleado
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe sueldo básico
     * @param p_fecha fecha completa de ingreso
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
    }

    /** Getters */
    public long getCuil() {return this.cuil;} //Devuelve el CUIL del empleado.
    public String getApellido() {return this.apellido;} //Devuelve el apellido del empleado.
    public String getNombre() {return this.nombre;} //Devuelve el nombre del empleado.
    public double getSueldoBasico() {return this.sueldoBasico;} //Devuelve el sueldo básico.
    public int getAnioIngreso() {return this.fechaIngreso.get(Calendar.YEAR);} //Devuelve el año de ingreso.
    public Calendar getFechaIngreso() {return this.fechaIngreso;} //Devuelve la fecha completa de ingreso.

    /** Setters */
    private void setCuil(long p_cuil) {this.cuil = p_cuil;} //Asigna el CUIL del empleado.
    private void setApellido(String p_apellido) {this.apellido = p_apellido;} //Asigna el apellido del empleado.
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre del empleado.
    private void setSueldoBasico(double p_importe) {this.sueldoBasico = p_importe;} //Asigna el sueldo básico.
    private void setFechaIngreso(Calendar p_fecha) {this.fechaIngreso = p_fecha;} //Asigna la fecha completa de ingreso.

    /**
     * Asigna el año de ingreso creando un objeto Calendar.
     * Se utiliza el primero de enero porque el constructor
     * anterior solamente proporciona el año.
     *
     * @param p_anio año de ingreso a la empresa
     */
    private void setAnioIngreso(int p_anio)
    {
        Calendar fecha = new GregorianCalendar(p_anio, 0, 1);
        this.setFechaIngreso(fecha);
    }

    /**
     * Calcula la antigüedad del empleado considerando solamente
     * la diferencia entre el año actual y el año de ingreso.
     *
     * @return antigüedad del empleado
     */
    public int antiguedad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);

        return anioHoy - this.getAnioIngreso();
    }

    /**
     * Calcula el descuento correspondiente al 2% del sueldo
     * básico más $1500 de seguro de vida.
     *
     * @return descuento aplicado al empleado
     */
    private double descuento()
    {
        return this.getSueldoBasico() * 0.02 + 1500.0;
    }

    /**
     * Calcula el adicional según la antigüedad del empleado.
     *
     * Menos de 2 años: 2%.
     * Desde 2 y menos de 10 años: 4%.
     * Desde 10 años: 6%.
     *
     * @return adicional correspondiente por antigüedad
     */
    private double adicional()
    {
        double adicional = 0.0;

        if (this.antiguedad() < 2)
        {
            adicional = this.getSueldoBasico() * 0.02;
        }
        else
        {
            if (this.antiguedad() < 10)
            {
                adicional = this.getSueldoBasico() * 0.04;
            }
            else
            {
                adicional = this.getSueldoBasico() * 0.06;
            }
        }

        return adicional;
    }

    /**
     * Calcula el sueldo neto sumando el adicional al sueldo
     * básico y restando el descuento.
     *
     * @return sueldo neto del empleado
     */
    public double sueldoNeto()
    {
        return this.getSueldoBasico() + this.adicional() - this.descuento();
    }

    /**
     * Devuelve el nombre y apellido del empleado.
     *
     * @return nombre y apellido
     */
    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * Devuelve el apellido y nombre del empleado.
     *
     * @return apellido y nombre
     */
    public String apeYNom()
    {
        return this.getApellido() + ", " + this.getNombre();
    }

    /**
     * Muestra los datos completos del empleado.
     */
    public void mostrar()
    {
        System.out.println( "Nombre y Apellido: " + this.nomYApe());

        System.out.println( "CUIL: " + this.getCuil() + " Antigüedad: " + this.antiguedad() + " años de servicio");

        System.out.println( "Sueldo Neto: $ " + this.sueldoNeto());
    }

    /**
     * Devuelve los datos del empleado en una sola línea.
     *
     * @return CUIL, apellido, nombre y sueldo neto
     */
    public String mostrarLinea()
    {
        return this.getCuil() + "\t" + this.apeYNom() + "\t$ " + this.sueldoNeto();
    }

    /**
     * Determina si el día y el mes actuales coinciden con
     * el día y el mes de ingreso del empleado.
     *
     * @return true si hoy es su aniversario; false en caso contrario
     */
    public boolean esAniversario()  
    {
        Calendar fechaHoy = new GregorianCalendar();

        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mesHoy = fechaHoy.get(Calendar.MONTH);

        int diaIngreso = this.getFechaIngreso().get(Calendar.DAY_OF_MONTH);

        int mesIngreso = this.getFechaIngreso().get(Calendar.MONTH);

        return diaHoy == diaIngreso && mesHoy == mesIngreso;
    }
}