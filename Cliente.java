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

    /** Constructor de Cliente */
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

    /** Agrega saldo al cliente */
    public double agregaSaldo(double p_importe) {
        this.saldo += p_importe;
        return this.saldo;
    }

    /** Reemplaza el saldo actual */
    public double nuevoSaldo(double p_importe) {
        this.saldo = p_importe;
        return this.saldo;
    }

    /** Devuelve nombre y apellido */
    public String nomYApe() { 
        return this.getNombre() + " " + this.getApellido(); 
    }

    /** Devuelve apellido y nombre */
    public String apeYNom() { 
        return this.getApellido() + ", " + this.getNombre(); 
    }

    /** Muestra los datos del cliente */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe() + " (" + this.getDNI() + ")");
        System.out.println("Saldo: $" + this.getSaldo());
    }
}
