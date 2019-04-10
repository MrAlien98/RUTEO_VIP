package tours;

public 	class Nodo{
	
	int posX;
	int posY;
	
	public Nodo(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
	}
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
	
	@Override
	public String toString() {
		return getPosX()+","+getPosY();
	}
}