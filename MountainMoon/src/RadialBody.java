// Circular body that grows outward at a rate
public class RadialBody {
	private float radius;
	private String type;
	private int id;
	private float rate;

	public RadialBody(float radius, String type, int id, float rate) {
		super();
		this.radius = radius;
		this.type = type;
		this.id = id;
		this.rate = rate;
	}

	public float grow(int x) {
		// increases the radius of the body by the rate x times
		radius += (x * rate);
		return radius;
	}

	public float grow() {
		// increases the radius of the body by the rate once
		radius += rate;
		return radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
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

}
