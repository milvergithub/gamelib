package actores;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import world.StageM;
/**
 * @author simulacion
 */
public class Actor extends JComponent{
    
    private int rejilla;
    private StageM stage;
    private ImageIcon imagen;
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
    protected void girar(int grads){
        
    }
    public void paint(Graphics g){
        Dimension d=getSize();
        g.drawImage(imagen.getImage(), 0, 0,getWidth(),getHeight(),null);
        setOpaque(false);
        super.paintComponent(g);
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
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
