package game;

import java.util.Random;

import game.Cell;

public class Field {
	
//	Feel free to change the values as you wish (MAX_X and MAX_Y);
	private final int MAX_X = 3;
	private final int MAX_Y = 3;
	
	public final int ROWS = MAX_Y + 2;
	private final int COLS = MAX_X + 2;
	
	private Cell[][] field = new Cell[COLS][ROWS];
	
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
    
	public void initialize() {
		for(int i = 0; i < COLS; i++) {
			for(int k = 0; k < ROWS; k++) {
				field[i][k] = new LivingCell(i, k, coinFlip());
			}
		}
	}
	
	public void print() {
		
		System.out.println("Erklärung: 0 = lebende Zelle, X = tote Zelle, + = Border");
		System.out.println();
		
		for(int i = 0; i < COLS; i++) {
			for(int k = 0; k < ROWS; k++) {
				System.out.print(field[i][k].printCell());
			}
			System.out.println();
		}
	}
	
//	public Cell getCell(int posX, int PosY) {
//		TODO add method
//		return;
//	}
	
	public boolean coinFlip() {
		int coin = new Random().nextInt(2);
		if(coin == 1) { 
			return true; 
		} else { 
			return false; 
		}
	}
	
	public void addBorder() {
		for(int i = 0; i < field.length; i++) {
			for(int k = 0; k < field.length; k++) {
				field[0][k] = new BorderCell(0, k);
				field[i][0] = new BorderCell(i, 0);
				field[COLS-1][k] = new BorderCell((COLS-1), k);
				field[i][ROWS-1] = new BorderCell(0, (ROWS-1));
			}
		}		
	}
	
	public int getLivingNeighbors(int xPos, int yPos) {
		int count = 0;
		
//		Adding one to the index because of the border :-)
		int xStart = xPos + 1;
		int yStart = yPos + 1;
		
		int xPointer, yPointer;
			
		System.out.println();
		System.out.println("[+] Checking Cell["+xStart+"]["+yStart+"] ...");
		System.out.println();
		
		for(int i = 0; i < directions.length; i++) {
			xPointer = directions[i][0];
			yPointer = directions[i][1];
			
			int cellPosX = xStart + xPointer;
			int cellPosY = yStart + yPointer;
			
			System.out.println("[+] Checking field["+cellPosX+"]["+cellPosY+"] ...");
			
			if(!field[cellPosX][cellPosY].isBorderCell) {
				if(field[cellPosX][cellPosY].isAlive()) {
					count++;
					System.out.println("[+] Found one living Neighbor. Current count is: "+count);
					System.out.println();
				}
			}
			
		}
		
		System.out.println();
		System.out.println("[+] Operation finished for Cell["+xStart+"]["+yStart+"] ...\n[+] Neighbors alive: " + count);
		return count;
	}
	
	
}
