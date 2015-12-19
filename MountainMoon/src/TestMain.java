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
		Map map = new Map(100, 100, 30);
		MapGenerator test = new MapGenerator(map);
		//routine(map.getMap());
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
				a[4][3].printNodes();
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
