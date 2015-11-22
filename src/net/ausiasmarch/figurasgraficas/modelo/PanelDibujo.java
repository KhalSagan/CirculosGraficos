/*
 * PanelDibujo.java
 */
package net.ausiasmarch.figurasgraficas.modelo;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;


/**
 * Clase PanelDibujo: Representa el panel sobre el que se dibujan los circulos
 * @author Programador
 */
public class PanelDibujo extends javax.swing.JPanel {
    private boolean showGrid = false;
    private int anchoGrid = 50, altoGrid = 50;
    private java.util.List<Circulo> figuras = new ArrayList<>();

    public PanelDibujo() {
        initComponents();    
    }

    /**
    * Añade un nuevo circulo al array de Figuras
    * @param circulo a añadir
    */
    public void addFigura(Circulo circulo) {
        figuras.add(circulo);
    }
       
     /**
     * comprueba si el circulo esta dentro del panel de dibujo
     */
    public boolean contiene(double x, double y, double ancho, double alto) {
        return ((int) x >= 0 && (int) x + (int) ancho <= getWidth() &&
                (int) y >= 0 && (int) y + (int) alto <= getHeight());
    }

   /**
     * Establece el ancho y alto en pixel de las celdas de la rejilla
     */
     public void grid(int ancho, int alto){
        if (ancho < 50 || alto < 50) {
            ancho = 50;
            alto = 50;
        } else if (ancho > 100 || alto > 100){
            ancho = 100;
            alto = 100;
        }
        anchoGrid = ancho;
        altoGrid = alto;
    }

    /**
     * Obtiene si se muestra la rejilla
     * @return Retorna true si se muestra la rejilla o false si la muestra
     */
    public boolean isShowGrid() {
        return isShowGrid();
    }

    /**
     * Muestra la rejilla
     * @params showGrid
     */
    public void setShowGrid(boolean showGrid) {
        this.showGrid = showGrid;
        repaint();
    }

   /**
    * Dibuja figuras sobre el panel y dibuja la rejilla
    * @params g Graphics 
    */
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);          // color de relleno del contexto

        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        if (!figuras.isEmpty()){
            for (int i = 0; i < figuras.size(); i++) {
                figuras.get(i).dibujar(g2d);
            }
        }
        
        if (showGrid) {
            g2d.setPaint(Color.GRAY);

            float dash1[] = {2.0f};
            BasicStroke dashed = new BasicStroke(1.0f,BasicStroke.CAP_BUTT,
                                                      BasicStroke.JOIN_MITER,
                                                      1.0f, dash1, 0.0f);
            g2d.setStroke(dashed);

            for(int x=0;x<=this.getSize().width;x=x+anchoGrid) {
                Line2D line=new Line2D.Float(x,0,x,this.getSize().height);
                g2d.draw(line);
            }
            for(int y=0;y<=this.getSize().height;y=y+altoGrid) {
                Line2D line=new Line2D.Float(0,y,this.getSize().width,y);
                g2d.draw(line);
            }

            //Dibujar los textos numericos
            for(int x=0;x<=this.getSize().width;x=x+anchoGrid) {
                for(int y=0;y<=this.getSize().height;y=y+altoGrid) {
                    g2d.drawString(x+ "," +y, x, y+10);
                }
            }
        }      
    }

    /**
     * Dibuja un circulo en el panel de dibujo
     */   
    public void dibuja(Circulo circulo) {
        figuras.add(circulo);
        repaint();
    }
  

    /**
     * Limpia el panel de dibujo
     */
    public void limpia() {
        figuras.clear();
        repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
