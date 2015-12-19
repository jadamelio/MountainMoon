/**
 * 
 * @author Jacques
 * @date Dec 3, 2015
 * @class MapOperator.java
 * @description TODO Describe the class
 */

public class MapOperator extends Toolkit {

	public MapOperator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double[] quadraticGradeint(CoordPac[] a, int startIndex, int endIndex) {
		double[] newHeights = new double[endIndex - startIndex];
		double x1 = a[startIndex].getX();
		double x2 = a[endIndex].getX();
		double y1 = a[startIndex].getY();
		double y2 = a[endIndex].getY();
		for (int i = 0; i < a.length; i++) {
			double x = a[startIndex + i].getX();
			newHeights[i] = ((y2 - y1) / (x2 - x1)) * (x - x1) + y1;
		}

		return newHeights;

	}

	public Tile[][] tilt(Tile[][] original) {
		Tile[][] copy = copyMap(original);

		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[i].length - 1; j++) {
				if (original[i][j].getUp()) {
					double height = (original[i][j].getNodes()[1].getY() + original[i][j + 1]
							.getNodes()[1].getY()) / 2;
					original[i][j].getNodes()[1].setY(height);
					original[i][j + 1].getNodes()[1].setY(height);
				} else {
					double height = (original[i][j].getNodes()[2].getY() + original[i][j + 1]
							.getNodes()[2].getY()) / 2;
					original[i][j].getNodes()[2].setY(height);
					original[i][j + 1].getNodes()[2].setY(height);

					height = (original[i][j].getNodes()[0].getY() + original[i][j + 1]
							.getNodes()[0].getY()) / 2;
					original[i][j].getNodes()[0].setY(height);
					original[i][j + 1].getNodes()[0].setY(height);
				}
			}
		}

		for (int j = 0; j < original.length; j++) {
			for (int i = 0; i < original[j].length - 1; i++) {
				double height = (original[i][j].getNodes()[1].getY() + original[i+1][j].getNodes()[0].getY())/2;
				original[i][j].getNodes()[1].setY(height);
				original[i+1][j].getNodes()[0].setY(height);
				
			}
		}
		return original;
	}

}
