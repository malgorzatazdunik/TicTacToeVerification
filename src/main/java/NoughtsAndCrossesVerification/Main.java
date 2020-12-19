package NoughtsAndCrossesVerification;

public class Main {
	
	public static void main (String[] args)
	{
		
		Character[][] game1 = new Character[][] {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {null, null, 'X'}};
		Character[][] game2 = new Character[][] {{'X', 'O', 'O'}, {'O', 'X', 'O'}, {'O','O', 'X'}};
		Character[][] game3 = new Character[][] {{},{},{}};
		Character[][] game4 = new Character[][] {{null, null, null}, {null, null, null}, {null, null, null}};
		Character[][] game5 = new Character[][] {{'X', '7', 'X'}, {'O', 'X', 'O'}, {'O', 'O', 'O'}};
		GameStatusVerification ver1= new GameStatusVerification(game1);
		System.out.println(ver1.checkState());
		
		GameStatusVerification ver2= new GameStatusVerification(game2);
		System.out.println(ver2.checkState());
		
		GameStatusVerification ver3= new GameStatusVerification(game3);
		System.out.println(ver3.checkState());
		
		GameStatusVerification ver4= new GameStatusVerification(game4);
		System.out.println(ver4.checkState());
		
		GameStatusVerification ver5= new GameStatusVerification(game5);
		System.out.println(ver5.checkState());
		
	}

}
