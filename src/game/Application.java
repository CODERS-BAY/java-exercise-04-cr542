package game;

public class Application {
	public static void main(String[] args) {
		
//		User Eingabe der Spielfeldgröße
		
		Field field = new Field();
		field.initialize();
		field.addBorder();
		field.print();
		
	}
}
