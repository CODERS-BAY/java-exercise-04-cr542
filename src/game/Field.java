package game;

import java.util.Random;

import game.Cell;

public class Field {
	
//	Feel free to change the values as you wish (MAX_X and MAX_Y);
	private final int MAX_X = 3;
	private final int MAX_Y = 3;
	
//	Adding fields for creating border
	private final int ROWS = MAX_Y + 2;
	private final int COLS = MAX_X + 2;
	
	private Cell[][] field = new Cell[COLS][ROWS];
    
	
//	TODO Find a way to let the user define how big the game field is.
//	Until I implement a solution for this, I will use the standard constructor.
	
	public Field() {		
		for(int i = 0; i < COLS; i++) {
			for(int k = 0; k < ROWS; k++) {
				field[i][k] = new LivingCell(i, k, coinFlip());
			}
		}
		this.addBorder();
		System.out.println("[+] Game field created successfully.");
		System.out.println();
		System.out.println("Erklärung: 0 = lebende Zelle, X = tote Zelle, + = Border");
		this.print();
	}
	
	public Cell[][] getField() {
		return field;
	}
	
	public int getLengthX() {
		return COLS;
	}
	
	public int getLengthY() {
		return ROWS;
	}
	
	public void print() {
		System.out.println("[+] New game field: \n");
		for(int i = 0; i < COLS; i++) {
			for(int k = 0; k < ROWS; k++) {
				System.out.print(field[i][k].printCell());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public Cell getCell(int posX, int posY) {
		return field[posX][posY];
	}
	
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
		
}
