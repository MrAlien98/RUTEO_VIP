package tours;

public 	class Node{
	
	int posX;
	int posY;
	boolean added;
	
	public Node(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		added=false;
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
	
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}

	@Override
	public String toString() {
		return getPosX()+","+getPosY();
	}
}