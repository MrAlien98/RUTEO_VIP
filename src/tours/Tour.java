package tours;

import java.util.ArrayList;

public class Tour{
	
	ArrayList<Nodo> nodos;
	boolean taken;

	public Tour() {
		nodos=new ArrayList<Nodo>();
	}
	
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
	public ArrayList<Nodo> getNodos(){
		return nodos;
	}
	
	public void setNodos(ArrayList<Nodo> t) {
		this.nodos=t;
	}
	
}
