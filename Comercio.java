import java.util.HashMap;

/**
 * Representa un comercio que administra una colección
 * de empleados.
 *
 * Cada empleado se almacena en un HashMap utilizando
 * su número de CUIL como clave.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Comercio
{
    private String nombre;
    private HashMap<Long, Empleado> empleados;

    /**
     * Construye un comercio sin empleados.
     *
     * La colección comienza vacía porque la cardinalidad
     * entre Comercio y Empleado es 0..*.
     *
     * @param p_nombre nombre del comercio
     */
    public Comercio(String p_nombre)
    {
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long, Empleado>());
    }

    /**
     * Construye un comercio con una colección de empleados.
     *
     * @param p_nombre nombre del comercio
     * @param p_empleados colección inicial de empleados
     */
    public Comercio( String p_nombre, HashMap<Long, Empleado> p_empleados)
    {
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }

    //Getters
    public String getNombre(){ return this.nombre;}
    public HashMap<Long, Empleado> getEmpleados(){ return this.empleados;}

    // Setters
    private void setNombre(String p_nombre) { this.nombre = p_nombre; }
    private void setEmpleados(HashMap<Long, Empleado> p_empleados) { this.empleados = p_empleados;}

    /**
     * Da de alta un empleado utilizando su CUIL como clave.
     *
     * Si ya existe un empleado con el mismo CUIL,
     * no vuelve a agregarlo.
     *
     * @param p_empleado empleado que será contratado
     */
    public void altaEmpleado(Empleado p_empleado)
    {
        if (!this.esEmpleado(p_empleado.getCuil()))
        {
            this.getEmpleados().put(p_empleado.getCuil(), p_empleado);
        }
        else
        {
            System.out.println("Ya existe un empleado con ese CUIL.");
        }
    }

    /**
     * Da de baja un empleado mediante su CUIL.
     *
     * @param p_cuil CUIL del empleado
     * @return empleado eliminado o null si no existe
     */
    public Empleado bajaEmpleado(long p_cuil)
    {
        return this.getEmpleados().remove(p_cuil);
    }

    /**
     * Devuelve la cantidad de empleados registrados.
     *
     * @return cantidad de empleados
     */
    public int cantidadDeEmpleados()
    {
        return this.getEmpleados().size();
    }

    /**
     * Verifica si un empleado pertenece al comercio.
     *
     * @param p_cuil CUIL que se desea consultar
     * @return true si el CUIL está registrado
     */
    public boolean esEmpleado(long p_cuil)
    {
        return this.getEmpleados().containsKey(p_cuil);
    }

    /**
     * Busca un empleado mediante su CUIL.
     *
     * @param p_cuil CUIL buscado
     * @return empleado encontrado o null
     */
    public Empleado buscarEmpleado(long p_cuil)
    {
        return this.getEmpleados().get(p_cuil);
    }

    /**
     * Muestra el sueldo neto del empleado correspondiente
     * al CUIL recibido.
     *
     * @param p_cuil CUIL del empleado
     */
    public void sueldoNeto(long p_cuil)
    {
        Empleado empleado = this.buscarEmpleado(p_cuil);

        if (empleado != null)
        {
            System.out.printf( "Sueldo neto de %s: $%.2f%n", empleado.apeYNom(), empleado.sueldoNeto());
        }
        else
        {
            System.out.println( "No existe un empleado con ese CUIL.");
        }
    }

    /**
     * Muestra la nómina completa de empleados.
     */
    public void nomina()
    {
        System.out.println();
        System.out.println(  "**** Nómina de empleados de " + this.getNombre() + " ****");

        if (this.getEmpleados().isEmpty())
        {
            System.out.println( "No hay empleados registrados." );
        }
        else
        {
            for ( Empleado empleado : this.getEmpleados().values())
            {
                System.out.printf( "%-15d %-30s $%10.2f%n", empleado.getCuil(), empleado.apeYNom(), 
                                  empleado.sueldoNeto());
            }
        }
    }
}