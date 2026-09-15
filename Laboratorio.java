/**
 * Clase Laboratorio que representa un laboratorio farmacéutico.
 * Permite mostrar datos y modificar reglas de negocio como compra mínima y día de entrega.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version (a version number or a date)
 */
public class Laboratorio
{
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima; 
    private int diaEntrega;
    
    /** Constructor completo */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, int p_diaEnt){
        this.setNombre (p_nombre);
        this.setDomicilio (p_domicilio);
        this.setTelefono (p_telefono);
        this.setCompraMinima (p_compraMin);
        this.setDiaEntrega (p_diaEnt);
    }
    
    /**Constructor sobrecargado */
    
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono){
        this.setNombre (p_nombre);
        this.setDomicilio (p_domicilio);
        this.setTelefono (p_telefono);
        this.setCompraMinima (0);
        this.setDiaEntrega (1);
    }
    
     /** Setters privados */
    
    private void setNombre(String p_nombre) { 
        this.nombre = p_nombre; 
    }
    
    private void setDomicilio (String p_domicilio) {
        this.domicilio = p_domicilio; 
    }
    
    private void setTelefono(String p_telefono) {
        this.telefono = p_telefono; 
    }
    
    private void setCompraMinima (int p_compraMin) {
        this.compraMinima = p_compraMin;
    }
    
    private void setDiaEntrega  (int p_diaEnt) {
        this.diaEntrega = p_diaEnt;
    }

    /** Getters */
    
    public String getNombre() {
        return this.nombre; 
    }
    
    public String getDomicilio() {
        return this.domicilio; 
    }
    
    public String getTelefono() {
        return this.telefono; 
    }
    
    public int getCompraMinima() 
    {return this.compraMinima; 
    } 
    
    public int getDiaEntrega() {
        return this.diaEntrega;
    }
    
    /** Métodos de negocio */
    public void nuevaCompraMinima (int p_compraMin) { 
        this.setCompraMinima (p_compraMin); 
    }
    
    public void nuevoDiaEntrega (int p_diaEnt ) {
        this.setDiaEntrega(p_diaEnt); 
    }
    
    /**
     * Devuelve los datos del laboratorio.
     *
     * @return nombre, domicilio y teléfono del laboratorio
    */
    public String mostrar()
    {
        return "Laboratorio: " + this.getNombre() +
           " - Domicilio: " + this.getDomicilio() +
           " - Teléfono: " + this.getTelefono();
    }
}