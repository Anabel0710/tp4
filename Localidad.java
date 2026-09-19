/**
 * Representa una localidad perteneciente a una provincia.
 * Permite obtener sus datos en una cadena de texto.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Localidad
{
    private String nombre;
    private String provincia;

    /**
     * Construye una localidad con su nombre y provincia.
     *
     * @param p_nombre nombre de la localidad
     * @param p_provincia nombre de la provincia
     */
    public Localidad(String p_nombre, String p_provincia)
    {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }

    /** Getters */
    public String getNombre() {return this.nombre;} //Devuelve el nombre de la localidad.
    public String getProvincia() {return this.provincia;} //Devuelve el nombre de la provincia.

    /** Setters */
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre de la localidad.
    private void setProvincia(String p_provincia) {this.provincia = p_provincia;} //Asigna la provincia.

    /**
     * Devuelve el nombre de la localidad y su provincia.
     *
     * @return datos de la localidad y de la provincia 
     */
    public String mostrar()
    {
        return "Localidad: " + this.getNombre() + "\tProvincia: " + this.getProvincia();
    }
}