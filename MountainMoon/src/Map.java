import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Alex
 * @date Dec 14, 2015
 * @class Map.java
 * @description TODO Where the actual map lives
 */
public class Map {
	private Tile[][] map;
	private int x;
	private int z;
	private double dimension;
	
	public Map(int x, int z, double dimension){
		this.x = x;
		this.z = z;
		this.dimension = dimension;
		this.map = new Tile[x][z];
		fillMap();
	}
	
	public void fillMap(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < z; j++){
				int tempIndex = (i * z) + j;
				/* This requires some explanation. In order to find out which tile indexes are adjacent
				 * I made an array of booleans and assumed 0 = left of the current, 1 = above the current, 
				 * 2 = right of the current, and 3 = below the current. If the boolean is true after all the if
				 * statements than it can be added to the arraylist.
				 */
				boolean tempUp = false;
				if((j + i) % 2 == 0)tempUp = true;
				int[] tempAdjacent = new int[3];
				Boolean[] tempHelp = new Boolean[4];
				for(int k = 0; k < 4; k++){
					tempHelp[k] = true;
				}
				if((tempIndex - x) < 0) tempHelp[1] = false;
				if((tempIndex % z) == 0) tempHelp[0] = false;
				if((tempIndex % (z - 1)) == 0) tempHelp[2] = false;
				if((tempIndex + x) >= x) tempHelp[3] = false;
				
				if(tempUp == true){
					if(tempHelp[0]) tempAdjacent[0] = (tempIndex - 1);
					else tempAdjacent[0] = -1;
					if(tempHelp[3]) tempAdjacent[1] = (tempIndex + 1);
					else tempAdjacent[1] = -1;
					if(tempHelp[2]) tempAdjacent[2] = (tempIndex + z);
					else tempAdjacent[2] = -1;
				}
				else{
					if(tempHelp[0]) tempAdjacent[0] = (tempIndex - 1);
					else tempAdjacent[0] = -1;
					if(tempHelp[1]) tempAdjacent[1] = (tempIndex - z);
					else tempAdjacent[1] = -1;
					if(tempHelp[2]) tempAdjacent[2] = (tempIndex + 1);
					else tempAdjacent[2] = -1;
				}
				
				double butts = .865;
				double boots = .87;
				Random rd = new Random();
				CoordPac tempInitCoord;
<<<<<<< HEAD
				if(tempUp == true) tempInitCoord = new CoordPac(i * dimension, -1, j * dimension);
				else{
					tempInitCoord = new CoordPac((i + 1) * dimension, -1, j * dimension);
=======
				if(tempUp == true) tempInitCoord = new CoordPac(i * butts*dimension/Math.sqrt(3),200  , j *boots* dimension);
				else{
					tempInitCoord = new CoordPac((i + 1) * butts*dimension/Math.sqrt(3), 0, j *boots*dimension);
>>>>>>> 4f3a95a4b6340e9445f7fe9610ae1f4a1179a730
				}

				map[i][j] = new Tile(tempIndex, tempAdjacent, tempInitCoord, dimension, tempUp);
			}
		}
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public double getDimension() {
		return dimension;
	}

	public void setDimension(double dimension) {
		this.dimension = dimension;
	}
	
	public Tile getTile(int inX, int inZ){
		return map[inX][inZ];
	}
	
	public Tile getTile(int inIndex){
		int tempX = inIndex / z;
		int tempZ = inIndex % z;
		return map[tempX][tempZ];
	}
	
}
