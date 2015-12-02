import java.util.ArrayList;

//Parent class for all tiles, rectangular constructed out of 8 nodes

public class Tile extends Toolkit {
	private int index;
	private ArrayList<Integer> adjacentTile = new ArrayList<Integer>();
	private CoordPac[][] nodes = new CoordPac[3][3];
	private String type;
	private int typeID;
	private ArrayList<Chord> chords = new ArrayList<Chord>();
	private ArrayList<RadialBody> bodies = new ArrayList<RadialBody>();

	public Tile(int index, ArrayList<Integer> adjacentTile, CoordPac[][] nodes,
			String type, int typeID, ArrayList<Chord> chords,
			ArrayList<RadialBody> bodies) {
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

	public Chord addChord(CoordPac[] endPoints, int width, String type, int id,
			int chainId) {
		//Creates new nod in the tile, rounds give coords to nearest node in the tile
		
		double comparitor = Double.MAX_VALUE;
		CoordPac holderA = null;
		CoordPac holderB = null;
		for (int p = 0; p < endPoints.length; p++) {
			for (int i = 0; i < nodes.length; i++) {
				for (int j = 0; j < nodes[i].length; j++) {
					if (comparitor > distanceCalc(endPoints[0], nodes[i][j])) {
						if(p == 0){
							holderA = nodes[i][j];
						}
						if(p == 1){
							holderB = nodes[i][j];
						}
					}
				}
			}
		}

		chords.add(new Chord(holderA, holderB, width, type, id, chainId));

		return chords.get(chords.size() - 1);
	}

	public CoordPac[][] setCoords(double dimension, CoordPac originCoord) {

		// Fills the node array with CoordPacs using only bottom left(origin)
		// corner and the dimension of the tile

		CoordPac[][] temp = new CoordPac[3][3];
		temp[0][0] = originCoord;
		temp[0][2] = new CoordPac(originCoord.getX(), originCoord.getY()
				+ dimension, originCoord.getZ());
		temp[2][2] = new CoordPac(originCoord.getX() + dimension,
				originCoord.getY() + dimension, originCoord.getZ());
		temp[2][0] = new CoordPac(originCoord.getX() + dimension,
				originCoord.getY(), originCoord.getZ());

		temp[0][1] = new CoordPac(originCoord.getX(), originCoord.getY()
				+ dimension / 2, originCoord.getZ());
		temp[1][0] = new CoordPac(originCoord.getX() + dimension / 2,
				originCoord.getY(), originCoord.getZ());
		temp[1][1] = new CoordPac(originCoord.getX() + dimension / 2,
				originCoord.getY() + dimension / 2, originCoord.getZ());

		temp[2][1] = new CoordPac(originCoord.getX() + dimension,
				originCoord.getY() + dimension / 2, originCoord.getZ());
		temp[1][2] = new CoordPac(originCoord.getX() + dimension / 2,
				originCoord.getY() + dimension, originCoord.getZ());

		return temp;

	}

	public String coordsToString() {

		// returns a string that is a formated set of the coordinates of each
		// node.
		return nodes[0][2].coordsToString() + " "
				+ nodes[1][2].coordsToString() + " "
				+ nodes[2][2].coordsToString() + "\n"
				+ nodes[0][1].coordsToString() + " "
				+ nodes[1][1].coordsToString() + " "
				+ nodes[2][1].coordsToString() + "\n"
				+ nodes[0][0].coordsToString() + " "
				+ nodes[1][0].coordsToString() + " "
				+ nodes[2][0].coordsToString() + "\n";

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

	public CoordPac[][] getNodes() {
		return nodes;
	}

	public void setNodes(CoordPac[][] nodes) {
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

}
