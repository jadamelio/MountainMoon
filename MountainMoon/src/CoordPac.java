//Class that contains three Cartesian coordinates
public class CoordPac {
	private double x;
	private double y;
	private double z;

	public CoordPac(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String coordsToString() {
		// Returns String of Coordinate set, (X,Y,Z)
		return "(" + x + " " + y + " " + z + ")";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
