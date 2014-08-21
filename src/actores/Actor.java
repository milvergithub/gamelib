package actores;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import world.StageM;
/**
 * @author milver
 */
public class Actor extends JComponent{

    private static final long serialVersionUID = 1L;
    private double rotacion = 0.0;
    private int rejilla;
    private StageM stage;
    private ImageIcon icono = null;
    private int tamX,tamY;
    public Actor(StageM s){
        tamX=50;
        tamY=50;
        setSize(getTamX(),getTamX());
        stage=s;
        rejilla=5;
    }
    public void mover(){
        this.setLocation(this.getX()+getRejilla(), this.getY());
    }
    public void setRejilla(int n){
        this.rejilla=n;
    }
    private int getRejilla(){
        return rejilla;
    }
    protected void remover(){
        stage.remove(this);
        stage.repaint();
    }
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform tx = AffineTransform.getRotateInstance(rotacion, icono.getIconWidth()/2, icono.getIconHeight()/2);
        g2d.drawImage(icono.getImage(), tx, this);
    }
    public void setImagen(String imagen) {
        this.icono = new ImageIcon(getClass().getResource(imagen));
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
