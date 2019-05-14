package tours;

public class Triforce <V, PN, SN>{

	private V savings;
	private PN firstNode;
	private SN secondNode;
	
	public Triforce(V ahorro, PN primerNodo, SN segundoNodo) {
		this.savings = ahorro;
		this.firstNode = primerNodo;
		this.secondNode = segundoNodo;
	}
	
	public V getSavings() {
		return savings;
	}
	public void setSavings(V ahorro) {
		this.savings = ahorro;
	}
	public PN getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(PN primerNodo) {
		this.firstNode = primerNodo;
	}
	public SN getSecondNode() {
		return secondNode;
	}
	public void setSecondNode(SN segundoNodo) {
		this.secondNode = segundoNodo;
	}
	
	
	
	
	
}
