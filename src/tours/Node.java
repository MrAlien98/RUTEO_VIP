package tours;

public 	class Node{
	
	private int posX;
	private int posY;
	
	private char id;
	
	private boolean added;
	
	public Node(int posX, int posY, char id) {
		this.posX=posX;
		this.posY=posY;
		this.setId(id);
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
	
	public char getId() {
		return id;
	}
	
	public void setId(char id) {
		this.id = id;
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