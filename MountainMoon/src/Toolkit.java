public class Toolkit {
	// A class that can will contain reusable methods that will be applied to
	// multiple classes
	public double distanceCalc(CoordPac a, CoordPac b) {
		// Returns the distance between two 3d points
		return (double) Math
				.sqrt(((a.getX() - b.getX()) * (a.getX() - b.getX()))
						+ ((a.getY() - b.getY()) * (a.getY() - b.getY()))
						+ ((a.getZ() - b.getZ()) * (a.getZ() - b.getZ())));
	}

	
	//Trace commands for debugging
	public void trace(String a) {
		System.out.println(a);
	}

	public void trace(int a) {
		System.out.println(a);
	}

	public void trace(double a) {
		System.out.println(a);
	}

	public void trace(char a) {
		System.out.println(a);
	}

}
