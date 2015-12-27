import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Alex
 * @date Dec 8, 2015
 * @class MapGenerator.java
 * @description TODO Make a description
 */
public class MapGenerator extends Toolkit {
	private int x;
	private int z;
	private Map map;
	private double faultOne = (Math.random());
	private double faultTwo = (Math.random());
	private double maxElevation;

	public MapGenerator(Map map, int inFaultOne, int inFaultTwo) {
		x = map.getX();
		z = map.getZ();
		this.map = map;
		faultOne = inFaultOne;
		faultTwo = inFaultTwo;
		maxElevation = (x + z) / 2 * faultOne;
		formatChain();

	}

	public MapGenerator(Map map) {
		x = map.getX();
		z = map.getZ();
		this.map = map;
		maxElevation = (x + z) / 2;
		formatChain();

	}

	public static CoordPac[][] copy(CoordPac[][] original) {
		CoordPac[][] copy = new CoordPac[original.length][original.length];

		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[i].length; j++) {
				copy[i][j] = new CoordPac();
				copy[i][j].setX(original[i][j].getX());
				copy[i][j].setZ(original[i][j].getZ());
				copy[i][j].setY(original[i][j].getY());
			}
		}
		return copy;
	}

	public ArrayList<Integer> getProperLengthList(double length, double fault,
			ArrayList<Integer> notRandom) {
		int num = (int) length / 16;
		for (int i = 1; i <= num + 1; i++) {
			String temp = Double.toString(fault * i);
			for (int j = 0; j < 16; j++) {
				char now = temp.charAt(j);
				notRandom.add((int) now);
			}
		}
		return notRandom;
	}

	public void formatChain() {
		/*
		 * Random dice = new Random(); int lengthOne = (int) (((x + z) / 2));
		 * int lengthTwo = (int) (((x + z) / 2));
		 * 
		 * if(faultOne != 0)lengthOne = (int) (((x * faultOne) + (z * faultOne))
		 * / 2); int tempX = (int)(x - 1 * faultOne); int tempY = (int)(z - 1 *
		 * faultOne); chain(tempX, tempY, lengthOne, maxElevation, 0, -1);
		 * 
		 * tempX = (int)(x - 1 * faultTwo); tempY = (int)(z - 1 * faultTwo);
		 * if(faultTwo != 0)lengthTwo = (int) (((x * faultTwo) + (z * faultTwo))
		 * / 2); chain(tempX,tempY, lengthTwo, 0, 0, -1);
		 */
		chain(8000, 8000, new ArrayList<Integer>(), 255,
				getProperLengthList(65, faultOne, new ArrayList<Integer>()), 0,
				1000);
		
	
		System.out.println("Boom");
	}

	public void chain(int index, int failsafe, ArrayList<Integer> contains, double height, ArrayList<Integer> dice, int dicePosition, int length) {
		// System.out.println(dicePosition);
		
		if (length > 0) {
			if (contains.size() < dice.get(0) + dice.get(1) * dice.get(2)) {
				int loop = 0;
				if (dicePosition >= dice.size()) {
					dicePosition = 0;
				}

				// System.out.println("mom " + contains);
				int num = (dice.get(dicePosition) % 3);
				
				
				if (index < 0) {
					System.out.println("chug chug");
					chain(failsafe, failsafe--, contains, height, dice,
							++dicePosition, length);
				} else {
					contains.add(index);
					
					map.getTile(index).setHeight(height);
					while (contains.contains(map.getTile(index).getAdjacent(
							dice.get(dicePosition) % 3))) {

						loop++;
						if (loop > dice.size()
								|| dicePosition >= dice.size() - 1) {

							
							break;
						}

						dicePosition++;
					}
					num = (dice.get(dicePosition) % 3);
					
				//	System.out.println((map.getTile(index).getAdjacent(num)));
					chain(map.getTile(index).getAdjacent(num), index, contains,
							height, dice, ++dicePosition, --length);
				}
			}
		}

	}

	public void chain(int x, int y, int length, double elevation, int current,
			int prevIndex) {
		// Deprecated
		Random dice = new Random();
		map.getTile(x, y).setHeight(elevation);

		int index = (x * this.x) + y;
		if (current <= length) {
			if (x != 0 && y != 0 && x != (z - 1) && y != (x - 1)) {
				if (map.getTile(x, y).getUp() == true) {
					int tempDecide = dice.nextInt(2);
					if ((prevIndex - 1) == index) {
						if (tempDecide <= 1)
							chain(x, y - 1, length, elevation, current + 1,
									index);
						else
							chain(x - 1, y, length, elevation, current + 1,
									index);
					} else if (prevIndex + 1 == index) {
						if (tempDecide <= 1)
							chain(x, y + 1, length, elevation, current + 1,
									index);
						else
							chain(x - 1, y, length, elevation, current + 1,
									index);
					} else {
						if (tempDecide <= 1)
							chain(x, y - 1, length, elevation, current + 1,
									index);
						else
							chain(x, y + 1, length, elevation, current + 1,
									index);
					}
				} else {
					int tempDecide = dice.nextInt(2);
					if ((prevIndex - 1) == index) {
						if (tempDecide <= 1)
							chain(x, y - 1, length, elevation, current + 1,
									index);
						else
							chain(x + 1, y, length, elevation, current + 1,
									index);
					} else if (prevIndex + 1 == index) {
						if (tempDecide <= 1)
							chain(x, y + 1, length, elevation, current + 1,
									index);
						else
							chain(x + 1, y, length, elevation, current + 1,
									index);
					} else {
						if (tempDecide <= 1)
							chain(x, y - 1, length, elevation, current + 1,
									index);
						else
							chain(x, y + 1, length, elevation, current + 1,
									index);
					}
				}
			}
		}
	}

	public int getx() {
		return x;
	}

	public void setx(int x) {
		this.x = x;
	}

	public int getz() {
		return z;
	}

	public void setz(int z) {
		this.z = z;
	}

	public double getFaultOne() {
		return faultOne;
	}

	public double getFaultTwo() {
		return faultTwo;
	}

	public void setFaultOne(double faultOne) {
		this.faultOne = faultOne;
	}

	public void setFaultTwo(double faultTwo) {
		this.faultTwo = faultTwo;
	}

	public double getMaxElevation() {
		return maxElevation;
	}

	public void setMaxElevation(double maxElevation) {
		this.maxElevation = maxElevation;
	}

}
