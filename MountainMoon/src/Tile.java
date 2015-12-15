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
	private ArrayList<Integer> adjacentTile = new ArrayList<Integer>();
	private CoordPac[] nodes = new CoordPac[3];
	private String type;
	private int typeID;
	private ArrayList<Chord> chords = new ArrayList<Chord>();
	private ArrayList<RadialBody> bodies = new ArrayList<RadialBody>();
	private boolean up;

	public Tile(int index, ArrayList<Integer> adjacentTile, CoordPac[] nodes,
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
	}

	public Tile() {
		super();
		
	}

	public Tile(int index, ArrayList<Integer> adjacentTile, String type,
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
	
	public Tile(int index, ArrayList<Integer> adjacentTile, CoordPac initCoord, double dimension, boolean up){
		this.index = index;
		this.adjacentTile = adjacentTile;
		this.nodes = setCoords(dimension, initCoord);
		this.up = up;
	}

	public Tile(CoordPac initCoord, double dimension) {
		nodes = setCoords(dimension, initCoord);
	}

	public Chord addChord(CoordPac[] endPoints, int width, String type, int id,
			int chainId) {
		// Creates new nod in the tile, rounds give coords to nearest node in
		// the tile

		double comparitor = Double.MAX_VALUE;
		CoordPac holderA = null;
		CoordPac holderB = null;
		for (int p = 0; p < endPoints.length; p++) {
			for (int i = 0; i < nodes.length; i++) {
				for (int j = 0; j < nodes[i].length; j++) {
					if (comparitor > distanceCalc(endPoints[0], nodes[i][j])) {
						if (p == 0) {
							holderA = nodes[i][j];
						}
						if (p == 1) {
							holderB = nodes[i][j];
						}
					}
				}
			}
		}

		chords.add(new Chord(holderA, holderB, width, type, id, chainId));

		return chords.get(chords.size() - 1);
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
					originCoord.getZ() + Math.sqrt(dimension / 2));
		}
		
		else{
			temp[1] = new CoordPac(originCoord.getX() + (dimension / 2), originCoord.getY(), 
					originCoord.getZ() - Math.sqrt(dimension / 2));
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<Integer> getAdjacentTile() {
		return adjacentTile;
	}

	public void setAdjacentTile(ArrayList<Integer> adjacentTile) {
		this.adjacentTile = adjacentTile;
	}

	public CoordPac[] getNodes() {
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
}
