package tours;

import java.util.ArrayList;

public class Tour{
	
	Nodo[] t1;
	ArrayList<Nodo> t;
	public Tour(int size) {
		t=new ArrayList<Nodo>();
		t1=new Nodo[size];
	}
	
	public Nodo[] getT1() {
		return t1;
	}
	
	public void setT1(Nodo[] t1) {
		this.t1 = t1;
	}
	
	public ArrayList<Nodo> getT(){
		return t;
	}
	
	public void setT(ArrayList<Nodo> t) {
		this.t=t;
	}
}
