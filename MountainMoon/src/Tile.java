/**
 * @author Jacques
 * @date Dec 3, 2015
 * @class Tile.java
 * @description TODO Describe the class
 */
import java.util.ArrayList;

//Parent class for all tiles, rectangular constructed out of 8 nodes

public class Tile extends Toolkit {
	private int index;
	private int[] adjacentTile = new int[3];
	private CoordPac[] nodes = new CoordPac[3];
	private String type;
	private int typeID;
	private double height;
	private ArrayList<Chord> chords = new ArrayList<Chord>();
	private ArrayList<RadialBody> bodies = new ArrayList<RadialBody>();
	private boolean up;
	private boolean occupied = false;

	public Tile(int index, int[] adjacentTile, CoordPac[] nodes,
			String type, int typeID, ArrayList<Chord> chords,
			ArrayList<RadialBody> bodies, boolean up) {
		super();
		this.index = index;
		this.adjacentTile = adjacentTile;
		this.nodes = nodes;
		this.type = type;
		this.typeID = typeID;
		this.chords = chords;
		this.bodies = bodies;
		this.up = up;
	}

	public Tile() {
		super();
		
	}

	public Tile(int index, int[] adjacentTile, String type,
			int typeID, ArrayList<Chord> chords, ArrayList<RadialBody> bodies,
			CoordPac initCoord, double dimension) {
		super();
		this.index = index;
		this.adjacentTile = adjacentTile;
		this.type = type;
		this.typeID = typeID;
		this.chords = chords;
		this.bodies = bodies;
		nodes = setCoords(dimension, initCoord);
	}
	
	public Tile(int index,int[] adjacentTile, CoordPac initCoord, double dimension, boolean up){
		this.index = index;
		this.adjacentTile = adjacentTile;
		this.up = up;
		this.nodes = setCoords(dimension, initCoord);
	}

	public Tile(CoordPac initCoord, double dimension) {
		nodes = setCoords(dimension, initCoord);
	}

	public CoordPac[] setCoords(double dimension, CoordPac originCoord) {

		// Fills the node array with CoordPacs using only bottom left(origin)
		// corner and the dimension of the tile

		CoordPac[] temp = new CoordPac[3];
		temp[0] = originCoord;
		temp[2] = new CoordPac(originCoord.getX() + dimension, originCoord.getY(),
				originCoord.getZ());
		if(up == true){
			temp[1] = new CoordPac(originCoord.getX() + (dimension / 2), originCoord.getY(),
					originCoord.getZ() + Math.sqrt(3) * (dimension / 2));
		}
		
		else{
			temp[1] = new CoordPac(originCoord.getX() + (dimension / 2), originCoord.getY(), 
					originCoord.getZ() - Math.sqrt(3) * (dimension / 2));
		}
		return temp;

	}

	public String nodeString() {

		// returns a string that is a formated set of the coordinates of each
		// node.
		return nodes[0].coordString() + " " + nodes[1].coordString()
				+ " " + nodes[2].coordString();

	}
		public String yString() {

		// returns a string that is a formated set of the coordinates of each
		// node.
		return nodes[0].getY() + " " + nodes[1].getY() + " "
				+ nodes[2].getY();

	}

	public double setHeight(double y) {
		for (int i = 0; i < this.nodes.length; i++) {
			this.nodes[i].setY(y);
		}
		return y;
	}
	
	public double getHeight(){
		double avg = 0;
		for (int i = 0; i < this.nodes.length; i++){
			avg = avg + this.nodes[i].getY();
		}
		avg /= (this.nodes.length);
		return avg;
	}


	
	public double getMaxY() {
		double highest = -1.0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getY() > highest) {
				highest = nodes[i].getY();

			}
		}

		return highest;
	}
	
	public double getMaxX() {
		double highest = -1.0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getY() > highest) {
				highest = nodes[i].getX();

			}
		}

		return highest;
	}
	public double getMaxZ() {
		double highest = -1.0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getY() > highest) {
				highest = nodes[i].getZ();

			}
		}

		return highest;
	}
	
	

	public double getMinY() {
		double lowest = -1.0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getY() < lowest) {
				lowest = nodes[i].getY();

			}
		}

		return lowest;
	}
	
	public double getMinX() {
		double lowest = -1.0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getX() < lowest) {
				lowest = nodes[i].getX();

			}
		}

		return lowest;
	}
	public double getMinZ() {
		double lowest = -1.0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getZ() < lowest) {
				lowest = nodes[i].getZ();

			}
		}

		return lowest;
	}
	
	public boolean isNextTo(int index){
		for(int i = 0; i < adjacentTile.length; i++){
			if(adjacentTile[i] == index){
				return true;
			}
		}
		return false;
	}

	public int getAdjacent(int a){
		return adjacentTile[a];
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int[] getAdjacentTile() {
		return adjacentTile;
	}

	public void setAdjacentTile(int[] adjacentTile) {
		this.adjacentTile = adjacentTile;
	}

	public CoordPac[] getNodes(){
		return nodes;
	}

	public void setNodes(CoordPac[] nodes) {
		this.nodes = nodes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public ArrayList<Chord> getChords() {
		return chords;
	}

	public void setChords(ArrayList<Chord> chords) {
		this.chords = chords;
	}

	public ArrayList<RadialBody> getBodies() {
		return bodies;
	}

	public void setBodies(ArrayList<RadialBody> bodies) {
		this.bodies = bodies;
	}

	public boolean getUp(){
		return up;
	}
	
	public void setUp(boolean up){
		this.up = up;
	}
	
	public void printNodes(){
		System.out.println(nodes[0].coordString());
		System.out.println(nodes[1].coordString());
		System.out.println(nodes[2].coordString());
		System.out.println();
	}
	
	public boolean isOccupied(){
		return occupied;
	}
}

