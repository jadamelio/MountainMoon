// Circular body that grows outward at a rate
public class RadialBody
{
private int radius;
private String type;
private int id;



public RadialBody(int radius, String type, int id)
{
  super();
  this.radius = radius;
  this.type = type;
  this.id = id;
}

public int getRadius()
{
  return radius;
}
public void setRadius(int radius)
{
  this.radius = radius;
}
public String getType()
{
  return type;
}
public void setType(String type)
{
  this.type = type;
}
public int getId()
{
  return id;
}
public void setId(int id)
{
  this.id = id;
}

}
