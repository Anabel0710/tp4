import java.util.ArrayList;
import java.util.Calendar;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    private Calendar fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    
    /**Constructor que recibe una coleccion de productos*/
    public Pedido(Calendar p_fecha,Cliente p_cliente, ArrayList<Producto> p_productos ){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }
    
    /**Constructor que recibe el primer producto*/
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
    public ArrayList<Producto> getProductos(){ return this.productos;}
    
    /**Agregar producto al final del pedido*/
    
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
    
    
    
    /**Suma los precios de contado*/
    public double totalAlContado(){
        double total = 0;
        for(Producto p : this.getProductos()){
            total += p.precioContado();
        }
        return total;
     }
    
    /**Suma los precios de lista */
    public double totalFinanciado(){
        double total = 0;
        for(Producto p : this.getProductos()){
            total += p.precioLista();
        }
        return total;
    }
    
    /**Muestra los detalles del pedido */
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