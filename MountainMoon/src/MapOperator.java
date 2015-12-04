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

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				if (j != copy[i].length - 1) {

					double average = (copy[i][j].getNodes()[0][2].getY() + copy[i][j + 1]
							.getNodes()[0][0].getY()) / 2;

					copy[i][j].getNodes()[0][2].setY(average);
					copy[i][j + 1].getNodes()[0][0].setY(average);

					average = (copy[i][j].getNodes()[2][2].getY() + copy[i][j + 1]
							.getNodes()[2][0].getY()) / 2;

					copy[i][j].getNodes()[2][2].setY(average);
					copy[i][j + 1].getNodes()[2][0].setY(average);

				}
			}

		}

		for (int j = 0; j < copy.length; j++) {
			for (int i = 0; i < copy[j].length; i++) {
				if (i != copy[j].length - 1) {
					double average = (copy[i][j].getNodes()[2][0].getY() + copy[i + 1][j]
							.getNodes()[0][0].getY()) / 2;

					copy[i][j].getNodes()[2][0].setY(average);
					copy[i + 1][j].getNodes()[0][0].setY(average);

					average = (copy[i][j].getNodes()[2][2].getY() + copy[i + 1][j]
							.getNodes()[0][2].getY()) / 2;

					copy[i][j].getNodes()[2][2].setY(average);
					copy[i + 1][j].getNodes()[0][2].setY(average);

				}
			}

		}

		return copy;

	}
}
