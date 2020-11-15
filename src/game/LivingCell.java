package game;

public class LivingCell extends Cell {
	
	private static int[][] directions = {
			{-1, -1},	// top left
			{-1, 0},	// top center
			{-1, 1},	// top right
			{0, -1},	// left
			{0, 1},		// right
			{1, -1},	// bottom left
			{1, 0},		// bottom center
			{1, 1}		// bottom right
	};
	
	public LivingCell(int posX, int posY, boolean alive) {
		this.posX = posX;
		this.posY = posY;
		this.alive = alive;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean status) {
		this.alive = status;
	}
	
	public void kill() {
		this.setAlive(false);
	}
	
	public int getLivingNeighbors() {
		int count = 0;
		
		return count;
	}
	
	
}
