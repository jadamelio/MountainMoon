import java.util.ArrayList;

//Parent class for all tiles, rectangular constructed out of 8 nodes


public class Tile
{
private int index;
private ArrayList<Integer> adjacentTile = new ArrayList<Integer>();
private CoordPac[][] nodes = new CoordPac[3][3];
private String type;
private int typeID;
private ArrayList<Chord> chords = new ArrayList<Chord>();
private ArrayList<RadialBody> bodies = new ArrayList<RadialBody>();



public Tile(int index, ArrayList<Integer> adjacentTile, CoordPac[][] nodes,
    String type, int typeID, ArrayList<Chord> chords,
    ArrayList<RadialBody> bodies)
{
  super();
  this.index = index;
  this.adjacentTile = adjacentTile;
  this.nodes = nodes;  
  this.type = type;
  this.typeID = typeID;
  this.chords = chords;
  this.bodies = bodies;
}
public int getIndex()
{
  return index;
}
public void setIndex(int index)
{
  this.index = index;
}
public ArrayList<Integer> getAdjacentTile()
{
  return adjacentTile;
}
public void setAdjacentTile(ArrayList<Integer> adjacentTile)
{
  this.adjacentTile = adjacentTile;
}
public CoordPac[][] getNodes()
{
  return nodes;
}
public void setNodes(CoordPac[][] nodes)
{
  this.nodes = nodes;
}
public String getType()
{
  return type;
}
public void setType(String type)
{
  this.type = type;
}
public int getTypeID()
{
  return typeID;
}
public void setTypeID(int typeID)
{
  this.typeID = typeID;
}
public ArrayList<Chord> getChords()
{
  return chords;
}
public void setChords(ArrayList<Chord> chords)
{
  this.chords = chords;
}
public ArrayList<RadialBody> getBodies()
{
  return bodies;
}
public void setBodies(ArrayList<RadialBody> bodies)
{
  this.bodies = bodies;
}


}
