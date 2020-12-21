package NoughtsAndCrossesVerification;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameStatusVerificationTest {
	
    @Test public void testCheckInputInvalid() {
    	
    	// empty array
    	Character[][] invalid = {};
        GameStatusVerification game = new GameStatusVerification(invalid);
        assertTrue("testCheckInvalidInput should return 'false'", !game.checkValidInput());
        
        // wrong size of one or more arrays
        Character[][] invalid2 = {{'X', 'O'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}};
        GameStatusVerification game2 = new GameStatusVerification(invalid2);
        assertTrue("testCheckInvalidInput should return 'false'", !game.checkValidInput());
        
        // wrong size of the array
        Character[][] invalid3 = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}};
        GameStatusVerification game3 = new GameStatusVerification(invalid3);
        assertTrue("testCheckInvalidInput should return 'false'", !game.checkValidInput());
        
        // one or more arrays inside of the array empty
        Character[][] invalid4 = {{}, {}, {'X', 'X', 'X'}};
        GameStatusVerification game4 = new GameStatusVerification(invalid4);
        assertTrue("testCheckInvalidInput should return 'false'", !game.checkValidInput());
        
    }
    
    @Test public void testCheckInputVvalid() {
    	
    	// All nulls input (game hasn't started)
    	Character[][] valid = {{null, null, null}, {null, null, null}, {null, null, null}};
        GameStatusVerification game = new GameStatusVerification(valid);
        assertTrue("testCheckValidInput should return 'true'", game.checkValidInput());
        
        // Arrays filled completely
        Character[][] valid2 = {{'X', 'O', 'O'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}};
        GameStatusVerification game2 = new GameStatusVerification(valid2);
        assertTrue("testCheckValidInput should return 'true'", game.checkValidInput());
        
        // One or more arrays not filled completely but are the right size
        Character[][] valid3 = {{'X', 'O', 'X'}, {null, null, 'X'}, {'X', 'X', 'X'}};
        GameStatusVerification game3 = new GameStatusVerification(valid3);
        assertTrue("testCheckValidInput should return 'true'", game.checkValidInput());
        
    }
    
    @Test public void testCheckState()
    {
    	// X has won (and grid is not completely filled)
    	Character[][] game1 = new Character[][] {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {null, null, 'X'}};
    	GameStatusVerification ver1= new GameStatusVerification(game1);
    	assertTrue("testCheckState should return 'X won'", ver1.checkState().equals("X won"));
    	
    	// X has won (and grid is filled)
    	Character[][] game2 = new Character[][] {{'X', 'O', 'O'}, {'O', 'X', 'O'}, {'O','O', 'X'}};
    	GameStatusVerification ver2= new GameStatusVerification(game2);
    	assertTrue("testCheckState should return 'X won'", ver2.checkState().equals("X won"));
    	
    	// Invalid Input
		Character[][] game3 = new Character[][] {{},{},{}};
    	GameStatusVerification ver3= new GameStatusVerification(game3);
    	assertTrue("testCheckState should return 'Invalid Input'", ver3.checkState().equals("Invalid Input"));
		
		// Game in progress
		Character[][] game4 = new Character[][] {{'X', null, null}, {'O', null, null}, {null, null, null}};
    	GameStatusVerification ver4= new GameStatusVerification(game4);
    	assertTrue("testCheckState should return 'Game in progress'", ver4.checkState().equals("Game in progress"));
		
		// O won (grid filled)
		Character[][] game5 = new Character[][] {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'O', 'O', 'O'}};
    	GameStatusVerification ver5= new GameStatusVerification(game5);
    	assertTrue("testCheckState should return 'O won'", ver5.checkState().equals("O won"));
		
		// O won (grid not filled)
		Character[][] game6 = new Character[][] {{'X', 'O', 'X'}, {null, 'X', null}, {'O', 'O', 'O'}};
    	GameStatusVerification ver6= new GameStatusVerification(game6);
    	assertTrue("testCheckState should return 'O won'", ver6.checkState().equals("O won"));
		
		// Draw
		Character[][] game7 = new Character[][] {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {'O', 'X', 'O'}};
    	GameStatusVerification ver7= new GameStatusVerification(game7);
    	assertTrue("testCheckState should return 'It's a draw'", ver7.checkState().equals("It's a draw"));
    }
    
    @Test public void testHasWon()
    {
    	
    	// X has won
    	Character[][] game1 = new Character[][] {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {null, null, 'X'}};
    	GameStatusVerification ver1= new GameStatusVerification(game1);
    	assertTrue("testHasWon should return 'true'", ver1.hasWon('X'));
    	assertTrue("testHasWon should return 'false'", !ver1.hasWon('O'));
    	
		// O won
		Character[][] game2 = new Character[][] {{'X', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'X'}};
    	GameStatusVerification ver2= new GameStatusVerification(game2);
    	assertTrue("testHasWon should return 'true'", ver2.hasWon('O'));
    	assertTrue("testHasWon should return 'false'", !ver2.hasWon('X'));
    	
    	// Game in progress / It's a draw (No one one yet)
    	Character[][] game3 = new Character[][] {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {'O', 'X', 'O'}};
    	GameStatusVerification ver3= new GameStatusVerification(game3);
    	assertTrue("testHasWon should return 'false'", !ver3.hasWon('O'));
    	assertTrue("testHasWon should return 'false'", !ver3.hasWon('X'));
    	
    	
    }

}
