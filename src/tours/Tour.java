package tours;

public class Tour{
	
	Nodo[] t1;
	public Tour(int size) {
		t1=new Nodo[size];
	}
	public Nodo[] getT1() {
		return t1;
	}
	public void setT1(Nodo[] t1) {
		this.t1 = t1;
	}
}
