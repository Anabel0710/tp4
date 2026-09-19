import java.util.ArrayList;
import java.util.Calendar;
/**
 * Representa un pedido realizado por un cliente.
 * Almacena la fecha del pedido y una colección de productos.
 * Permite agregar y quitar productos, calcular los totales
 * y mostrar el detalle completo del pedido.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */
public class Pedido
{
    private Calendar fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    
    /**
     * Constructor que crea un pedido a partir de una colección de productos.
     *
     * @param p_fecha fecha en la que se realiza el pedido
     * @param p_cliente cliente que realiza el pedido
     * @param p_productos colección de productos incluidos en el pedido
     */
    public Pedido(Calendar p_fecha,Cliente p_cliente, ArrayList<Producto> p_productos ){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }
    
    /**
     * Constructor que crea un pedido con su primer producto.
     *
     * @param p_fecha fecha en la que se realiza el pedido
     * @param p_cliente cliente que realiza el pedido
     * @param p_producto primer producto que se agrega al pedido
     */
    public Pedido(Calendar p_fecha,Cliente p_cliente, Producto p_producto ){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.agregarProducto(p_producto);
    }
    
    /**Setters*/
    private void setFecha(Calendar p_fecha){this.fecha = p_fecha;}
    private void setCliente(Cliente p_cliente){this.cliente = p_cliente;}
    private void setProductos( ArrayList<Producto> p_productos){this.productos = p_productos;}
    
    public Calendar getFecha(){ return this.fecha;}
    public Cliente getCliente(){ return this.cliente;}
    /**
     * Devuelve la colección de productos del pedido.
     *
     * @return productos incluidos en el pedido
     */
    public ArrayList<Producto> getProductos(){ return this.productos;}
    
     /**
     * Agrega un producto al final de la colección del pedido.
     *
     * @param p_producto producto que se desea agregar
     * @return true si el producto fue agregado correctamente
     */
    
    public boolean agregarProducto(Producto p_producto){
        return this.getProductos().add(p_producto);
    }
    
    /**
     * Quita una unidad de un producto del pedido.
     * No permite que la colección quede vacía.
     *
     * @param p_producto producto que se desea quitar
     * @return true si se eliminó; false en caso contrario
     */
    public boolean quitarProducto(Producto p_producto)
    {
        if (this.getProductos().size() > 1)
        {
            return this.getProductos().remove(p_producto);
        }
        
        return false;
    }
    
    /**
     * Calcula la suma de los precios de contado
     * de todos los productos del pedido.
     *
     * @return importe total del pedido al contado
     */

    public double totalAlContado(){
        double total = 0;
        for(Producto p : this.getProductos()){
            total += p.precioContado();
        }
        return total;
     }
    
    /**
     * Calcula la suma de los precios de lista
     * de todos los productos del pedido.
     *
     * @return importe total financiado del pedido
     */
    public double totalFinanciado(){
        double total = 0;
        for(Producto p : this.getProductos()){
            total += p.precioLista();
        }
        return total;
    }
    
    /**
     * Muestra la fecha, los productos, los precios de lista,
     * los precios de contado y los totales del pedido.
     */
    public void mostrarPedido(){
        int dia = this.getFecha().get(Calendar.DAY_OF_MONTH);
        int mes = this.getFecha().get(Calendar.MONTH) + 1;
        int anio = this.getFecha().get(Calendar.YEAR);
        System.out.println("****** Detalle del pedido ****** Fecha: " + dia + "/" + mes + "/"+ anio);
        System.out.printf("%-20s %15s %17s%n", "Producto", "Precio Lista", "Precio Contado");
        System.out.println("--------------------------------------------------------");
        
        for(Producto producto : this.getProductos()){
            System.out.printf("%-20s %15.2f %17.2f%n", producto.getDescripcion(), producto.precioLista(),producto.precioContado());
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-20s %15.2f %17.2f%n","*** Total ------",this.totalFinanciado(),this.totalAlContado());
    }
}