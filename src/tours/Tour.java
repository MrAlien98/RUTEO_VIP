package tours;

import java.util.ArrayList;

public class Tour{
	
	ArrayList<Node> nodes;
	boolean taken;

	public Tour() {
		nodes=new ArrayList<Node>();
	}
	
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
	public ArrayList<Node> getNodes(){
		return nodes;
	}
	
	public void setNodos(ArrayList<Node> t) {
		this.nodes=t;
	}
	
}
