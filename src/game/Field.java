package game;

import java.util.Random;

import game.Cell;

public class Field {
	private final int MAX_X = 3;
	private final int MAX_Y = 3;
	
	public final int ROWS = MAX_Y + 2;
	private final int COLS = MAX_X + 2;
	
	private Cell[][] field = new Cell[COLS][ROWS];
    
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
