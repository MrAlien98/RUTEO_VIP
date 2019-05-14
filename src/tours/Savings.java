package tours;

import java.util.ArrayList;
import java.util.Stack;

public class Savings {
	
	ArrayList<Node> nodes;
	ArrayList<Tour> tours;
	Node referenceNode;
	
	public Savings() {
		nodes=new ArrayList<>();
		tours=new ArrayList<>();
		referenceNode=null;
	}
	
	public void createTours() {
		for(int i=1;i<nodes.size();i++) {
			Tour newT=new Tour();
			ArrayList<Node> arr=new ArrayList<>();
			arr.add(nodes.get(i));
			newT.setNodos(arr);
			tours.add(newT);
		}
		joinTours();
	}
	
	public ArrayList<Node> reverseArrayList(ArrayList<Node> a){
		Stack<Node> b=new Stack<>();
		for(int i=0;i<a.size();i++) {
			b.push(a.get(i));
		}
		a.clear();
		for(int i=0;!b.isEmpty();i++) {
			a.add(i, b.pop());
		}
		return a;
	}
	
	public void joinTours() {
		Triforce<Double, Integer, Integer> s1=saveMethodFF(getTours());
		Triforce<Double, Integer, Integer> s2=saveMethodFL(getTours());
		Triforce<Double, Integer, Integer> s3=saveMethodLF(getTours());
		Triforce<Double, Integer, Integer> s4=saveMethodLL(getTours());
		double gS=greaterSave(s1.getSavings(), s2.getSavings(), s3.getSavings(), s4.getSavings());
		if(gS==s1.getSavings()) {
			joinToursFF(s1.getFirstNode(), s1.getSecondNode());
		}else if(gS==s2.getSavings()) {
			joinToursFF(s2.getFirstNode(), s2.getSecondNode());
		}else if(gS==s3.getSavings()) {
			joinToursFF(s3.getFirstNode(), s3.getSecondNode());
		}else if(gS==s4.getSavings()) {
			joinToursFF(s4.getFirstNode(), s4.getSecondNode());
		}
		if(getTours().size()>1) {
			joinTours();
		}else {
			endGame();
		}
	}
	
	public void endGame() {
		ArrayList<Node> finalTour=new ArrayList<>();
		finalTour.add(referenceNode);
		for(int i=0;i<getTours().get(0).getNodes().size();i++) {
			finalTour.add(getTours().get(0).getNodes().get(i));
		}
		finalTour.add(referenceNode);
		getTours().get(0).setNodos(finalTour);
		String aja="";
		for(int i=0;i<getTours().get(0).getNodes().size();i++) {
			aja+="("+getTours().get(0).getNodes().get(i).toString()+") ";
		}
		System.out.println(aja);
	}
	
	public void cleanTaken(ArrayList<Tour> a) {
		for(int i=0;i<a.size();i++) {
			a.get(i).setTaken(false);
		}
	}
	
	public void joinToursFF(int x, int y) {
		ArrayList<Tour> newTours=new ArrayList<>();
		ArrayList<Node> joinedTour=new ArrayList<>();
		getTours().get(x).setNodos((reverseArrayList(getTours().get(x).getNodes())));
		for(int i=0;i<getTours().get(x).getNodes().size();i++) {
			joinedTour.add(getTours().get(x).getNodes().get(i));
		}
		int c=0;
		for(int i=0;i<getTours().get(y).getNodes().size();i++) {
			joinedTour.add(getTours().get(y).getNodes().get(c));
			c++;
		}
		String aja="";
		for(int i=0;i<joinedTour.size();i++) {
			aja+=joinedTour.get(i).toString()+" ";
		}
		System.out.println(aja);
		Tour tU=new Tour();
		tU.setNodos(joinedTour);
		for(int i=0;i<getTours().size();i++) {
			if(!getTours().get(i).isTaken()) {
				if(i==x) {
					newTours.add(tU);
					getTours().get(x).setTaken(true);
					getTours().get(y).setTaken(true);
				}else {
					newTours.add(getTours().get(i));
					getTours().get(i).setTaken(true);
				}
			}
		}
		cleanTaken(newTours);
		setTours(newTours);
	}
	
