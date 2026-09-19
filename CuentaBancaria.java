/**
 * Representa una cuenta bancaria perteneciente a una persona.
 * Permite depositar y extraer dinero, consultar el saldo y mostrar
 * la información de la cuenta y de su titular.
 *
 * La clase CuentaBancaria conoce a un objeto Persona mediante
 * una variable de instancia llamada titular.
 * 
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class CuentaBancaria
{
   private int nroCuenta;
   private double saldo;
   // Objeto colaborador: titular de la cuenta bancaria
   private Persona titular;
   
     /**
     * Construye una cuenta bancaria sin saldo inicial.
     * El saldo de la cuenta se inicializa en cero.
     *
     * @param p_nroCuenta número identificador de la cuenta
     * @param p_titular persona titular de la cuenta
     */
   
   public CuentaBancaria(int p_nroCuenta, Persona p_titular){
       this.setNroCuenta(p_nroCuenta);
       this.setTitular(p_titular);
       this.setSaldo(0.0);
    }
    
    /**
     * Construye una cuenta bancaria con un saldo inicial.
     *
     * @param p_nroCuenta número identificador de la cuenta
     * @param p_titular persona titular de la cuenta
     * @param p_saldo saldo inicial de la cuenta
     */
   public CuentaBancaria(int p_nroCuenta , Persona p_titular, double p_saldo){
       this.setNroCuenta(p_nroCuenta);
       this.setTitular(p_titular);
       this.setSaldo(p_saldo);
    }
    
    /**Setters */
    private void setNroCuenta(int p_nroCuenta) { this.nroCuenta = p_nroCuenta;} //Asigna el numero de cuenta 
    private void setTitular(Persona p_titular) {this.titular = p_titular;} //Asigna el titular de la cuenta
    private void setSaldo (double p_saldo) {this.saldo = p_saldo;} //Asigna el saldo de la cuenta.
    
    /**Getters*/
    
    public int getNroCuenta() {return this.nroCuenta;} //Devuelve el número de cuenta.
    public Persona getTitular() {return this.titular;} // Devuelve el titular de la cuenta.
    public double getSaldo() {return this.saldo;} //Devuelve el saldo actual de la cuenta
    
    /**
     * Incrementa el saldo actual con el importe recibido.
     *
     * @param p_importe importe que se depositará
     * @return saldo resultante después del depósito
     */
    public double depositar(double p_importe){
        if(p_importe> 0 ){
            this.setSaldo(this.getSaldo() + p_importe);
        } 
        else {
            return 0;
        } 
        return this.getSaldo();
    }
    
   /** Extrae dinero cuando el importe es positivo y existe 
     * saldo suficiente. 
     * 
     * @param p_importe importe que se desea extraer 
     * @return saldo resultante
     */
   public double extraer(double p_importe) { 
       if (p_importe <= 0)
        {
            System.out.println("El importe debe ser mayor que cero.");
        }
        else if (p_importe <= this.getSaldo())
        {
            this.setSaldo(this.getSaldo() - p_importe);
        }
        else
        {
            System.out.println("No se puede realizar la extracción: " + "saldo insuficiente.");
        }
        
        return this.getSaldo();
    }
        
    /**
     * Muestra los datos de la cuenta bancaria y de su titular.
     */
        public void mostrar(){
        System.out.println("- Cuenta Bancaria -");
        System.out.println(
            "Titular: " + this.getTitular().nomYApe()
            + " (" + this.getTitular().edad() + " años)"); 
        System.out.println("Saldo: " + this.getSaldo());
    }
    
     /**
     * Devuelve una representación textual de la cuenta bancaria.
     * Los datos se muestran separados mediante tabulaciones.
     *
     * @return cadena con el número de cuenta, el nombre completo
     *         del titular y el saldo
     */
      @Override
    public String toString(){
        return this.getNroCuenta() + "\t" + this.getTitular().nomYApe() + "\t" + this.getSaldo();
    }
}