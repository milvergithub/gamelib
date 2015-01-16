package milver.flores.acevedo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
/**
 * @author MILVER
 */
@SuppressWarnings("serial")
public class StageM extends JComponent{
	private ImageIcon icono = null;
	/**
	 * todo lo necesario para configurar
	 * la linea cuadriculada
	 * */
	private Color colorLinea;
	private int tamCuadricula;
	private int grosorlinea;
	public StageM(){
		tamCuadricula=30;
		grosorlinea=1;
		colorLinea=Color.BLACK;
		setImagen("/image/fondo.png");
	}
	public void setGrosorLinea(int gr){
		grosorlinea=gr;
	}
	public int getGrosorLinea(){
		return grosorlinea;
	}
	public void setTamanioCuadricula(int tam){
		tamCuadricula=tam;
	}
	public int getTamanioCuadricula(){
		return tamCuadricula;
	}
	public void setImagen(String img){
		this.icono = new ImageIcon(getClass().getResource(img));
	}
	public ImageIcon getImagen(){
		return icono;
	}
	public Color getColorLinea(){
		return colorLinea;
	}
	public void setColorLinea(Color c){
		colorLinea=c;
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i <this.getHeight(); i++) {
			g2d.setColor(getColorLinea());
			float dash[] = {5};
	        g2d.setStroke(new BasicStroke(getGrosorLinea(),BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
			g2d.drawLine(0, i*getTamanioCuadricula(), this.getWidth(), i*getTamanioCuadricula());
		}
		for (int i = 0; i <this.getHeight(); i++) {
			g2d.setColor(getColorLinea());
			float dash[] = {5};
	        g2d.setStroke(new BasicStroke(getGrosorLinea(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
			g2d.drawLine(i*getTamanioCuadricula(), 0, i*getTamanioCuadricula(),this.getHeight());
		}
		g2d.drawImage(getImagen().getImage(), 0, 0, getWidth(), getHeight(), this);
	}
}
