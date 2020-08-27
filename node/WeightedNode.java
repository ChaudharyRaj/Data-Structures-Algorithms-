package node;
import java.util.*;
import mst.*;
public class WeightedNode implements Comparable<WeightedNode>{
	public String name;
	
	private ArrayList<WeightedNode> neigbhors = new ArrayList<WeightedNode>();
	private HashMap<WeightedNode, Integer> weigthMap = new HashMap<WeightedNode, Integer>();
	private boolean isVisited = false;
	private WeightedNode parent;
	private int distance;
	private DisjointSet set;
	public WeightedNode(String name){
		this.name = name;
		distance = Integer.MAX_VALUE;
	}
	
	public DisjointSet getSet() {
		return set;
	}
	public void setSet(DisjointSet set) {
		this.set = set;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public ArrayList<WeightedNode> getNeigbhors(){
		return neigbhors;
	}
	
	public void setNaigbhors(ArrayList<WeightedNode> neigbhors){
		this.neigbhors = neigbhors;
	}
	
	public HashMap<WeightedNode, Integer> getWeightMap(){
		return weigthMap;
	}
	
	public void setWeightMap(HashMap<WeightedNode, Integer> weightMap){
		this.weigthMap = weightMap;
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	
	public void setVisited(boolean isVisited){
		this.isVisited = isVisited;
	}
	
	public WeightedNode getParent() {
		return parent;
	}
	
	public void setParent(WeightedNode parent) {
		this.parent = parent;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(WeightedNode o){
		return this.distance - o.distance;
	}
}
