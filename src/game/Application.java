package game;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		
		final Scanner SCAN = new Scanner(System.in);
		
//		User field size declaration is not supported yet
		
//		System.out.println("How big do you want the court to be? Enter a number between 1 and 99");
//		int size = SCAN.nextInt();
		
		System.out.println("How many rounds do you wanna play? Enter a number between 1 and 99");
		int rounds = SCAN.nextInt();
		SCAN.close();
		int currentRound = 0;
		
		System.out.println(" ====================== ");
		Field field = new Field();
			
		do {
			for (int i = 0; i < field.getLengthX(); i++) {
				for (int j = 0; j < field.getLengthY(); j++) {
					Cell actual = field.getCell(i, j);
					if(!actual.isBorderCell) {
						if(actual.isAlive()) {
							if(actual.getLivingNeighbors(field, i, j) == 2 || actual.getLivingNeighbors(field, i, j) == 3) {
								System.out.println("[+] Cell ["+i+"]["+j+"] stays alive ...");
								System.out.println();
							} else if(!actual.isAlive() && (actual.getLivingNeighbors(field, i, j) >= 3)) {
								System.out.println("[+] Cell ["+i+"]["+j+"] is dead, but gets revived ...");
								System.out.println();
								actual.revive();
							} else {
								System.out.println("[+] Cell ["+i+"]["+j+"] gets killed ...");
								System.out.println();
								actual.kill();
							}
						} else {
							System.out.println("[+] Cell ["+i+"]["+j+"] is already dead ...");
						} 
					} 	
				}
			}
			System.out.println();
			System.out.println(" ====================== ");
			System.out.println();
			field.print();
			currentRound++;
			
		} while(currentRound < rounds);

		
		
	}
}
