package actores;
/**
 * @author MILVER
 */
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class MiArco extends JFrame{
    public MiArco(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setVisible(true);
    }
    public void paint(Graphics g){
        ArrayList<Point>puntos=parabola(300,200);
        System.out.println(parabola(300,200));
        for (int i = 0; i < puntos.size(); i++) {
        	g.fillOval(puntos.get(i).x,puntos.get(i).y, 5,5);
		}
    }
    public ArrayList<Point> parabola(int vx,int vy){
    	ArrayList<Point> puntosParabola=new ArrayList<Point>();
    	final int fx=vx,fy=vy;
        int t=20;
        for(int h=0;h<t;h++){
            int auxx=t-h;
            puntosParabola.add(new Point((fx-auxx*10), (fy+auxx*auxx)));
        }
        for(int h=0;h<=t;h++){
            int auxx=h;
            puntosParabola.add(new Point((fx+auxx*10), (fy+auxx*auxx)));
        }
        return puntosParabola;
    }
    public static void main(String arg[]){
        MiArco mi=new MiArco();
    }
}