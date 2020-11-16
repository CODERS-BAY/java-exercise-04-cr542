package game;

public abstract class Cell {
	protected int posX, posY;
	protected boolean isBorderCell = false;
	protected boolean alive = false;
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setPosition(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean status) {
		this.alive = status;
	}
	
	public String printCell() {
		if(isBorderCell == true) {
			return "+";
		} else if(alive == true) {
			return "O";
		} else {
			return "X";
		}
	}
	
	public void makeBorderCell() {
		this.isBorderCell = true;
	}
}
