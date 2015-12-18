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
	int[] xCoord = new int[3];
	int[] zCoord = new int[3];
	Color colour;

	public GraphicPolygon(int a) {
		xCoord = new int[] { 1, 85, 19 };
		zCoord = new int[] { 1, 20, 16 };
		colour = new Color(0).RED;
	}

	public GraphicPolygon() {

	}

	public GraphicPolygon(Tile t, Color c) {

		fillCoords(t);
		setColour(t, c);

	}

	public void setColour(Tile t, Color c) {
		if (c != null) {
			int angle = (int) Math.toDegrees(Math.asin((t.getMaxY()-t.getMinY()/100)));
			colour = new Color((int) t.getHeight(), 10, 3*angle);

		} else {
			colour = new Color(0).RED;

		}
	}

	public void fillCoords(Tile t) {
		for (int i = 0; i < t.getNodes().length; i++) {

			if (i == 1) {
				if (t.getUp()) {
					xCoord[i] = (int) t.getNodes()[i].getX();

					zCoord[i] = (int) Math.ceil(t.getNodes()[i].getZ());
				}else{
					xCoord[i] = (int) t.getNodes()[i].getX();

					zCoord[i] = (int) Math.floor(t.getNodes()[i].getZ());
				}
			} else {

				xCoord[i] = (int) t.getNodes()[i].getX();

				zCoord[i] = (int) t.getNodes()[i].getZ();
			}

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
		return zCoord;
	}

	public void setyCoord(int[] yCoord) {
		this.zCoord = yCoord;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

}
