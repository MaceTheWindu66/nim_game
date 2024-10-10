Author: Maddux Berry, Class of 2026
Email: mlberry@wpi.edu

Main.java is the java file in which the whole program is located. To use the program, insert the file into whatever IDE or software
you are using to run java,

TO RUN THE PROGRAM, simply compile the main file and run it, and it will start the game. The console will prompt you to enter a value, either 0 or 1, which will decide who plays first. It will then promt you to make moves, as well as making moves against you, utilizing the winning strategy divulged in 1951 using ^/XOR operations to divise a winning strategy when the "Nim-sum" (the sum divised for the winning stategy) doesn't equal 0. If the Nim-sum is equal to 0, the computer will make random moves in an attempt to get back to a winning position.

When it comes to your turn, you will be prompted by the console to enter in a CAPITALIZED character: either G, Y, or O (for the green, yellow, and orange groups of pieces). It will tell you your move is invalid if the letter is not capitalized. After this, you will be prompted to enter in a number, representing the pieces you would like to remove. 

If you attempt to break the rules at any time, the program will prompt you to make a legal move instead, and will not let you make an illegal move. This includes the following:
	1. Adding pieces to a pile
	2. Removing more pieces from a pile than there are in a pile
	3. Removing pieces from different color groups in the same turn
	4. Attempting to not make a move.
