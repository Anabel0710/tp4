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

    /** Constructor completo */
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

    /** Constructor sobrecargado */
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
    public int getCodigo() { 
        return this.codigo; 
    }
    
    public String getRubro() { 
        return this.rubro;
    }
    
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

    /** Ajusta el stock (puede sumar o restar) */
    public void ajuste(int p_cantidad) {
        this.stock += p_cantidad;
    }

    /** Calcula el stock valorizado (stock * costo + 12%) */
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

    /** Ajusta porcentaje de punto de reposición */
    public void ajustarPtoRepo(double p_porce) {
        this.setPorcPtoRepo(p_porce);
    }

    /** Ajusta existencia mínima */
    public void ajustarExistMin(int p_cantidad) {
        this.setExistMinima(p_cantidad);
    }

    /** Muestra datos completos del producto */
    public void mostrar() {
        System.out.println(this.getLaboratorio().mostrar());
        System.out.println("Rubro: " + this.getRubro());
        System.out.println("Descripción: " + this.getDescripcion());
        System.out.println("Precio Costo: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + " - Stock Valorizado: $" + this.stockValorizado());
    }

    /** Muestra datos en una sola línea */
    public String mostrarLinea() {
        return this.getDescripcion() + " " + this.precioLista() + " " + this.precioContado();
    }
}
