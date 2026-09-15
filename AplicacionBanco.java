import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Clase ejecutable que permite administrar un banco mediante
 * un menú de opciones.
 *
 * Permite contratar y despedir empleados, listar sueldos,
 * agregar y quitar cuentas bancarias, realizar operaciones
 * y mostrar el resumen general del banco.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class AplicacionBanco
{
    /**
     * Método principal de la aplicación.
     *
     * @param args argumentos recibidos por línea de comandos
     */
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("***** CREACIÓN DEL BANCO *****");

        System.out.print("Nombre del banco: ");
        String nombreBanco = teclado.nextLine();

        System.out.print("Número de sucursal: ");
        int numeroSucursal = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Localidad: ");
        String nombreLocalidad = teclado.nextLine();

        System.out.print("Provincia: ");
        String provincia = teclado.nextLine();

        Localidad localidad = new Localidad( nombreLocalidad, provincia);

        /**
         * El banco debe crearse con al menos un empleado
         * porque la cardinalidad de empleados es 1..*.
         */
        System.out.println();
        System.out.println("***** PRIMER EMPLEADO *****");

        Empleado primerEmpleado = leerEmpleado(teclado);

        Banco banco = new Banco( nombreBanco, localidad, numeroSucursal, primerEmpleado);

        int opcion;

        do
        {
            mostrarMenu();

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion)
            {
                case 1:
                    contratarEmpleado(teclado, banco);
                    break;

                case 2:
                    despedirEmpleado(teclado, banco);
                    break;

                case 3:
                    banco.mostrar();
                    break;

                case 4:
                    System.out.printf( "Total de sueldos a pagar: $%.2f%n", banco.sueldosAPagar());
                    break;

                case 5:
                    agregarCuenta(teclado, banco);
                    break;

                case 6:
                    quitarCuenta(teclado, banco);
                    break;

                case 7:
                    banco.listarCuentasConSaldoCero();
                    break;

                case 8:
                    mostrarTitulares(banco);
                    break;

                case 9:
                    banco.mostrarResumen();
                    break;

                case 10:
                    depositarEnCuenta(teclado, banco);
                    break;

                case 11:
                    extraerDeCuenta(teclado, banco);
                    break;

                case 0:
                    System.out.println( "Aplicación finalizada." );
                    break;

                default:
                    System.out.println( "La opción ingresada no es válida." );
            }
        }
        while (opcion != 0);

        teclado.close();
    }

    /**
     * Muestra las opciones disponibles en el menú.
     */
    private static void mostrarMenu()
    {
        System.out.println();
        System.out.println("========== MENÚ DEL BANCO ==========");
        System.out.println("1. Contratar empleado");
        System.out.println("2. Despedir empleado");
        System.out.println("3. Listar empleados y sueldos");
        System.out.println("4. Mostrar total de sueldos");
        System.out.println("5. Agregar cuenta bancaria");
        System.out.println("6. Quitar cuenta bancaria");
        System.out.println("7. Listar cuentas con saldo cero");
        System.out.println("8. Mostrar titulares");
        System.out.println("9. Mostrar resumen del banco");
        System.out.println("10. Depositar en una cuenta");
        System.out.println("11. Extraer de una cuenta");
        System.out.println("0. Salir");
        System.out.println("====================================");
    }

    /**
     * Solicita por teclado los datos necesarios para crear
     * un empleado.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @return empleado creado
     */
    private static Empleado leerEmpleado(Scanner teclado)
    {
        System.out.print("CUIL: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Sueldo básico: $");
        double sueldoBasico = teclado.nextDouble();

        System.out.print("Año de ingreso: ");
        int anioIngreso = teclado.nextInt();
        teclado.nextLine();

        return new Empleado( cuil, apellido, nombre, sueldoBasico, anioIngreso );
    }

    /**
     * Solicita los datos de un empleado y lo agrega al banco.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param banco banco que contratará al empleado
     */
    private static void contratarEmpleado(
        Scanner teclado,
        Banco banco)
    {
        System.out.println();
        System.out.println("***** CONTRATAR EMPLEADO *****");

        Empleado empleado = leerEmpleado(teclado);

        if (buscarEmpleado(banco, empleado.getCuil()) != null)
        {
            System.out.println("Ya existe un empleado con ese CUIL.");
        }
        else
        {
            banco.agregarEmpleado(empleado);

            System.out.println("Empleado contratado correctamente.");
        }
    }

    /**
     * Solicita un CUIL y elimina el empleado correspondiente.
     *
     * No se puede eliminar al último empleado porque la
     * cardinalidad entre Banco y Empleado es 1..*.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param banco banco que despedirá al empleado
     */
    private static void despedirEmpleado(Scanner teclado, Banco banco)
    {
        System.out.println();
        System.out.println("***** DESPEDIR EMPLEADO *****");

        System.out.print("CUIL del empleado: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();

        Empleado empleado = buscarEmpleado(banco, cuil);

        if (empleado == null)
        {
            System.out.println("No existe un empleado con ese CUIL.");
        }
        else if (banco.quitarEmpleado(empleado))
        {
            System.out.println("Empleado despedido correctamente.");
        }
    }

    /**
     * Busca un empleado mediante su CUIL.
     *
     * @param banco banco en el que se realiza la búsqueda
     * @param p_cuil CUIL buscado
     * @return empleado encontrado o null
     */
    private static Empleado buscarEmpleado(Banco banco, long p_cuil)
    {
        for (Empleado empleado : banco.getEmpleados())
        {
            if (empleado.getCuil() == p_cuil)
            {
                return empleado;
            }
        }

        return null;
    }

    /**
     * Solicita los datos y agrega una cuenta bancaria.
     *
     * Antes de crear un titular, comprueba si su DNI ya está
     * registrado. Si existe, reutiliza el mismo objeto Persona
     * para evitar titulares repetidos.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param banco banco que administrará la cuenta
     */
    private static void agregarCuenta(Scanner teclado, Banco banco)
    {
        System.out.println();
        System.out.println("***** AGREGAR CUENTA *****");

        System.out.print("Número de cuenta: ");
        int numeroCuenta = teclado.nextInt();

        if (buscarCuenta(banco, numeroCuenta) != null)
        {
            System.out.println("Ya existe una cuenta con ese número.");

            teclado.nextLine();
            return;
        }

        System.out.print("DNI del titular: ");
        int dni = teclado.nextInt();
        teclado.nextLine();

        /**
         * Se busca primero el titular por DNI.
         * Si existe, se reutiliza el mismo objeto Persona.
         */
        Persona titular = buscarTitular(banco, dni);

        if (titular == null)
        {
            System.out.println( "El titular no está registrado. Ingrese sus datos.");

            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Apellido: ");
            String apellido = teclado.nextLine();

            System.out.print("Día de nacimiento: ");
            int dia = teclado.nextInt();

            System.out.print("Mes de nacimiento (1 a 12): ");
            int mes = teclado.nextInt();

            System.out.print("Año de nacimiento: ");
            int anio = teclado.nextInt();

            Calendar fechaNacimiento =new GregorianCalendar(anio, mes - 1, dia);

            titular = new Persona(dni, nombre, apellido, fechaNacimiento);
        }
        else
        {
            System.out.println("Titular encontrado: " + titular.apeYNom());
        }

        System.out.print("Saldo inicial: $");
        double saldoInicial = teclado.nextDouble();
        teclado.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, titular, saldoInicial);

        banco.agregarCuentaBancaria(cuenta);

        System.out.println( "Cuenta agregada correctamente.");
    }

    /**
     * Busca un titular entre las cuentas mediante su DNI.
     *
     * @param banco banco en el que se realiza la búsqueda
     * @param p_dni DNI del titular
     * @return titular encontrado o null
     */
    private static Persona buscarTitular( Banco banco, int p_dni)
    {
        for ( CuentaBancaria cuenta : banco.getCuentasBancarias())
        {
            if (cuenta.getTitular().getDNI() == p_dni)
            {
                return cuenta.getTitular();
            }
        }

        return null;
    }

    /**
     * Solicita un número y elimina la cuenta correspondiente.
     *
     * El banco puede quedar sin cuentas porque la cardinalidad
     * de cuentas bancarias es 0..*.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param banco banco que contiene la cuenta
     */
    private static void quitarCuenta(Scanner teclado, Banco banco)
    {
        System.out.println();
        System.out.println("***** QUITAR CUENTA *****");

        System.out.print("Número de cuenta: ");
        int numeroCuenta = teclado.nextInt();
        teclado.nextLine();

        CuentaBancaria cuenta = buscarCuenta(banco, numeroCuenta);

        if (cuenta == null)
        {
            System.out.println("No existe una cuenta con ese número.");
        }
        else if (banco.quitarCuentaBancaria(cuenta))
        {
            System.out.println( "Cuenta eliminada correctamente.");
        }
    }

    /**
     * Busca una cuenta bancaria mediante su número.
     *
     * @param banco banco en el que se realiza la búsqueda
     * @param p_numeroCuenta número de cuenta buscado
     * @return cuenta encontrada o null
     */
    private static CuentaBancaria buscarCuenta(Banco banco, int p_numeroCuenta)
    {
        for ( CuentaBancaria cuenta : banco.getCuentasBancarias())
        {
            if (cuenta.getNroCuenta() == p_numeroCuenta)
            {
                return cuenta;
            }
        }

        return null;
    }

    /**
     * Muestra los titulares de las cuentas sin repetirlos.
     *
     * @param banco banco cuyos titulares serán mostrados
     */
    private static void mostrarTitulares(Banco banco)
    {
        HashSet<Persona> titulares = banco.listaDeTitulares();

        System.out.println();
        System.out.println("***** LISTADO DE TITULARES *****");

        if (titulares.isEmpty())
        {
            System.out.println("El banco no tiene titulares registrados.");
        }
        else
        {
            for (Persona titular : titulares)
            {
                System.out.println( titular.getDNI() + " - " + titular.apeYNom());
            }
        }
    }

    /**
     * Solicita una cuenta y deposita un importe.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param banco banco que contiene la cuenta
     */
    private static void depositarEnCuenta( Scanner teclado, Banco banco)
    {
        System.out.println();
        System.out.println("***** DEPÓSITO *****");

        System.out.print("Número de cuenta: ");
        int numeroCuenta = teclado.nextInt();

        CuentaBancaria cuenta = buscarCuenta(banco, numeroCuenta);

        if (cuenta == null)
        {
            System.out.println("No existe una cuenta con ese número.");

            teclado.nextLine();
            return;
        }

        System.out.print("Importe a depositar: $");
        double importe = teclado.nextDouble();
        teclado.nextLine();

        if (importe <= 0)
        {
            System.out.println( "El importe debe ser mayor que cero.");
        }
        else
        {
            cuenta.depositar(importe);

            System.out.printf( "Nuevo saldo: $%.2f%n", cuenta.getSaldo());
        }
    }

    /**
     * Solicita una cuenta y extrae un importe.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param banco banco que contiene la cuenta
     */
    private static void extraerDeCuenta( Scanner teclado, Banco banco)
    {
        System.out.println();
        System.out.println("***** EXTRACCIÓN *****");

        System.out.print("Número de cuenta: ");
        int numeroCuenta = teclado.nextInt();

        CuentaBancaria cuenta = buscarCuenta(banco, numeroCuenta);

        if (cuenta == null)
        {
            System.out.println("No existe una cuenta con ese número.");

            teclado.nextLine();
            return;
        }

        System.out.print("Importe a extraer: $");
        double importe = teclado.nextDouble();
        teclado.nextLine();

        if (importe <= 0)
        {
            System.out.println("El importe debe ser mayor que cero.");
        }
        else if (importe > cuenta.getSaldo())
        {
            System.out.println( "No se puede realizar la extracción: " + "saldo insuficiente.");
        }
        else
        {
            cuenta.extraer(importe);

            System.out.printf("Saldo actual: $%.2f%n",cuenta.getSaldo());
        }
    }
}