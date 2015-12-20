import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author Alex
 * @date Dec 8, 2015
 * @class TestMain.java
 * @description My own simple main for testing. Should be in the git ignore
 */
public class TestMain {
	public static void main(String[] args){
<<<<<<< HEAD
		Map map = new Map(100, 100, 30);
=======
		Map map = new Map(100, 100, 100);
>>>>>>> 4f3a95a4b6340e9445f7fe9610ae1f4a1179a730
		MapGenerator test = new MapGenerator(map);
		//routine(map.getMap());
	}
	
	public static double distanceCalc(CoordPac a, CoordPac b) {
		// Returns the distance between two 3d points
		return (double) Math
				.sqrt(((a.getX() - b.getX()) * (a.getX() - b.getX()))
						+ ((a.getY() - b.getY()) * (a.getY() - b.getY()))
						+ ((a.getZ() - b.getZ()) * (a.getZ() - b.getZ())));
	}

	
	public static void routine(Tile[][] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				count++;
			}
		}
		ArrayList<GraphicPolygon> mu = new ArrayList<GraphicPolygon>();
		GraphicPolygon[] gp = new GraphicPolygon[count];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				
		
				mu.add((new GraphicPolygon(a[i][j], new Color(100,50,100))));
			}
		}
//	mu.add(new GraphicPolygon(a[i][j], new Color(0).BLUE));
		for (int i = 0; i < mu.size(); i++) {
			gp[i] = mu.get(i);
		}

		mapGraphic map = new mapGraphic();
		map.loadMultiPoly(gp);

		BasicEx ex = new BasicEx(400, 400, map);
		ex.setVisible(true);

	}
	
	
}
