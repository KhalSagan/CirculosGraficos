package net.ausiasmarch.figurasgraficas.modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

/**
 *
 * @author Programador
 */
public class Circulo{
    
    /*
     * Declaramos las clases.
     */
    
    private double x, y, radio;
    private Color colorRelleno = new Color(0,0,0);
    private Color colorContorno = new Color(0,0,0);
    private int grosor;
    private boolean relleno;
    private String mensaje;
    private Color color;
    
    /*
     * Constructores
     */

    public Circulo(double x, double y, double radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }
    
    public Circulo(Color colorRelleno, Color colorGrosor) {
        this.colorRelleno = colorRelleno;
        this.colorContorno = colorContorno;
    }
    
    

    /*
     * Getters and Setters.
     */
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Color getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public Color getColorContorno() {
        return colorContorno;
    }

    public void setColorContorno(Color colorContorno) {
        this.colorContorno = colorContorno;
    }

    public int getGrosor() {
        return grosor;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /*
     * Método para asignar el color del RELLENO.
     */
    public void setColorRelleno(int rojo, int verde, int azul) {
        this.color = new Color(rojo, verde, azul);
    }

    /*
     * Método para asignar el color del CONTORNO.
     */
    public void setColorContorno(int rojo, int verde, int azul) {
        this.color = new Color(rojo, verde, azul);
    }

    /*
     * Método para calcular el ÁREA. 
     */
    public double getArea() {
        return (radio * radio * Math.PI);
    }

    /*
     * Método para calcular la CIRCUNFERENCIA.
     */
    
    public double getCircunferencia(){
        return (2 * radio * Math.PI);
    }
       

    /**
     * Método que dibuja la figura sobre la ventana.
     * @param g2d Entorno gráfico sobre el que se dibuja la figura
     */

    public void dibujar(Graphics2D g2d){
        
        Ellipse2D circulo = new Ellipse2D.Double(x, y, radio, radio);
        
        if(relleno){    //Si tiene relleno   
            g2d.setPaint(colorRelleno); //Establece el color del relleno
            g2d.fill(circulo);  //Dibuja el circulo con relleno
        }
        
        g2d.setPaint(this.colorContorno);   //Establece el color del contorno
        g2d.setStroke(new BasicStroke(grosor)); //Establece el grosor
        g2d.draw(circulo);  //Dibuja el circulo
        
    }

    public int validate() {

        if (radio <= 1) {
            mensaje = "El radio no puede ser menor o igual que 1.";
            return 1;
        }

        if (grosor < 0 || grosor >= radio) {
            mensaje = "El grosor no puede ser menor que 0 ni mayor o igual que el radio.";
            return 2;
        }
        return 0;
    }
    
       
    }
