/**
 * Clase Cliente que representa un cliente con saldo.
 * Permite agregar o reemplazar saldo y mostrar datos.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */

public class Cliente {
    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;

     /**
     * Constructor que crea un cliente con todos sus datos.
     *
     * @param p_dni número de DNI del cliente
     * @param p_apellido apellido del cliente
     * @param p_nombre nombre del cliente
     * @param p_importe saldo inicial del cliente
     */
    public Cliente(int p_dni, String p_apellido, String p_nombre, double p_importe) {
        this.setDNI(p_dni);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSaldo(p_importe);
    }

    /** Getters */
    public int getDNI() { return this.nroDNI; }
    public String getApellido() { return this.apellido; }
    public String getNombre() { return this.nombre; }
    public double getSaldo() { return this.saldo; }

    /** Setters privados */
    private void setDNI(int p_dni) { this.nroDNI = p_dni; }
    private void setApellido(String p_apellido) { this.apellido = p_apellido; }
    private void setNombre(String p_nombre) { this.nombre = p_nombre; }
    private void setSaldo(double p_importe) { this.saldo = p_importe; }

    /**
     * Agrega un importe al saldo actual del cliente.
     *
     * @param p_importe importe que se agregará al saldo
     * @return nuevo saldo del cliente
     */
    public double agregaSaldo(double p_importe) {
        this.saldo += p_importe;
        return this.saldo;
    }

    /**
     * Reemplaza el saldo actual del cliente por un nuevo importe.
     *
     * @param p_importe nuevo saldo del cliente
     * @return saldo actualizado
     */
    public double nuevoSaldo(double p_importe) {
        this.saldo = p_importe;
        return this.saldo;
    }

     /**
     * Devuelve el nombre y el apellido del cliente.
     *
     * @return nombre y apellido del cliente
     */
    public String nomYApe() { 
        return this.getNombre() + " " + this.getApellido(); 
    }

    /**
     * Devuelve el apellido y el nombre del cliente.
     *
     * @return apellido y nombre del cliente
     */
    public String apeYNom() { 
        return this.getApellido() + ", " + this.getNombre(); 
    }

    /**
     * Muestra el nombre, el apellido, el DNI y el saldo del cliente.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe() + " (" + this.getDNI() + ")");
        System.out.println("Saldo: $" + this.getSaldo());
    }
}
