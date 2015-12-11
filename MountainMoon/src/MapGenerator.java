import java.util.Random;
/**
 * 
 * @author Alex
 * @date Dec 8, 2015
 * @class MapGenerator.java
 * @description TODO Make a description
 */
public class MapGenerator {
	private int height;
	private int width;
	private Tile[][] map;
	private double faultOne = (Math.random());
	private double faultTwo = (Math.random());
	private double maxElevation;
	
	public MapGenerator(int inHeight, int inWidth, int inFaultOne, int inFaultTwo){
		height = inHeight;
		width = inWidth;
		map = new Tile[height][width];
		formatNewTiles();
		faultOne = inFaultOne;
		faultTwo = inFaultTwo;
		maxElevation = (height + width) / 2 * faultOne;
		formatChain();
		
	}
	
	public MapGenerator(int inHeight, int inWidth){
		height = inHeight;
		width = inWidth;
		map = new Tile[height][width];
		formatNewTiles();
		maxElevation = (height + width) / 2;
		formatChain();
		
	}
	
	public void formatNewTiles(){
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
	
	public void formatChain(){
		Random dice = new Random();
		int lengthOne = (int) (((height + width) / 2));
		int lengthTwo = (int) (((height + width) / 2));
		if(faultOne != 0)lengthOne = (int) (((height * faultOne) + (width * faultOne)) / 2);
		chain((int)(height - 1 * faultOne),(int)(width - 1 * faultOne), lengthOne, maxElevation, 0);	
		
		if(faultTwo != 0)lengthTwo = (int) (((height * faultTwo) + (width * faultTwo)) / 2);
		chain((int)(height - 1 * faultTwo),(int)(width - 1 * faultTwo), lengthTwo, 0, 0);
		
	}
	
	public double getElevation(int x, int y){
		return map[x][y].getHeight();
	}
	
	 public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}

	public double getFaultOne() {
		return faultOne;
	}
	
	public double getFaultTwo(){
		return faultTwo;
	}

	public void setFaultOne(double faultOne) {
		this.faultOne = faultOne;
	}
	
	public void setFaultTwo(double faultTwo){
		this.faultTwo = faultTwo;
	}

	public double getMaxElevation() {
		return maxElevation;
	}

	public void setMaxElevation(double maxElevation) {
		this.maxElevation = maxElevation;
	}

	public void chain(int x, int y, int length, double elevation, int current){
	   Random dice = new Random();
	   map[x][y].setHeight(elevation);
	    if (current <= length){
	      if (x != 0 && y != 0 && x != (width - 1) && y != (height - 1)){
	        if (dice.nextInt(100) < 50){
	          if (map[x + 1][y].getHeight() == map[x][y].getHeight()){
	            chain(x - 1, y, length, elevation, current + 1);
	          }
	          else if (map[x - 1][y].getHeight() == map[x][y].getHeight()){
	            chain(x + 1, y, length, elevation, current + 1);
	          }
	          else if (map[x][y + 1].getHeight() == map[x][y].getHeight()){
	            chain(x, y - 1, length, elevation, current + 1);
	          }
	          else if (map[x][y - 1].getHeight() == map[x][y].getHeight()){
	            chain(x, y + 1,length, elevation, current + 1);
	          }
	          else{
	            chain(x + (1 - dice.nextInt(2)), y + (1 - dice.nextInt(2)), length, elevation, current + 1);
	          }
	        }
	        else{
	          chain(x + (1 - dice.nextInt(2)), y + (1 - dice.nextInt(2)), length, elevation, current + 1);
	        }
	      }
	    }
	  }
}
