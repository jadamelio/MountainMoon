import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Tile[][] map = new Tile[3][3];
		map[0][0] = new Tile(new CoordPac(0, 0, 0), 10);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (j == 0 && i != 0) {					
					map[i][j] = new Tile(copy(map[i - 1][j].getNodes())[2][0], 10);
				} else if (j != 0) {
					map[i][j] = new Tile(copy(map[i][j - 1].getNodes())[0][2], 10);
				}
			}
		}
		map[0][2].setHeight(200);
		map[1][2].setHeight(200);
		map[2][2].setHeight(200);
		
		
		for(int i = 0; i < map.length; i++){
			CoordPac[] transfer = new CoordPac[map[i].length];
					}
		
		
		MapOperator op = new MapOperator();
		map = op.tilt(map);
		
		for (int j = map.length - 1; j >= 0; j--) {
			for (int i = 0; i < map[j].length; i++) {
				System.out.print(map[i][j].yString() + " ");
				System.out.print("| |");
			}
			System.out.println();
		}
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
				mu.add(new GraphicPolygon(a[i][j], new Color(0).BLUE));
			}
		}

		for (int i = 0; i < mu.size(); i++) {
			gp[i] = mu.get(i);
		}

		mapGraphic map = new mapGraphic();
		map.loadMultiPoly(gp);

		BasicEx ex = new BasicEx(400, 400, map);
		ex.setVisible(true);

	}
}

