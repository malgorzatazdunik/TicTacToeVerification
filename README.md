# Tic Tac Toe game verifier

A simple verification code for the Tic Tac Toe game. The code checks if the user placing the X's, or the user placing the O's won,
was it a draw, or the game is still in progress.

The code should be called everytime any of the players place a sign on the game grid (starting from the time when any of the playerd placed 3 signs on the grid). 

Built with Buildship Gradle Integration for Eclipse in Java 8.

* (GameStatusVerification.java)[src/main/java/NoughtsAndCrossesVerification/GameStatusVerification.java]
contains code to verify the current status of the game. The constructor of the class takes in a multidimensional array of shape 3 x 3 (3 rows, 3 columns) as a representation of the game grid;

It verifies whether the input array is valid (is not empty, arrays are of expected length) by calling

```java
boolean checkValidInput() which returns false if the input is not valid - the constructor sets the global boolean validInput to the output of that method.
```


	* ```java
	String checkState()
	```
	1. If boolean validInput is set to false, checkState() returns "Invalid Input". Otherwise, it first checks if either of players placing
	X's or O's won by calling ```boolean hasWon(Character sign)```; 
	2. If any of the players placing X's or O's won, it returns "<Sign> has won". 
	3. If none of the players have won, it checks whether the game is still in progress (the game is in progress until a player has won or the game grid is filled). If the game is still
	in progress, the method returns "Game still in progress".
	4. If none of the players won and the game grid is filled, it returns "It's a draw". 


	* ```java
	boolean hasWon(Character sign)
	```
	This method checkes whether the sign passed as argument to the method has won the game, i.e., 
	if there are 3 sings in a row, a column, or any of the two diagonals that are the same and are equal to the passed sign.

* (Main.java)[src/main/java/NoughtsAndCrossesVerification/Main.java] is a class I used to test out my code with different inputs

* (GameStatusVerificationTest.java)[src/test/java/NoughtsAndCrossesVerification/GameStatusVerificationTest.java] contains unit tests written to test all methods in GameStatusVerification.java

	
