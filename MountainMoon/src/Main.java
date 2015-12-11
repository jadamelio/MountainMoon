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
	
	public static CoordPac[][] copy(CoordPac[][] original) {
		CoordPac[][] copy = new CoordPac[original.length][original.length];

		for (int i = 0; i < original.length; i++) {
			for(int j = 0; j < original[i].length; j++){
				copy[i][j] = new CoordPac();
				copy[i][j].setX(original[i][j].getX());
				copy[i][j].setZ(original[i][j].getZ());
				copy[i][j].setY(original[i][j].getY());
			}
		}
		return copy;
	}
}
