/**
 * 
 * @author Jacques
 * @date Dec 3, 2015
 * @class Chord.java
 * @description TODO Describe the class
 */
//Linear Body that connects two nodes with in a tile
public class Chord {
	private CoordPac[] endPoints = new CoordPac[2];
	private int width;
	private String type;
	private int id;
	private int ChainId;

	public Chord(CoordPac a, CoordPac b, int width, String type, int id,
			int chainId) {
		super();
		this.endPoints[0] = a;
		this.endPoints[1] = b;
		this.width = width;
		this.type = type;
		this.id = id;
		ChainId = chainId;
	}

	public CoordPac[] getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(CoordPac[] endPoints) {
		this.endPoints = endPoints;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChainId() {
		return ChainId;
	}

	public void setChainId(int chainId) {
		ChainId = chainId;
	}

}
