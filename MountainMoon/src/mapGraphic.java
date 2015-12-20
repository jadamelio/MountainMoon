import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Jacques
 * @date Dec 14, 2015
 * @class mapGraphic.java
 * @description TODO Describe the class
 */

public class mapGraphic extends JPanel {

	ArrayList<Polygon> tiles;
	ArrayList<Color> colour;

	public mapGraphic() {
		tiles = new ArrayList<Polygon>();
		colour = new ArrayList<Color>();
	}

	
	

	private void doDrawing(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		for (int i = 0; i < tiles.size(); i++) {
		g2D.setColor(colour.get(i));
		g2D.setStroke(new BasicStroke(200));
			g2D.fillPolygon(tiles.get(i));
			
		}

	}

	public void loadMultiPoly(GraphicPolygon[] gp) {
		for (int i = 0; i < gp.length; i++) {
			loadAddPoly(gp[i]);
			
		}
	}

	public Polygon loadAddPoly(GraphicPolygon gp) {
		Polygon temp = new Polygon(gp.getxCoord(), gp.getyCoord(),3);
		tiles.add(temp);
		colour.add(gp.getColour());
		return temp;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}
