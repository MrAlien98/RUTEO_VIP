package tours;

public class Main {

	
	Nodo[] nodos;
	Tour[] tours;
	double[][] save;
	
	public Main(int s) {
		save=new double[s][s];
		nodos=new Nodo[s];
		tours=new Tour[s];
		for(int i=0;i<tours.length;i++) {
			tours[i]=new Tour(tours.length);
		}
	}
	
	public void verrNodos() {
		for (int i = 0; i < nodos.length; i++) {
			System.out.println(nodos[i].toString());
		}
	}
	
	public void joinToursOnce() {
		Tour[] newTours=new Tour[tours.length-1];
		for(int i=0;i<newTours.length;i++) {
			newTours[i]=new Tour(tours.length);
		}
		for(int i=0;i<tours.length-1;i++) {
			Nodo[] a= {nodos[0], nodos[i+1]};
			newTours[i].setT1(a);
		}
		setTours(newTours);
		joinTours();
	}
	
	public void joinTours() {
		String s1=saveMethod1(tours);
		String s2=saveMethod2(tours);
		String s3=saveMethod3(tours);
		String s4=saveMethod4(tours);
		
		String[] s1a=s1.split("/");
		String[] s2a=s2.split("/");
		String[] s3a=s3.split("/");
		String[] s4a=s4.split("/");
		
		double save1=Double.parseDouble(s1a[0]);
		double save2=Double.parseDouble(s2a[0]);
		double save3=Double.parseDouble(s3a[0]);
		double save4=Double.parseDouble(s4a[0]);
		
		double max=greaterSave(save1, save2, save3, save4);
		
		if(max==save1) {
			joinToursFF(Integer.parseInt(s1a[1]), Integer.parseInt(s1a[2]));
		}else if(max==save2){
			joinToursFL(Integer.parseInt(s2a[1]), Integer.parseInt(s2a[2]));
		}else if(max==save3) {
			joinToursLL(Integer.parseInt(s3a[1]), Integer.parseInt(s3a[2]));
		}else {
			joinToursLF(Integer.parseInt(s4a[1]), Integer.parseInt(s4a[2]));
		}
		String aja="";
		for(int i=0;i<getTours().length;i++) {
			for(int j=0;j<getTours()[i].getT1().length;j++) {
				aja+=tours[i].getT1()[j].toString()+" ";
			}
			aja+="\n";
		}
		System.out.println(aja);
		while(tours.length>1) {
			joinTours();
		}
	}
	
	/**
	 * Primero - Primero
	 * First First
	 * @param x indice del primer tour
	 * @param y indice del segundo tour
	 */
	public void joinToursFF(int x, int y) {
		Tour[] ts=new Tour[tours.length-1];
		Nodo[] ns=new Nodo[tours[x].getT1().length+tours[y].getT1().length];
		Nodo[] a=tours[x].getT1();
		for(int i=a.length;i<=0;i--) {
			ns[i]=a[i-1];
		}
		int c=0;
		for(int i=tours[x].getT1().length;i<ns.length;i++) {
			ns[i]=tours[y].getT1()[c];
			c++;
		}
		for(int i=0;i<tours.length;i++) {
			if(x==tours.length-1) {
				ts[i].setT1(ns);
				ts[i+1]=tours[i];
				x--;
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else if(i==y) {
					if(i+1<tours.length) {
						ts[i]=tours[i+1];
					}
				}else {
					ts[i]=tours[i];
				}
			}
		}
		setTours(ts);
	}
	
	/**
	 * Primero - Ultimo
	 * First Last
	 * @param x indice del primer tour
	 * @param y indice del segundo tour
	 */
	public void joinToursFL(int x, int y) {
		Tour[] ts=new Tour[tours.length-1];
		Nodo[] ns=new Nodo[tours[x].getT1().length+tours[y].getT1().length];
		Nodo[] a=tours[x].getT1();
		Nodo[] b=tours[y].getT1();
		for(int i=a.length;i<=0;i--) {
			ns[i]=a[i-1];
		}
		int c=0;
		for(int i=tours[x].getT1().length;i<ns.length;i++) {
			ns[i]=b[c];
			c++;
		}
		for(int i=0;i<tours.length;i++) {
			if(x==tours.length-1) {
				ts[i].setT1(ns);
				ts[i+1]=tours[i];	
				x--;
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else if(i==y) {
					if(i+1<tours.length) {
						ts[i]=tours[i+1];
					}
				}else {
					ts[i]=tours[i];
				}
			}
		}
		setTours(ts);
	}

