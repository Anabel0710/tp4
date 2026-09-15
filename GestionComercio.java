import java.util.Scanner;

/**
 * Clase ejecutable que administra los empleados de un
 * comercio mediante un menú.
 *
 * Permite contratar y despedir empleados, buscar por CUIL,
 * consultar el sueldo neto y emitir la nómina.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class GestionComercio
{
    /**
     * Método principal de la aplicación.
     *
     * @param args argumentos recibidos por línea de comandos
     */
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("***** CREACIÓN DEL COMERCIO *****");

        System.out.print("Nombre del comercio: ");
        String nombreComercio = teclado.nextLine();

        Comercio comercio = new Comercio(nombreComercio);

        System.out.print( "Cantidad inicial de empleados: " );

        int cantidadInicial = teclado.nextInt();
        teclado.nextLine();

        for (int i = 1; i <= cantidadInicial; i++)
        {
            System.out.println();
            System.out.println( "***** EMPLEADO " + i + " *****" );

            Empleado empleado = leerEmpleado(teclado);

            comercio.altaEmpleado(empleado);
        }

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
                    contratarEmpleado(teclado, comercio);
                    break;

                case 2:
                    despedirEmpleado(teclado, comercio);
                    break;

                case 3:
                    consultarEmpleado(teclado, comercio);
                    break;

                case 4:
                    buscarYMostrarEmpleado(teclado, comercio);
                    break;

                case 5:
                    consultarSueldo(teclado, comercio);
                    break;

                case 6:
                    System.out.println("Cantidad de empleados: " + comercio.cantidadDeEmpleados());
                    break;

                case 7:
                    comercio.nomina();
                    break;

                case 0:
                    System.out.println("Aplicación finalizada.");
                    break;

                default:
                    System.out.println("La opción ingresada no es válida.");
            }
        }
        while (opcion != 0);

        teclado.close();
    }

    /**
     * Muestra las opciones disponibles.
     */
    private static void mostrarMenu()
    {
        System.out.println();
        System.out.println("======= MENÚ DEL COMERCIO =======");
        System.out.println("1. Contratar empleado");
        System.out.println("2. Despedir empleado");
        System.out.println("3. Consultar si es empleado");
        System.out.println("4. Buscar y mostrar empleado");
        System.out.println("5. Consultar sueldo neto");
        System.out.println("6. Mostrar cantidad de empleados");
        System.out.println("7. Emitir nómina");
        System.out.println("0. Salir");
        System.out.println("=================================");
    }

    /**
     * Solicita los datos necesarios para crear un empleado.
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
     * Solicita los datos y contrata un empleado.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param comercio comercio que contratará al empleado
     */
    private static void contratarEmpleado(Scanner teclado, Comercio comercio)
    {
        System.out.println();
        System.out.println("***** CONTRATAR EMPLEADO *****");

        Empleado empleado = leerEmpleado(teclado);

        if (comercio.esEmpleado(empleado.getCuil()))
        {
            System.out.println("Ya existe un empleado con ese CUIL.");
        }
        else
        {
            comercio.altaEmpleado(empleado);

            System.out.println( "Empleado contratado correctamente.");
        }
    }

    /**
     * Solicita un CUIL y da de baja al empleado.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param comercio comercio que despedirá al empleado
     */
    private static void despedirEmpleado(Scanner teclado, Comercio comercio)
    {
        System.out.print("Ingrese el CUIL del empleado: ");

        long cuil = teclado.nextLong();
        teclado.nextLine();

        Empleado empleadoEliminado = comercio.bajaEmpleado(cuil);

        if (empleadoEliminado != null)
        {
            System.out.println("Se dio de baja a " + empleadoEliminado.apeYNom());
        }
        else
        {
            System.out.println("No existe un empleado con ese CUIL.");
        }
    }

    /**
     * Comprueba si un CUIL pertenece a un empleado
     * registrado en el comercio.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param comercio comercio consultado
     */
    private static void consultarEmpleado(Scanner teclado, Comercio comercio)
    {
        System.out.print("CUIL que desea consultar: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();

        System.out.println("¿Es empleado del comercio? --> " + comercio.esEmpleado(cuil));
    }

    /**
     * Busca un empleado por CUIL y muestra sus datos.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param comercio comercio en el que se realiza la búsqueda
     */
    private static void buscarYMostrarEmpleado(Scanner teclado, Comercio comercio)
    {
        System.out.print("CUIL del empleado: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();

        Empleado empleado = comercio.buscarEmpleado(cuil);

        if (empleado != null)
        {
            empleado.mostrar();
        }
        else
        {
            System.out.println("No existe un empleado con ese CUIL.");
        }
    }

    /**
     * Solicita un CUIL y muestra el sueldo neto
     * correspondiente.
     *
     * @param teclado objeto utilizado para leer desde la consola
     * @param comercio comercio que contiene al empleado
     */
    private static void consultarSueldo( Scanner teclado, Comercio comercio)
    {
        System.out.print("CUIL del empleado: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();

        comercio.sueldoNeto(cuil);
    }
}