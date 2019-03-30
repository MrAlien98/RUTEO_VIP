package tours;

public class Main {
	
	Nodo[] nodos;
	Tour[] tours;
	double[][] save;
	
	public Main() {
		save=new double[5][5];
		nodos=new Nodo[5];
		tours=new Tour[5];
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
	
	public Tour[] m1(Tour[] tours1) {
		double[][] saves=new double[tours1.length][tours1.length];
		for(int i=0;i<saves.length;i++) {
			for(int j=0;i<saves[i].length;j++) {
				saves[i][j]=distances(tours1[i].getT1()[0], tours1[j].getT1()[tours1[j].getT1().length-1]);
			}
		}
		double max=0;
		int px=0;
		int py=0;
		for(int i=0;i<saves.length;i++) {
			for(int j=0;i<saves[i].length;j++) {
				if(saves[i][j]>max){
					max=saves[i][j];
					px=i;
					py=j;
				}
			}
		}
		Tour[] t=new Tour[tours1[px].getT1().length + tours1[py].getT1().length];
		for(int i=0;i<tours.length;i++) {
			if(i==px || i==py) {
				t[i]=tours[i];
			}
		}
		return t;
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

//Primero-ultimo
	public Tour saveMethod1(Tour[] a) {
		Double MaxSave=Double.MAX_VALUE;
		Nodo prim;
		Nodo ult;
		Nodo candidato1=null;;
		Nodo candidato2=null;;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		if(a==null) {
			System.out.println("Lo siento pero, no has ingresado nada");
			return null;
		}else {
			for(int i=0; i<a.length;i++) {
				prim=a[i].getT1()[0];
				for(int j=1; j<a.length;j++) {
					ult=a[i].getT1()[a[j].getT1().length-1];
					System.out.println(prim.posX+","+prim.posY+"  "+ult.posX+","+ult.posY);
					temp=distances(ult,prim);
					if(MaxSave > temp) {
						MaxSave=temp;
						candidato1=prim;
						candidato2=ult;
						candi1Pos=i;
						candi2Pos=j;					
					}	
				}
//				if(a[i+1].getT1().length==1) {
//					ult=prim;
//				}else {
//					ult=a[i].getT1()[a[i].getT1().length-1];
//				}			
			}
			System.out.println("("+candidato1.getPosX()+","+candidato1.getPosY()+") ("+candidato2.getPosX()+","+candidato2.getPosY()+") : "+ MaxSave+ "   "+ candi1Pos +"," +candi2Pos );
		}
		return null;		
	}
	
//Primero-primero	
	public Tour saveMethod2() {
		return null;
	}
//ultimo-primero	
	public Tour saveMethod3() {
		return null;
	}
//ultimo-ultimo	
	public Tour saveMethod4() {
		return null;
	}
	
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
		Main m=new Main();
		Tour[] t=new Tour[5];
		Nodo[] t1=new Nodo[5];
		for(int i=0;i<t.length;i++) {
			int c=4;
			while(c>=0) {
				t1[c]=new Nodo((int) (1+Math.random()*10), (int) (1+Math.random()*10));
				c--;
			}
			t[i]=new Tour(5);
			t[i].setT1(t1);
		}
		m.saveMethod1(t);
	}
	
}
