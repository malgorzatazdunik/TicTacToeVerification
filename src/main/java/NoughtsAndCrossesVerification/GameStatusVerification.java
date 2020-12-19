package NoughtsAndCrossesVerification;


public class GameStatusVerification {
	
	
	
	Character[][] currentGame;
	boolean validInput;
	
	
	/*
	 *  the constructor takes in the current state of the game as
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
	
	
	// boolean to check if the input matrix is valid
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
		// check if X or O won
		// if they haven't, check if the grid is filled
		// if it is filled, it's a draw
		// if it isn't, the game hasn't finished yet
		
		// it doesn't matter what the characters in the grid are, it's only checked whether they are X's, O's, or null
		if (validInput)
		{
			if (hasWon('X')) return "X won";
			if (hasWon('O')) return "O won";
			
			for (int i =0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (currentGame[i][j] == null)
					{
						return "Game in progress";
					}
				}
			}
			return "It's a draw";			
		}
		else return "Invalid Input";

	}
	
	boolean hasWon(Character sign)
	{
		
		boolean won = true;
		
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
		for (int i = 0; i < 3; i++)
		{
			won = true;

			if (currentGame[i][i] != sign)
			{
				won = false;
				break;
			}
		}
		
		if (won) return true;
		
		for (int j = 2; j >= 0; j--)
		{
			won = true;
			
			if(currentGame[j][j] != sign)
			{
				won = false;
				break;
			}
		}
		
		if (won) return true;
		
		
		return false;
		
	}

}