	public void joinToursFL(int x, int y) {
		ArrayList<Tour> newTours=new ArrayList<>();
		ArrayList<Node> joinedTours=new ArrayList<>();
		getTours().get(x).setNodos((reverseArrayList(getTours().get(x).getNodes())));
		getTours().get(y).setNodos((reverseArrayList(getTours().get(y).getNodes())));
		for(int i=0;i<getTours().get(x).getNodes().size();i++) {
			joinedTours.add(getTours().get(x).getNodes().get(i));
		}
		int c=0;
		for(int i=0;i<getTours().get(y).getNodes().size();i++) {
			joinedTours.add(getTours().get(y).getNodes().get(c));
			c++;
		}
		Tour tU=new Tour();
		tU.setNodos(joinedTours);
		for(int i=0;i<getTours().size();i++) {
			if(!getTours().get(i).isTaken()) {
				if(i==x) {
					newTours.add(tU);
					getTours().get(x).setTaken(true);
					getTours().get(y).setTaken(true);
				}else {
					newTours.add(getTours().get(i));
					getTours().get(i).setTaken(true);
				}
			}
		}
		cleanTaken(newTours);
		setTours(newTours);
	}

	public void joinToursLL(int x, int y) {
		ArrayList<Tour> newTours=new ArrayList<>();
		ArrayList<Node> joinedTours=new ArrayList<>();
		getTours().get(y).setNodos((reverseArrayList(getTours().get(y).getNodes())));
		for(int i=0;i<getTours().get(x).getNodes().size();i++) {
			joinedTours.add(getTours().get(x).getNodes().get(i));
		}
		int c=0;
		for(int i=0;i<getTours().get(y).getNodes().size();i++) {
			joinedTours.add(getTours().get(y).getNodes().get(c));
			c++;
		}
		Tour tU=new Tour();
		tU.setNodos(joinedTours);
		for(int i=0;i<getTours().size();i++) {
			if(!getTours().get(i).isTaken()) {
				if(i==x) {
					newTours.add(tU);
					getTours().get(x).setTaken(true);
					getTours().get(y).setTaken(true);
				}else {
					newTours.add(getTours().get(i));
					getTours().get(i).setTaken(true);
				}
			}
		}
		cleanTaken(newTours);
		setTours(newTours);
	}

	public void joinToursLF(int x, int y) {
		ArrayList<Tour> newTours=new ArrayList<>();
		ArrayList<Node> joinedTours=new ArrayList<>();
		for(int i=0;i<getTours().get(x).getNodes().size();i++) {
			joinedTours.add(getTours().get(x).getNodes().get(i));
		}
		int c=0;
		for(int i=0;i<getTours().get(y).getNodes().size();i++) {
			joinedTours.add(getTours().get(y).getNodes().get(c));
			c++;
		}
		Tour tU=new Tour();
		tU.setNodos(joinedTours);
		for(int i=0;i<getTours().size();i++) {
			if(!getTours().get(i).isTaken()) {
				if(i==x) {
					newTours.add(tU);
					getTours().get(x).setTaken(true);
					getTours().get(y).setTaken(true);
				}else {
					newTours.add(getTours().get(i));
					getTours().get(i).setTaken(true);
				}
			}
		}
		cleanTaken(newTours);
		setTours(newTours);
	}
	
	public double greaterSave(double a, double b, double c, double d) {
		double[] saves= {a, b, c, d};
		double bigger=0;
		for(int i=0;i<saves.length;i++) {
			if(saves[i]>bigger) {
				bigger=saves[i];
			}
		}
		return bigger;
	}
	