	/**
	 * Ultimo - Ultimo
	 * Last Last
	 * @param x indice del primer tour
	 * @param y indice del segundo tour
	 */
	public void joinToursLL(int x, int y) {
		Tour[] ts=new Tour[tours.length-1];
		Nodo[] ns=new Nodo[tours[x].getT1().length+tours[y].getT1().length];
		Nodo[] a=tours[x].getT1();
		Nodo[] b=tours[y].getT1();
		for(int i=0;i<a.length;i++) {
			ns[i]=a[i];
		}
		int c=0;
		for(int i=tours[x].getT1().length;i<ns.length;i++) {
			ns[i]=b[c];
			c++;
		}
		for(int i=0;i<tours.length;i++) {
			if(x==tours.length-1) {
				ts[i].setT1(ns);
				ts[i+1]=tours[i];	
				x--;
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else if(i==y) {
					if(i+1<tours.length) {
						ts[i]=tours[i+1];
					}
				}else {
					ts[i]=tours[i];
				}
			}
		}
		setTours(ts);
	}

	/**
	 * Ultimo - Primero
	 * Last First
	 * @param x indice del primer tour
	 * @param y indice del segundo tour
	 */
	public void joinToursLF(int x, int y) {
		Tour[] ts=new Tour[tours.length-1];
		Nodo[] ns=new Nodo[tours[x].getT1().length+tours[y].getT1().length];
		Nodo[] a=tours[x].getT1();
		Nodo[] b=tours[y].getT1();
		for(int i=0;i<a.length;i++) {
			ns[i]=a[i];
		}
		int c=0;
		for(int i=a.length;i<ns.length;i++) {
			ns[i]=b[c];
			c++;
		}
		for(int i=0;i<tours.length;i++) {
			if(x==tours.length-1) {
				ts[i].setT1(ns);
				ts[i+1]=tours[i];	x--;
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else if(i==y) {
					if(i+1<tours.length) {
						ts[i]=tours[i+1];
					}
				}else {
					ts[i]=tours[i];
				}
			}
		}
		setTours(ts);
	}
	
	public double greaterSave(double a, double b, double c, double d) {
		double[] saves= {a, b, c, d};
		double mayor=0;
		for(int i=0;i<saves.length;i++) {
			if(saves[i]>mayor) {
				mayor=saves[i];
			}
		}
		return mayor;
	}
	
	/**
	 * Primero - Primero
	 * First First
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public String saveMethod1(Tour[]a) {
		Double MaxSave=Double.MAX_VALUE;
		Nodo prim;
		Nodo prim2;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		double temp2;
		double temp3;
		if(a==null) {
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				prim=a[i].getT1()[0];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {
						prim2=a[j].getT1()[0];
						temp=distances(prim, a[i].getT1()[a[i].getT1().length-1]);
						temp3=distances(prim2,prim2);
						if(MaxSave > temp) {
							MaxSave=temp;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
		}
		return ""+MaxSave+"/"+candi1Pos+"/"+candi2Pos;
	}
	
	/**
	 * Primero - Ultimo
	 * First - Last
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public String saveMethod2(Tour []a) {
		Double MaxSave=Double.MAX_VALUE;
		Nodo prim;
		Nodo ult;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		if(a==null) {
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				ult=a[i].getT1()[0];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {					
						prim=a[j].getT1()[a[j].getT1().length-1];
						temp=distances(prim,ult);
						if(MaxSave > temp) {
							MaxSave=temp;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
		}
		return ""+MaxSave+"/"+candi1Pos+"/"+candi2Pos;
	}
	
	/**
	 * Ultimo Primero
	 * Last First
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public String saveMethod3(Tour[] a) {
		Double MaxSave=Double.MAX_VALUE;
		Nodo prim;
		Nodo ult;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		if(a==null) {
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				prim=a[i].getT1()[0];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {
						ult=a[j].getT1()[a[j].getT1().length-1];
						temp=distances(ult,prim);
						if(MaxSave > temp) {
							MaxSave=temp;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
		}
		return ""+MaxSave+"/"+candi1Pos+"/"+candi2Pos;				
	}

	/**
	 * Ultimo - Ultimo
	 * Last - Last
	 * @param a arreglo de tours a analizar
	 * @return un string con la informacion de los tours a unir
	 */
	public String saveMethod4(Tour a[]) {
		Double MaxSave=Double.MAX_VALUE;
		Nodo ult2;
		Nodo ult;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		if(a==null) {
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				ult=a[i].getT1()[a[i].getT1().length-1];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {
						ult2=a[j].getT1()[a[j].getT1().length-1];
						temp=distances(ult2,ult);
						if(MaxSave > temp) {
							MaxSave=temp;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
		}
		return ""+MaxSave+"/"+candi1Pos+"/"+candi2Pos;
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
		Main m=new Main(5);
		Nodo[] nodos= {new Nodo(1,5), new Nodo(4,6), new Nodo(3,9), new Nodo(0,7), new Nodo(4,4), new Nodo(10,2), new Nodo(11,3), new Nodo(12,6), new Nodo(1,9)};
		m.setNodos(nodos);
		m.verrNodos();
		m.joinToursOnce();
	}
	
}
