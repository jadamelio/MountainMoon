import java.awt.Color;

/**
 * 
 * @author Jacques
 * @date Dec 14, 2015
 * @class GraphicPolygon.java
 * @description TODO Describe the class
 */

public class GraphicPolygon {

	int nodes = 3;
	int[] xCoord; 
	int[] yCoord; 
	Color colour;

	public GraphicPolygon(int a) {
		xCoord = new int[]{1,85,19};
		yCoord = new int[]{1,20,16};
		colour = new Color(0).RED;
	}
	public GraphicPolygon() {
	
	}
	
	


	
	

	public GraphicPolygon(Tile t, Color c) {
		fillCoords(t);
		setColour(t,c);

	}

	public void setColour(Tile t, Color c) {
		if (c != null) {
			int angle = (int)Math.toDegrees(Math.atan((t.getMaxY() - t.getMinY())/(t.getMaxX() - t.getMinX())));
			colour = new Color(c.getRed()- angle, c.getGreen()-angle, c.getBlue() -angle);
			
			
			
		} else {
			colour = new Color(0).RED;
			
			
		}
	}

	public void fillCoords(Tile t) {
		for (int i = 0; i < t.getNode().length; i++) {
			xCoord[i] = (int) t.getNode()[i].getX();
			yCoord[i] = (int) t.getNode()[i].getY();
		}
	}

	public int getNodes() {
		return nodes;
	}

	public void setNodes(int nodes) {
		this.nodes = nodes;
	}

	public int[] getxCoord() {
		return xCoord;
	}

	public void setxCoord(int[] xCoord) {
		this.xCoord = xCoord;
	}

	public int[] getyCoord() {
		return yCoord;
	}

	public void setyCoord(int[] yCoord) {
		this.yCoord = yCoord;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

}
