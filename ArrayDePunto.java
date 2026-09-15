import java.util.Scanner;

/**
 * Write a description of class ArrayDePunto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayDePunto
{
     public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        Punto[] puntos = new Punto[6];
        double x;
        double y;
        
        /**Ingreso y creacion de los puntos*/
        for(int i= 0; i<=5; i++ ){
            System.out.println("Ingrese los datos del punto: " + (i + 1));
            
            System.out.println("Coordenadas de X: ");
            x = teclado.nextDouble();
            
            System.out.println("Coordenadas de Y: ");
            y = teclado.nextDouble();
            
            puntos[i] = new Punto(x, y);
        }
        
        System.out.println("===== Coordenadas de todos los puntos =====");

        /**Mostrar las coordenadas de todos los puntos*/
        for(int i= 0; i<=5; i++ ){
            System.out.println("Punto " + (i + 1) + " : " );
    
            System.out.println(puntos[i].coordenadas());
        }
        
        
        /**Imprimir en pantalla la distancia cada 2 elemento */
        System.out.println("===== Distancia entre dos puntos consecutivos =====");

        for(int i= 0; i < puntos.length -1 ; i++ ){
            if(i % 2 == 0){
                double distancia = puntos[i].distanciaA(puntos[i+1]);
                System.out.println("Distancia entre:" + (i+1) + " y " + (i+2));
                System.out.println(distancia);
            }
            teclado.close();
        }
        
    }
}