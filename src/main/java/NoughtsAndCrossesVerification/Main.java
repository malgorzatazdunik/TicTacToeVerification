package NoughtsAndCrossesVerification;

public class Main {
	
	public static void main (String[] args)
	{
		
		/*
		 * Main class to test out the code
		 */
		
		Character[][] game1 = new Character[][] {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {null, null, 'X'}};
		Character[][] game2 = new Character[][] {{'X', 'O', 'O'}, {'X', 'O', 'X'}, {'O','X', 'X'}};
		Character[][] game3 = new Character[][] {{null, null, null},{'X', 'O', null},{null, null, null}};
		Character[][] game4 = new Character[][] {{'O', 'X', 'X'}, {'X', 'O', 'O'}, {'X', 'O', 'X'}};

		
		GameStatusVerification ver1= new GameStatusVerification(game1);
		System.out.println(ver1.checkState());
		
		GameStatusVerification ver2= new GameStatusVerification(game2);
		System.out.println(ver2.checkState());
		
		GameStatusVerification ver3= new GameStatusVerification(game3);
		System.out.println(ver3.checkState());
		
		GameStatusVerification ver4= new GameStatusVerification(game4);
		System.out.println(ver4.checkState());
		
		
		
	}

}
