package NoughtsAndCrossesVerification;


public class GameStatusVerification {
	
	
	
	Character[][] currentGame;
	boolean validInput;
	
	
	/*
	 *  The constructor takes in the current state of the game as
	 *  a multidimensional (2D) array (matrix 3x3)
	 *  
	 *  This code checks if any the users placing X's and O's won; It should be called everytime after a user has placed a sign on the grid
	 *  - after 3 of each sign has been placed on the grid already
	 */
	GameStatusVerification(Character[][] _currentGame)
	{
		currentGame = _currentGame;	
		validInput = checkValidInput();
		
	}
	
	
	// Boolean to check if the input matrix is valid
	boolean checkValidInput()
	{
		if (currentGame == null) {
			return false;
		}
		
		if (currentGame.length != 3) {
			return false;
		}
		
		for (int i =0; i < 3; i++)
		{
			if (currentGame[i].length != 3)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	String checkState()
	{
		

		if (validInput)
		{
			// Check if X or O won
			if (hasWon('X')) return "X won";
			if (hasWon('O')) return "O won";
			
			// if they haven't, check if the grid is filled
			for (int i =0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (currentGame[i][j] == null)
					{
						// if the grid isn't filled, the game hasn't finished yet
						return "Game in progress";
					}
				}
			}
			// if it is filled, it's a draw
			return "It's a draw";			
		}
		else return "Invalid Input";

	}
	
	boolean hasWon(Character sign)
	{
		
		boolean won = true;
		
		/*
		 * (It doesn't matter what the characters in the grid are, it's only checked whether they are X's, O's, or null 
		 * - if the signs placed are anything different than X or O or null, the grid is being filled, but none of the players win (a draw),
		 * as long as there are no rows/columns/diagonals with all 3 X's or O's
		 */
		
		// rows
		for (int i = 0; i < 3; i++)
		{
			won = true;
			for (int j = 0; j < 3; j++)
			{
				if (currentGame[i][j] != sign)
				{
					won = false;
					break;
				}
			}
			if (won) return true;
		}
		
		// columns
		for (int i = 0; i < 3; i++)
		{
			won = true;
			for (int j = 0; j < 3; j++)
			{
				if (currentGame[j][i] != sign)
				{
					won = false;
					break;
				}
			}
			if (won) return true;
		}
		
		// diagonals
		
		won = true;
		for (int i = 0; i < 3; i++)
		{
			

			if (currentGame[i][i] != sign)
			{
				won = false;
				break;
			}
		}
		
		if (won) return true;
		
		won = true;
		
		int i =0;
		for (int j = 2; j >= 0; j--)
		{
			if(currentGame[j][i] != sign)
			{
				won = false;
				break;
			}
			i++;
		}
		
		if (won) return true;
		
		
		return false;
		
	}

}
