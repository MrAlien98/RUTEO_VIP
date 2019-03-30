package tours;

public class Main {
	class Nodo{
		int posX;
		int posY;
		public Nodo() {}
		public int getPosX() {
			return posX;
		}
		public void setPosX(int posX) {
			this.posX = posX;
		}
		public int getPosY() {
			return posY;
		}
		public void setPosY(int posY) {
			this.posY = posY;
		}
	}
	class Tour{		
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
	
	Nodo[] nodos;
	Tour[] tours;
	double[][] save;
	
	public Main(int size) {
		save=new double[size][size];
		nodos=new Nodo[size];
		tours=new Tour[size];
		for(int i=0;i<tours.length;i++) {
			tours[i]=new Tour(tours.length);
		}
	}
	
	public void initialize() {
		for(int i=0;i<tours.length;i++) {
			nodos[i].setPosX(1+(int)Math.random()*9);
			nodos[i].setPosY(1+(int)Math.random()*9);
		}
	}
	
	public Nodo[] m1(Nodo[] tours) {
		int[][] ahorros=new int[tours.length][tours.length];
		for(int i=0;i<ahorros.length;i++) {
			for(int j=0;j<ahorros[i].length;j++) {
				
			}
		}
		return null;
	}

	public Nodo[] m2(Nodo[] tours) {
		return null;
	}

	public Nodo[] m3(Nodo[] tours) {
		return null;
	}

	public Nodo[] m4(Nodo[] tours) {
		return null;
	}

//	public void mayorAh() {
//		Nodo[] m1=m1();
//		Nodo[] m2
//		Nodo[] m3
//		Nodo[] m4
//	}
	
	public double distances(Nodo n0, Nodo n1) {
		double dX=n1.getPosX()-n0.getPosX();
		double dY=n1.getPosY()-n0.getPosY();;
		return Math.sqrt( (Math.pow(dX,2)) + (Math.pow(dY,2)) );
	}
	
	public Nodo[] getNodos() {
		return nodos;
	}
	
	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}
	
	public Tour[] getTours() {
		return tours;
	}
	
	public void setTours(Tour[] tours) {
		this.tours = tours;
	}
	
	public static void main(String[] args) {
		
	}
	
	public void �o() {
//	
//		private Node[] cheapestTour;
//	
//		class Node {
//			int x;
//			int y;
//			Node connectForward;
//			Node connectBack;
//			Node first;
//			
//			public Node(int x, int y) {
//				this.x=x;
//				this.y=y;
//			}
//			
//			public void setX(int x) {
//				this.x=x;
//			}
//			
//			public void setY(int y) {
//				this.y=y;
//			}
//			
//			public int getX() {
//				return x;
//			}
//			
//			public int getY() {
//				return y;
//			}
//			
//			public Node getConnectF() {
//				return connectForward;
//			}
//			
//			public void setConnectF(Node connectForward) {
//				this.connectForward=connectForward;
//			}
//			
//			public Node getConnectB() {
//				return connectBack;
//			}
//			
//			public void setConnectB(Node connectBack) {
//				this.connectForward=connectBack;
//			}
//		}
//	
//		public class Tour{
//			Node[] t1;
//			
//			Tour(int size){
//				t1=new Node[size];
//			}
//
//			public Node[] getT1() {
//				return t1;
//			}
//			
//			public void setT1(Node[] t1) {
//				this.t1=t1;
//			}
//			
//		}
//	
//		private Node[] nodes;
//		private Tour[] tours;
//	
//		private double[][] saving;
//	
//		public Main() {
//			setMat(new Node[5]);
//			setWarded(new Tour[5]);
//			setSaving(new double[5][5]);
//			initialize();
//		}
//	
//		/**
//		 * @return the mat
//		 */
//		public Node[] getMat() {
//			return nodes;
//		}
//
//		/**
//		 * @param mat the mat to set
//		 */
//		public void setMat(Node[] nodes) {
//			this.nodes = nodes;
//		}
//
//		/**
//		 * @return the saving
//		 */
//		public double[][] getSaving() {
//			return saving;
//		}
//
//		/**
//		 * @param saving the saving to set
//		 */
//		public void setSaving(double[][] saving) {
//			this.saving = saving;
//		}
//
//		/**
//		 * @return the cheapestTour
//		 */
//		public Node[] getCheapestTour() {
//			return cheapestTour;
//		}
//
//		/**
//		 * @param cheapestTour the cheapestTour to set
//		 */
//		public void setCheapestTour(Node[] cheapestTour) {
//			this.cheapestTour = cheapestTour;
//		}
//	
//		/**
//		 * @return the warded
//		 */
//		public Tour[] getWarded() {
//			return tours;
//		}
//
//		/**
//		 * @param warded the warded to set
//		 */
//		public void setWarded(Tour[] tours) {
//			this.tours=tours;
//		}
//
//		public void initialize() {
//			for(int i=0;i<saving.length;i++) {
//				for(int j=0;j<saving[i].length;j++) {
//					saving[i][j]=-99999;
//				}
//			}
//			for(int i=0;i<saving.length;i++) {
//				int x=(int) (Math.random()*20)+1;
//				int y=(int) (Math.random()*20)+1;
//				nodes[i]=new Node(x,y);
//			}
//			calculateSave();
//		}
//	
//		public void joinTours1() {
//			for(int i=1;i<nodes.length;i++) {
//				nodes[0].setConnectF(nodes[i]);
//				nodes[i].setConnectB(nodes[0]);
//			}
//		}
//	
//		public void calculateSave() {
//			for(int i=0;i<nodes.length;i++) {
//				for(int j=0;j<nodes.length;j++) {
//					if(i!=j) {
//						double save=distances(nodes[j].getX(), nodes[j].getY(), nodes[i].getX(), nodes[i].getY());
//						saving[i][j]=save;
//					}
//				}
//			}
//		}
//	
//		public double distances(int x1, int y1, int x2, int y2) {
//			double dX=x2-x1;
//			double dY=y2-y1;
//			return Math.sqrt( (Math.pow(dX,2)) + (Math.pow(dY,2)) );
//		}
//	
//		public double save(Node a, Node b, Node c, Node d) {
//			double s1=distances(a.getX(), a.getY(), c.getX(), c.getY());
//			double s2=distances(a.getX(), a.getY(), d.getX(), d.getY());
//			double s3=distances(b.getX(), b.getY(), c.getX(), c.getY());
//			double s4=distances(a.getX(), a.getY(), d.getX(), d.getY());
//			double[] menor= {s1, s2, s3, s4};
//			int iMenor = 0;
//		    for(int i=1;i<menor.length;i++){
//		    	if(menor[i]<menor[iMenor]) {
//		    		iMenor = i;
//		    	}
//		    }
//		    return menor[iMenor];
//		}
//	
//		public static void main(String[] args) {
//			Main m=new Main();
//			String eje="";
//			String arr="";
//			
//			for (int i=0;i<m.getMat().length;i++) {
//				arr+="("+m.getMat()[i].getX()+","+m.getMat()[i].getY()+")";
//			}
//			
//			for(int i=0;i<m.getSaving().length;i++) {
//				for(int j=0;j<m.getSaving()[i].length;j++) {
//					eje+=m.getSaving()[i][j]+"\t";
//				}
//				eje+="\n";
//			}
//			System.out.println(eje);
//			System.out.println(arr);
//		}
//
	}
}
