package milver.flores.acevedo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
/**
 * @author milver
 */
public class Actor extends JComponent{

    private static final long serialVersionUID = 1L;
    private double rotacion = 0.0;
    private StageM stage;
    private ImageIcon icono = null;
    private int tamX,tamY;
    public Actor(StageM s){
        tamX=50;
        tamY=50;
        setSize(getTamX(),getTamY());
        stage=s;
    }
    public void mover(Point punto){
        this.setLocation(punto.x-this.getWidth()/2, punto.y-this.getHeight()/2);
    }
    protected void remover(){
        stage.remove(this);
        stage.repaint();
    }
    @Override
    public void paintComponent(Graphics g){
    	super.paintComponents(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.rotate(getRotacion()* Math.PI / 180.0,getWidth()/2,getHeight()/2);
		g2d.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    public void setImagen(String imagen) {
        this.icono = new ImageIcon(getClass().getResource(imagen));
    }
    private ImageIcon getIconoImagen(){
    	return icono;
    }
    public double getRotacion() {
        return this.rotacion;
    }
    public void setRotacion(double rotacion) {
        this.rotacion = rotacion;
    }
    public int getTamX() {
        return tamX;
    }

    public int getTamY() {
        return tamY;
    }

    public void setTamX(int tamX) {
        this.tamX = tamX;
    }

    public void setTamY(int tamY) {
        this.tamY = tamY;
    }
}
