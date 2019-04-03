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
	
	public void joinToursOnce() {
		Tour[] newTours=new Tour[tours.length-1];
		for(int i=0;i<newTours.length;i++) {
			newTours[i]=new Tour(i);
		}
		for(int i=0;i<newTours.length;i++) {
			Nodo[] a= {nodos[0], nodos[i]};
			newTours[i].setT1(a);
		}
		setTours(newTours);
		joinTours();
//		String ajam="";
//		for(int j=0;j<tours.length;j++) {
//			for(int i=0;i<tours[j].getT1().length;i++) {
//				ajam+=tours[j].getT1()[i]+" ";
//			}
//			ajam+="\n";
//		}
//		System.out.println(ajam);
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
		double save2=Double.parseDouble(s1a[0]);
		double save3=Double.parseDouble(s1a[0]);
		double save4=Double.parseDouble(s1a[0]);
		
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
		for(int i=0;i<tours.length;i++) {
			for(int j=0;j<tours[i].getT1().length;j++) {
				aja+=tours[i].getT1()[j].toString()+" ";
			}
			aja+="\n";
		}
		System.out.println(aja);
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
		for(int i=0;i<tours.length-1;i++) {
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
					ts[i]=tours[i+1];
				}else {
					ts[i]=tours[i];
				}
			}
		}
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
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else {
					ts[i]=tours[i];
				}
			}
		}
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
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else {
					ts[i]=tours[i];
				}
			}
		}
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
		for(int i=tours[x].getT1().length;i<ns.length;i++) {
			ns[i]=b[c];
			c++;
		}
		for(int i=0;i<tours.length;i++) {
			if(x==tours.length-1) {
				ts[i].setT1(ns);
				ts[i+1]=tours[i];
			}else {
				if(i==x) {
					Tour n=new Tour(ns.length);
					n.setT1(ns);
					ts[i]=n;
				}else {
					ts[i]=tours[i];
				}
			}
		}
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
		Nodo candidato1=null;;
		Nodo candidato2=null;;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		if(a==null) {
			//System.out.println("Lo siento pero, no has ingresado nada");
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				prim=a[i].getT1()[0];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {
//						System.out.println(""+i +""+ j);
						prim2=a[j].getT1()[0];
//						System.out.println(prim.toString()+"  "+prim2.toString());
						temp=distances(prim2,prim);
						if(MaxSave > temp) {
							MaxSave=temp;
							candidato1=prim;
							candidato2=prim2;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
//			System.out.println("("+candidato1.toString()+") ("+candidato2.toString()+") : "+MaxSave+ " _ "+ candi1Pos +"," +candi2Pos );
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
		Nodo candidato1=null;;
		Nodo candidato2=null;;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
		if(a==null) {
			//System.out.println("Lo siento pero, no has ingresado nada");
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				
				ult=a[i].getT1()[0];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {
//						System.out.println(""+i +""+ j);					
						prim=a[j].getT1()[a[j].getT1().length-1];
//						System.out.println(prim.toString()+"  "+ult.toString());
						temp=distances(prim,ult);
						if(MaxSave > temp) {
							MaxSave=temp;
							candidato1=prim;
							candidato2=ult;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
//			System.out.println("("+candidato1.toString()+") ("+candidato2.toString()+") : "+MaxSave+ " _ "+ candi1Pos +"," +candi2Pos );
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
		Nodo candidato1=null;;
		Nodo candidato2=null;;
		int candi1Pos=0;
		int candi2Pos=0;
		double temp;
//		String v="";
		if(a==null) {
			//System.out.println("Lo siento pero, no has ingresado nada");
			return "Lo siento pero, no has ingresado nada";
		}else {
			for(int i=0; i<a.length;i++) {	
				prim=a[i].getT1()[0];
				for(int j=0; j<a.length;j++) {
					if(i!=j) {
//						System.out.println(""+i +""+ j);
						ult=a[j].getT1()[a[j].getT1().length-1];
//						System.out.println(prim.toString()+"  "+ult.toString());
						temp=distances(ult,prim);
//						v+=temp+" ";
						if(MaxSave > temp) {
							MaxSave=temp;
							candidato1=prim;
							candidato2=ult;
							candi1Pos=i;
							candi2Pos=j;					
						}	
					}
				}				
			}
//			System.out.println(v);
//			System.out.println("("+candidato1.toString()+") ("+candidato2.toString()+") : "+ MaxSave+ "   "+ candi1Pos +"," +candi2Pos );
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
<<<<<<< HEAD
=======
						//System.out.println(""+i +""+ j);
>>>>>>> branch 'master' of https://github.com/MrAlien98/RUTEO_VIP.git
						ult2=a[j].getT1()[a[j].getT1().length-1];
<<<<<<< HEAD
=======
						//System.out.println(ult.toString()+"  "+ult2.toString());
>>>>>>> branch 'master' of https://github.com/MrAlien98/RUTEO_VIP.git
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
		joinToursOnce();
	}
	
	public Tour[] getTours() {
		return tours;
	}
	
	public void setTours(Tour[] tours) {
		this.tours = tours;
	}
	
	public static void main(String[] args) {
		Main m=new Main(5);
		Nodo[] nodos= {new Nodo(1,5),new Nodo(4,6),new Nodo(3,9),new Nodo(0,7),new Nodo(4,4),new Nodo(10,2),new Nodo(11,3),new Nodo(12,6),new Nodo(1,9)};
		m.setNodos(nodos);
//		Tour[] t=new Tour[2];
//		
//		Nodo[] t1=new Nodo[3];
//		t1[0]=new Nodo(5,9);
//		t1[1]=new Nodo(6,3);
//		t1[2]=new Nodo(5,10);
//		
//		Nodo[] t2=new Nodo[3];
//		t2[0]=new Nodo(4,7);
//		t2[1]=new Nodo(3,0);
//		t2[2]=new Nodo(9,2);
//		
//		t[0]=new Tour(2);
//		t[0].setT1(t1);
//		
//		t[1]=new Tour(2);
//		t[1].setT1(t2);
//		
//		m.setTours(t);
		
//		String mensaje=m.saveMethod1(t);
//		System.out.println(mensaje);
	}
	
}
