import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa una entidad bancaria que posee empleados
 * y cuentas bancarias.
 *
 * Permite administrar empleados, cuentas y titulares,
 * además de emitir una nómina y un resumen de cuentas.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 13/09/2026
 */
public class Banco
{
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;
    private ArrayList<CuentaBancaria> cuentasBancarias;

    /**
     * Construye un banco con su primer empleado
     * y sin cuentas bancarias.
     *
     * @param p_nombre nombre del banco
     * @param p_localidad localidad del banco
     * @param p_nroSucursal número de sucursal
     * @param p_empleado primer empleado
     */
    public Banco( String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);

        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleado(p_empleado);

        /**
         * El banco puede crearse sin cuentas porque
         * su cardinalidad es 0..*.
         */
        this.setCuentasBancarias( new ArrayList<CuentaBancaria>());
    }

    /**
     * Construye un banco recibiendo una colección de empleados
     * y sin cuentas bancarias.
     *
     * @param p_nombre nombre del banco
     * @param p_localidad localidad del banco
     * @param p_nroSucursal número de sucursal
     * @param p_empleados colección de empleados
     */
    public Banco( String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);

        this.setCuentasBancarias(new ArrayList<CuentaBancaria>());
    }

    /**
     * Construye un banco recibiendo sus empleados
     * y sus cuentas bancarias.
     *
     * @param p_nombre nombre del banco
     * @param p_localidad localidad del banco
     * @param p_nroSucursal número de sucursal
     * @param p_empleados colección de empleados
     * @param p_cuentas colección de cuentas bancarias
     */
    public Banco(String p_nombre, Localidad p_localidad,int p_nroSucursal, 
                 ArrayList<Empleado> p_empleados, ArrayList<CuentaBancaria> p_cuentas)
    {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuentas);
    }

    //setters
    private void setNombre(String p_nombre) {this.nombre = p_nombre;}
    private void setNroSucursal(int p_nroSucursal){ this.nroSucursal = p_nroSucursal;}
    private void setLocalidad(Localidad p_localidad) { this.localidad = p_localidad;}
    private void setEmpleados(ArrayList<Empleado> p_empleados) { this.empleados = p_empleados;}

    /** Asigna la colección de cuentas bancarias. */
    private void setCuentasBancarias(ArrayList<CuentaBancaria> p_cuentas)
    {
        this.cuentasBancarias = p_cuentas;
    }

    //getters
    public String getNombre(){ return this.nombre;}
    public int getNroSucursal(){ return this.nroSucursal;}
    public Localidad getLocalidad(){return this.localidad;}

    /** Devuelve la colección de empleados. */
    public ArrayList<Empleado> getEmpleados()
    {
        return this.empleados;
    }

    /** Devuelve la colección de cuentas bancarias. */
    public ArrayList<CuentaBancaria> getCuentasBancarias()
    {
        return this.cuentasBancarias;
    }

    /**
     * Contrata un empleado.
     *
     * @param p_empleado empleado que será contratado
     * @return true si fue agregado
     */
    public boolean agregarEmpleado(Empleado p_empleado)
    {
        return this.getEmpleados().add(p_empleado);
    }

    /**
     * Despide un empleado sin permitir que el banco
     * quede sin empleados.
     *
     * @param p_empleado empleado que será despedido
     * @return true si fue eliminado
     */
    public boolean quitarEmpleado(Empleado p_empleado)
    {
        if (this.getEmpleados().size() > 1)
        {
            return this.getEmpleados().remove(p_empleado);
        }

        System.out.println("No se puede despedir al único empleado del banco.");

        return false;
    }

    /**
     * Calcula el total de sueldos netos.
     *
     * @return total que debe pagar el banco
     */
    public double sueldosAPagar()
    {
        double total = 0;

        for (Empleado empleado : this.getEmpleados())
        {
            total += empleado.sueldoNeto();
        }

        return total;
    }

    /**
     * Lista los empleados con sus sueldos netos.
     */
    public void listarSueldos()
    {
        for (Empleado empleado : this.getEmpleados())
        {
            System.out.printf("%-15d %-30s $%10.2f%n",empleado.getCuil(), empleado.apeYNom(), empleado.sueldoNeto());
        }

        System.out.printf( "%-46s $%10.2f%n", "Total a pagar", this.sueldosAPagar());
    }

    /**
     * Muestra los datos del banco y los sueldos.
     */
    public void mostrar()
    {
        System.out.println(
            "Banco: " + this.getNombre()
            + " - Sucursal: " + this.getNroSucursal()
        );

        System.out.println(
            "Localidad: " + this.getLocalidad().getNombre()
            + "    Provincia: "
            + this.getLocalidad().getProvincia()
        );

        System.out.println();

        this.listarSueldos();
    }

    /**
     * Agrega una cuenta bancaria a la colección.
     *
     * @param p_cuenta cuenta que se desea agregar
     * @return true si fue agregada
     */
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta)
    {
        return this.getCuentasBancarias().add(p_cuenta);
    }

    /**
     * Quita una cuenta bancaria de la colección.
     *
     * El banco puede quedar sin cuentas porque la
     * cardinalidad de la colección es 0..*.
     *
     * @param p_cuenta cuenta que se desea quitar
     * @return true si fue eliminada
     */
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta)
    {
        return this.getCuentasBancarias().remove(p_cuenta);
    }

    /**
     * Cuenta las cuentas bancarias que tienen saldo
     * mayor que cero.
     *
     * @return cantidad de cuentas activas
     */
    private int cuentasSaldoActivo()
    {
        int cantidad = 0;

        for (CuentaBancaria cuenta : this.getCuentasBancarias())
        {
            if (cuenta.getSaldo() > 0)
            {
                cantidad++;
            }
        }

        return cantidad;
    }

    /**
     * Cuenta las cuentas cuyo saldo es exactamente cero.
     *
     * @return cantidad de cuentas sin saldo
     */
    private int cantidadCuentasSaldoCero()
    {
        int cantidad = 0;

        for ( CuentaBancaria cuenta : this.getCuentasBancarias())
        {
            if (cuenta.getSaldo() == 0)
            {
                cantidad++;
            }
        }

        return cantidad;
    }

    /**
      * Muestra las cuentas bancarias cuyo saldo es igual a cero.
      *
      * En este método cada elemento se recupera como Object para practicar
      * el funcionamiento de las colecciones no genéricas. Por este motivo,
      * antes de utilizar los métodos propios de CuentaBancaria, se realiza
      * una conversión explícita de tipo (casting).
      *
      * Si la colección contiene un objeto que no pertenece a la clase
      * CuentaBancaria, el casting producirá una ClassCastException.
     */
    public void listarCuentasConSaldoCero()
    {
        System.out.printf( "%-20s %-30s%n", "Cuenta",  "Apellido y Nombre");

        System.out.println( "---------------------------------------------------" );
        
        // Cada elemento se recupera como Object.
        for ( Object cuenta : this.getCuentasBancarias())
        {
            // Se convierte el Object en CuentaBancaria para poder utilizar sus métodos específicos.
            CuentaBancaria cuentaCasteada = (CuentaBancaria) cuenta;
            // Se muestran solamente las cuentas cuyo saldo es cero.
            if (cuentaCasteada.getSaldo() == 0)
            {
                System.out.printf("%-20d %-30s%n", cuentaCasteada.getNroCuenta(), cuentaCasteada.getTitular().apeYNom());
            }
        }
    }

    /**
     * Obtiene una colección sin titulares repetidos.
     *
     * HashSet impide que un mismo objeto Persona
     * sea agregado más de una vez.
     *
     * @return conjunto de titulares
     */
    public HashSet<Persona> listaDeTitulares(){
        HashSet<Persona> titulares = new HashSet<Persona>();

        for (CuentaBancaria cuenta : this.getCuentasBancarias())
        {
            titulares.add(cuenta.getTitular());
        }

        return titulares;
    }

    /**
     * Muestra los titulares de las cuentas sin repetirlos.
     */
    private void mostrarTitulares()
    {
        System.out.print("Listado de Clientes: ");

        boolean primero = true;

        for (Persona persona : this.listaDeTitulares())
        {
            if (!primero)
            {
                System.out.print("; ");
            }

            System.out.print(persona.apeYNom());
            primero = false;
        }

        System.out.println();
    }

    /**
     * Emite el resumen de cuentas bancarias.
     */
    public void mostrarResumen()
    {
        System.out.println("Banco: " + this.getNombre() + " - Sucursal: " + this.getNroSucursal());

        System.out.println("Localidad: " + this.getLocalidad().getNombre()+ "    Provincia: " 
            + this.getLocalidad().getProvincia());

        System.out.println( "************************************************************" );

        System.out.println( "RESUMEN DE CUENTAS BANCARIAS");

        System.out.println("************************************************************");

        System.out.println("Número total de Cuentas Bancarias: " + this.getCuentasBancarias().size());

        System.out.println("Cuentas Activas: " + this.cuentasSaldoActivo());

        System.out.println("Cuentas Saldo Cero: " + this.cantidadCuentasSaldoCero());

        System.out.println("------------------------------------------------------------");

        System.out.println("Cuentas sin saldo:");

        this.listarCuentasConSaldoCero();

        System.out.println("------------------------------------------------------------");

        this.mostrarTitulares();

        System.out.println("------------------------------------------------------------");
    }
}