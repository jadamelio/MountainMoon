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
		fillMap(1);
	}
	
	public void fillMap(int a){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < z; j++){
				boolean tempUp = (i+j)%2 == 0;
				int tempIndex = (i * z) + j;
				int[] temp = new int[3];
				if(i != 0  && i != x-1){
					temp[0] = tempIndex-1;
					temp[2] = tempIndex+1;
					
				}else if(i == 0){
					temp[0] = -1;
					temp[2] = tempIndex+1;
				}else{
					temp[0] = tempIndex-1;
					temp[2] = -1;
				}
				
				if(tempUp){
					temp[1] = tempIndex + z;
					
					
					
				}else{
					temp[1] = tempIndex - z;
				}
				
				
				double butts = .865;
				double boots = .87;
				
				CoordPac tempInitCoord;
				if(tempUp == true) tempInitCoord = new CoordPac(i * butts*dimension/Math.sqrt(3), 40  , j *boots* dimension);
				else{
					tempInitCoord = new CoordPac((i + 1) * butts*dimension/Math.sqrt(3), 0, j *boots*dimension);
				}

				map[i][j] = new Tile(tempIndex, temp, tempInitCoord, dimension, tempUp);
				
			}
		}
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
					if(tempHelp[3]) tempAdjacent[1] = (tempIndex + 1);
					if(tempHelp[2]) tempAdjacent[2] = (tempIndex + z);
				}
				else{
					if(tempHelp[0]) tempAdjacent[0] = (tempIndex - 1);
					if(tempHelp[1]) tempAdjacent[1] = (tempIndex - z);
					if(tempHelp[2]) tempAdjacent[2] = (tempIndex + 1);
				}
				
				
				//System.out.println(tempAdjacent[1]);
				double butts = .865;
				double boots = .87;
				
				CoordPac tempInitCoord;
				if(tempUp == true) tempInitCoord = new CoordPac(i * butts*dimension/Math.sqrt(3),0  , j *boots* dimension);
				else{
					tempInitCoord = new CoordPac((i + 1) * butts*dimension/Math.sqrt(3), 0, j *boots*dimension);
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
