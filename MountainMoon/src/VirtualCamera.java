public class VirtualCamera {

	private CoordPac origin;
	private CoordPac bottomright;
	private double width;
	private double angle;
	private double tiltAngle;

	public VirtualCamera() {

	}

	
	public CoordPac setTopRight(){
		
		
		
		return new CoordPac();
	}
	
	public CoordPac getOrigin() {
		return origin;
	}

	public void setOrigin(CoordPac origin) {
		this.origin = origin;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}


	public double getTiltAngle() {
		return tiltAngle;
	}


	public void setTiltAngle(double tiltAngle) {
		this.tiltAngle = tiltAngle;
	}

}
