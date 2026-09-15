import java.util.Calendar;
import java.util.Scanner;

/**
 * Clase ejecutable que permite cargar un pedido por teclado.
 * Crea un cliente, un laboratorio y los productos solicitados.
 * Luego muestra los totales, elimina una unidad y presenta
 * el detalle actualizado del pedido.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class TomaPedido
{
    /**
     * Método principal de la aplicación.
     *
     * @param args argumentos recibidos por línea de comandos
     */
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        Calendar fecha = Calendar.getInstance();

        System.out.println("***** DATOS DEL CLIENTE *****");

        System.out.print("DNI: ");
        int dni = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Apellido: ");
        String apellidoCliente = teclado.nextLine();

        System.out.print("Nombre: ");
        String nombreCliente = teclado.nextLine();

        System.out.print("Saldo: $");
        double saldo = teclado.nextDouble();
        teclado.nextLine();

        Cliente cliente = new Cliente( dni, apellidoCliente, nombreCliente, saldo);

        System.out.println();
        System.out.println("***** DATOS DEL LABORATORIO *****");

        System.out.print("Nombre: ");
        String nombreLaboratorio = teclado.nextLine();

        System.out.print("Domicilio: ");
        String domicilio = teclado.nextLine();

        System.out.print("Teléfono: ");
        String telefono = teclado.nextLine();

        Laboratorio laboratorio = new Laboratorio(nombreLaboratorio, domicilio, telefono);

        int cantidadProductos;

        do
        {
            System.out.print("\nCantidad de productos diferentes: ");

            cantidadProductos = teclado.nextInt();

            if (cantidadProductos < 1)
            {
                System.out.println("El pedido debe contener al menos un producto.");
            }
        }
        while (cantidadProductos < 1);

        Pedido miPedido = null;

        for (int i = 1; i <= cantidadProductos; i++)
        {
            teclado.nextLine();

            System.out.println();
            System.out.println( "***** PRODUCTO " + i + " *****");

            System.out.print("Código: ");
            int codigo = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Rubro: ");
            String rubro = teclado.nextLine();

            System.out.print("Descripción: ");
            String descripcion = teclado.nextLine();

            System.out.print("Costo: $");
            double costo = teclado.nextDouble();

            System.out.print( "Porcentaje del punto de reposición: ");
            double porcentajeReposicion = teclado.nextDouble();

            System.out.print("Existencia mínima: ");
            int existenciaMinima = teclado.nextInt();

            int unidades;

            do
            {
                System.out.print("Unidades solicitadas: ");
                unidades = teclado.nextInt();

                if (unidades < 1)
                {
                    System.out.println( "Debe solicitar al menos una unidad." );
                }
            }
            while (unidades < 1);

            Producto producto = new Producto(codigo, rubro, descripcion, costo, porcentajeReposicion, existenciaMinima, laboratorio);

            /**
             * El primer producto permite crear el pedido,
             * respetando la cardinalidad 1..*.
             */
            if (miPedido == null)
            {
                miPedido = new Pedido( fecha, cliente, producto);

                /**
                 * Una unidad ya fue agregada mediante
                 * el constructor de Pedido.
                 */
                for (int unidad = 1; unidad < unidades; unidad++)
                {
                    miPedido.agregarProducto(producto);
                }
            }
            else
            {
                /**
                 * Cada unidad se agrega como un elemento
                 * independiente del ArrayList.
                 */
                for (int unidad = 0; unidad < unidades; unidad++)
                {
                    miPedido.agregarProducto(producto);
                }
            }
        }

        System.out.println();
        System.out.println("***** TOTALES INICIALES *****");

        System.out.printf("Total financiado: $%.2f%n", miPedido.totalFinanciado());

        System.out.printf("Total al contado: $%.2f%n",miPedido.totalAlContado());

        miPedido.mostrarPedido();

        System.out.println();
        System.out.print("Ingrese el código del producto que desea quitar: ");

        int codigoEliminar = teclado.nextInt();
        Producto productoEliminar = null;

        for (Producto producto : miPedido.getProductos())
        {
            if (producto.getCodigo() == codigoEliminar)
            {
                productoEliminar = producto;
                break;
            }
        }

        if (productoEliminar == null)
        {
            System.out.println("No existe un producto con ese código.");
        }
        else
        {
            boolean eliminado = miPedido.quitarProducto(productoEliminar);

            if (eliminado)
            {
                System.out.println("Se quitó una unidad del producto.");
            }
            else
            {
                System.out.println("No se pudo quitar el producto. " + "El pedido debe conservar al menos una unidad.");
            }
        }

        System.out.println();
        System.out.println("***** PEDIDO ACTUALIZADO *****");

        System.out.printf("Total financiado: $%.2f%n", miPedido.totalFinanciado());

        System.out.printf("Total al contado: $%.2f%n", miPedido.totalAlContado());

        miPedido.mostrarPedido();

        teclado.close();
    }
}