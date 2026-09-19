/**
 * Clase Producto que representa un producto comercializado por una droguería.
 * Contiene como colaborador un objeto Laboratorio.
 * Permite calcular precios, ajustar stock y mostrar datos.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */
public class Producto {
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    /**
     * Constructor que crea un producto con todos sus datos.
     * El stock inicial del producto se establece en cero.
     *
     * @param p_codigo código identificador del producto
     * @param p_rubro rubro al que pertenece el producto
     * @param p_desc descripción del producto
     * @param p_costo costo del producto
     * @param p_porcPtoRepo porcentaje del punto de reposición
     * @param p_existMinima existencia mínima requerida
     * @param p_lab laboratorio que fabrica el producto
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_lab);
        this.stock = 0; // stock inicial en cero
    }

    /**
     * Constructor sobrecargado que crea un producto con sus datos básicos.
     * El stock, el porcentaje del punto de reposición y la existencia
     * mínima se inicializan en cero.
     *
     * @param p_codigo código identificador del producto
     * @param p_rubro rubro al que pertenece el producto
     * @param p_desc descripción del producto
     * @param p_costo costo del producto
     * @param p_lab laboratorio que fabrica el producto
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setLaboratorio(p_lab);
        this.stock = 0;
        this.porcPtoRepo = 0;
        this.existMinima = 0;
    }

    /** Getters */
    public int getCodigo() { return this.codigo; }
    public String getRubro() { return this.rubro;}
    public String getDescripcion() { return this.descripcion; }
    public double getCosto() { return this.costo; }
    public int getStock() { return this.stock; }
    public double getPorcPtoRepo() { return this.porcPtoRepo; }
    public int getExistMinima() { return this.existMinima; }
    public Laboratorio getLaboratorio() { return this.laboratorio; }

    /** Setters privados */
    private void setCodigo(int p_codigo) { 
        this.codigo = p_codigo; 
    }
    
    private void setRubro(String p_rubro) { 
        this.rubro = p_rubro; 
    }
    
    private void setDescripcion(String p_desc) { 
        this.descripcion = p_desc; 
    }
    
    private void setCosto(double p_costo) { 
        this.costo = p_costo; 
    }
    private void setPorcPtoRepo(double p_porcPtoRepo) { 
        this.porcPtoRepo = p_porcPtoRepo; 
    }
    
    private void setExistMinima(int p_existMinima) { 
        this.existMinima = p_existMinima;
    }
    
    private void setLaboratorio(Laboratorio p_lab) { 
        this.laboratorio = p_lab; 
    }

    /**
     * Modifica el stock del producto.
     * La cantidad puede ser positiva para aumentar el stock
     * o negativa para disminuirlo.
     *
     * @param p_cantidad cantidad que se sumará o restará al stock
     */
    public void ajuste(int p_cantidad) {
        this.stock += p_cantidad;
    }

    /**
     * Calcula el valor total del stock agregando un 12 %.
     *
     * @return valor total del stock disponible
     */
    public double stockValorizado() {
        return (this.getStock() * this.getCosto()) * 1.12;
    }

    /**
    * Calcula el precio de lista agregando un 10% al costo.
    *
    * @return precio de lista del producto
    */
    public double precioLista()
    {
        return this.getCosto() * 1.10;
    }
    /**
    * Devuelve el precio de contado.
    * El precio de contado es igual al costo del producto.
    *
    * @return precio de contado del producto
    */
    public double precioContado()
    {
       return this.getCosto();
    }

    /**
     * Modifica el porcentaje del punto de reposición.
     *
     * @param p_porce nuevo porcentaje del punto de reposición
     */
    public void ajustarPtoRepo(double p_porce) {
        this.setPorcPtoRepo(p_porce);
    }

    /**
     * Modifica la existencia mínima del producto.
     *
     * @param p_cantidad nueva cantidad mínima requerida
     */
    public void ajustarExistMin(int p_cantidad) {
        this.setExistMinima(p_cantidad);
    }

    /**
     * Muestra los datos completos del producto y del laboratorio,
     * incluyendo el rubro, la descripción, el costo, el stock
     * y el stock valorizado.
     */
    public void mostrar() {
        System.out.println(this.getLaboratorio().mostrar());
        System.out.println("Rubro: " + this.getRubro());
        System.out.println("Descripción: " + this.getDescripcion());
        System.out.println("Precio Costo: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + " - Stock Valorizado: $" + this.stockValorizado());
    }

    /**
     * Devuelve en una sola línea la descripción, el precio de lista
     * y el precio de contado del producto.
     *
     * @return cadena con los datos resumidos del producto
     */
    public String mostrarLinea() {
        return this.getDescripcion() + " " + this.precioLista() + " " + this.precioContado();
    }
}
