/**
 * Clase Punto que representa un punto en el plano cartesiano.
 * Permite desplazarlo y mostrar sus coordenadas.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */

public class Punto {
    private double x;
    private double y;

    /** Constructor sin parámetros: punto en el origen */
    public Punto() {
        this.setX(0);
        this.setY(0);
    }

    /** Constructor con parámetros */
    public Punto(double p_x, double p_y) {
        this.setX(p_x);
        this.setY(p_y);
    }

    /** Getters */
    public double getX() { return this.x; }
    public double getY() { return this.y; }

    /** Setters privados */
    private void setX(double p_x) { this.x = p_x; }
    private void setY(double p_y) { this.y = p_y; }
    
    /**DistanciaA*/
    public double distanciaA(Punto p_ptoDistante){
        double dx = p_ptoDistante.getX() -this.getX();
        double dy = p_ptoDistante.getY() - this.getY();
        return Math.sqrt(Math.pow(dx, 2)+ Math.pow(dy, 2));
    }

    /** Desplaza el punto */
    public void desplazar(double p_dx, double p_dy) {
        this.x += p_dx;
        this.y += p_dy;
    }

    /** Devuelve coordenadas en formato (x, y) */
    public String coordenadas() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    /** Muestra las coordenadas del punto */
    public void mostrar() {
        System.out.println("Punto. X: " + this.getX() + ", Y: " + this.getY());
    }
}
