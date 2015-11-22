package net.ausiasmarch.figurasgraficas.modelo;
import java.util.Random;    //Para generar números aleatorios
import java.awt.Color;      //Para usar la clase Color

/**
 *
 * @author Beto
 */
public class Aleatorio {
    
    /*
     * Devuelve un número entero aleatorio entre 0 y maxValue-1
     */
    public static int nextInt(int maxValue) {
        /*Crea un objeto 'r' para números aleatorios tomando como valor inicial 
        el tiempo del sistema en nanosegundos.*/
        Random ran = new Random(System.nanoTime());
        return ran.nextInt(maxValue);   //Genera un nº aleatorio entero y lo devuelve
    }
    
    /*
     * Devuelve un color aleatorio compuesto de rojo, verde y azul, 
     * todos entre 0 y 256 -1
     */
    public static Color nextColor(){
        return new Color(nextInt(256),nextInt(256),nextInt(256));
    }

}