	/**
	 * Primero, Primero
	 * @param a
	 * @return
	 */
	public Triforce<Double, Integer, Integer> saveMethodFF(ArrayList<Tour> a) {
		Node f1, f2=null;
		int c1=0;
		int c2=0;
		double maxSave=Double.MAX_VALUE;
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.size();j++) {
				if(i!=j) {
					f1=a.get(i).getNodes().get(0);
					f2=a.get(j).getNodes().get(0);
					double distance1=distances(f1, referenceNode);
					double distance2=distances(f2, referenceNode);
					double distance3=distances(f1, f2);
					double actualSave=distance1+distance2-distance3;
					if(actualSave<maxSave) {
						maxSave=actualSave;
						c1=i;
						c2=j;
					}
				}
			}
		}
		return new Triforce<>(maxSave, c1, c2);
	}
	
	/**
	 * Primero - Ultimo
	 * First - Last
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public Triforce<Double, Integer, Integer> saveMethodFL(ArrayList<Tour> a) {
		Node f1, f2=null;
		int c1=0;
		int c2=0;
		double maxSave=Double.MAX_VALUE;
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.size();j++) {
				if(i!=j) {
					f1=a.get(i).getNodes().get(0);
					f2=a.get(j).getNodes().get(a.get(j).getNodes().size()-1);
					double d1=distances(f1, referenceNode);
					double d2=distances(f2, referenceNode);
					double d3=distances(f1, f2);
					double actualSave=(d1+d2)-d3;
					if(actualSave<maxSave) {
						maxSave=actualSave;
						c1=i;
						c2=j;
					}
				}
			}
		}
		return new Triforce<>(maxSave, c1, c2);
	}
	
	/**
	 * Ultimo Primero
	 * Last First
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public Triforce<Double, Integer, Integer> saveMethodLF(ArrayList<Tour> a) {
		Node f1, f2=null;
		int c1=0;
		int c2=0;
		double maxSave=Double.MAX_VALUE;
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.size();j++) {
				if(i!=j) {
					f1=a.get(i).getNodes().get(a.get(i).getNodes().size()-1);
					f2=a.get(j).getNodes().get(0);
					double distance1=distances(f1, referenceNode);
					double distance2=distances(f2, referenceNode);
					double distance3=distances(f1, f2);
					double actualSave=distance1+distance2-distance3;
					if(actualSave<maxSave) {
						maxSave=actualSave;
						c1=i;
						c2=j;
					}
				}
			}
		}
		return new Triforce<>(maxSave, c1, c2);				
	}

	/**
	 * Ultimo - Ultimo
	 * Last - Last
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public Triforce<Double, Integer, Integer> saveMethodLL(ArrayList<Tour> a) {
		Node f1, f2=null;
		int c1=0;
		int c2=0;
		double maxSave=Double.MAX_VALUE;
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.size();j++) {
				if(i!=j) {
					f1=a.get(i).getNodes().get(a.get(i).getNodes().size()-1);
					f2=a.get(j).getNodes().get(a.get(j).getNodes().size()-1);
					double distance1=distances(f1, referenceNode);
					double distance2=distances(f2, referenceNode);
					double distance3=distances(f1, f2);
					double actualSave=distance1+distance2-distance3;
					if(actualSave<maxSave) {
						maxSave=actualSave;
						c1=i;
						c2=j;
					}
				}
			}
		}
		return new Triforce<>(maxSave, c1, c2);
	}
	
	public double distances(Node n0, Node n1) {
		double dX=n1.getPosX()-n0.getPosX();
		double dY=n1.getPosY()-n0.getPosY();;
		return Math.sqrt( (Math.pow(dX,2)) + (Math.pow(dY,2)) );
	}
	
	/**
	 * @return the ns1
	 */
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	/**
	 * @param ns1 the ns1 to set
	 */
	public void setNodes(ArrayList<Node> nodos) {
		this.nodes=nodos;
		referenceNode=nodos.get(0);
		createTours();
	}

	/**
	 * @return the ts1
	 */
	public ArrayList<Tour> getTours() {
		return tours;
	}

	/**
	 * @param ts1 the ts1 to set
	 */
	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}

	public Node getOrigin() {
		return referenceNode;
	}
	
	public static void main(String[] args) {
		Savings m=new Savings();
		ArrayList<Node> nodes=new ArrayList<>();
		nodes.add(new Node(10,2));
		nodes.add(new Node(1,5));
		nodes.add(new Node(4,6));
		nodes.add(new Node(3,9));
		nodes.add(new Node(0,7));
		nodes.add(new Node(4,4));
		nodes.add(new Node(11,3));
		nodes.add(new Node(12,6));
		nodes.add(new Node(1,9));
		nodes.add(new Node(12,15));
		nodes.add(new Node(1,21));
		nodes.add(new Node(21,13));
		nodes.add(new Node(8,2));
		nodes.add(new Node(32,4));
		nodes.add(new Node(6,18));
		m.setNodes(nodes);
	}
	
}
