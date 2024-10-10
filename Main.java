// Author: Maddux Berry, Class of 2026
// Email: mlberry@wpi.edu

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	//Method for the computer to play its turn.
	public static void playTurn(int[] pieces) {
		
		int nim = pieces[0] ^ pieces[1] ^ pieces[2];
		
		//If nim (representative of the Nim-sum) is 0, there is no winning strategy. Thus,
		//the computer will play a random move until the Nim-sum is no longer 0. 
		if(nim == 0) {
			Random random = new Random();
			int rand = random.nextInt(3);
			
			//Check to make sure there are pieces in the random group of pieces is chosen
			//If not, it keeps choosing a random number until it finds a group with pieces in it
			while(true)
			if(pieces[rand] == 0) {
				rand = random.nextInt(3);
			}else {
				break;
			}
			
			int remover = random.nextInt(pieces[rand]) + 1;
			
			if(rand == 0) {
				System.out.println("Computer takes " + remover + " green pieces.");
			}
			if(rand == 1) {
				System.out.println("Computer takes " + remover + " yellow pieces.");
			}
			if(rand == 2) {
				System.out.println("Computer takes " + remover + " orange pieces.");
			}
			
			pieces[rand] = pieces[rand] - remover;
			
		}else {
			
			for(int i = 0; i < pieces.length; i++) {
				int f = nim ^ pieces[i];
				
				if(f < pieces[i]) {
					int toBeRemoved = pieces[i] - f;
					if(i == 0) {
						System.out.println("Computer takes " + toBeRemoved + " green pieces.");
					}
					if(i == 1) {
						System.out.println("Computer takes " + toBeRemoved + " yellow pieces.");
					}
					if(i == 2) {
						System.out.println("Computer takes " + toBeRemoved + " orange pieces.");
					}
					
					pieces[i] -= toBeRemoved;
					break;
					
				}
			}
		}
	}
	
	public static void playerPlay(int[] pieces) {
		
		System.out.println("What pile would you like to choose from? (Answer Format: 'Y' for Yellow, 'O' for Orange, etc.)");
		String pileChoice = sc.nextLine();
		pileChoice = sc.nextLine();
		int amnt = 0;
		boolean checkman = false;
		while(checkman == false) {
			if(!pileChoice.equals("G") && !pileChoice.equals("Y") && !pileChoice.equals("O")) {
				System.out.println("Illegale move: Please choose from only ONE of the piles, either G, Y, or O.");
				pileChoice = sc.nextLine();
			}
			else {
				checkman = true;
				break;
			}
		}
		if(pileChoice.equals("G")) {
			System.out.println("How many from the green group?");
			amnt = sc.nextInt();
			boolean checker = false;
			while(checker == false) {
				if(amnt > pieces[0] || amnt <= 0) {
					System.out.println("ILLEGAL INPUT. Please try again.");
					amnt = sc.nextInt();
				}
				else {
					checker = true;
				}
			}
			pieces[0] -= amnt;

		}
		else if(pileChoice.equals("Y")) {
			System.out.println("How many from the yellow group?");
			amnt = sc.nextInt();
			boolean checker = false;
			while(checker == false) {
				if(amnt > pieces[1] || amnt <= 0) {
					System.out.println("ILLEGAL INPUT. Please try again.");
					amnt = sc.nextInt();
				}
				else {
					checker = true;
				}
			}
			pieces[1] -= amnt;

		}
		else if(pileChoice.equals("O")) {
			System.out.println("How many from the orange group?");
			amnt = sc.nextInt();
			boolean checker = false;
			while(checker == false) {
				if(amnt > pieces[2]|| amnt <= 0) {
					System.out.println("ILLEGAL INPUT. Please try again.");
					amnt = sc.nextInt();
				}
				else {
					checker = true;
				}
			}
			pieces[2] -= amnt;

		}
		
	}

	//Main method
	public static void main(String[] args) {
		
		System.out.println("Hello! Welcome to Nim. I'm your CPU opponent. Let me explain the rules before we begin: ");
		System.out.println("Rule 1: You can only move pieces from one color group at a time (you cannot move both Green and Orange in the same turn).");
		System.out.println("Rule 2: You must type the first letter of the color in all caps (If you would like to choose Yellow, type 'Y').");
		System.out.println("Rule 3: You cannot take more pieces than there are in one group, and you cannot add pieces to a group.");
		System.out.println("Rule 4: You must do something during your turn. You cannot 'skip' a turn.");
		System.out.println("Rule 5: Have fun trying to beat me :)");
		System.out.println("");
		System.out.println("Who would you like to start?");
		System.out.println("For CPU to have first move, type in 1.");
		System.out.println("For Player1 to have the first move, type in any integer not equal to 1.");
		int whoGoesFirst = sc.nextInt();
		
		int[] pieceCounts = {3, 7, 5};
		boolean isPlaying = true;
		while(isPlaying) {
			//Visual representation of the game prints out at the beginning of the loop
			
			for(int i = 0; i < pieceCounts[0]; i++) {
				
				System.out.print("G ");
			}
			System.out.println("");
			
			for(int i = 0; i < pieceCounts[1]; i++) {
				
				System.out.print("Y ");
			}
			System.out.println("");
			
			for(int i = 0; i < pieceCounts[2]; i++) {
				
				System.out.print("O ");
			}
			System.out.println("");
			
			if(whoGoesFirst == 1) {
				playTurn(pieceCounts);
				if(pieceCounts[0] == 0 && pieceCounts[1] == 0 && pieceCounts[2] == 0) {
					System.out.println("CPU Wins!");
					isPlaying = false;
					break;
				}
				
				System.out.println("Current Board: ");
				
				for(int i = 0; i < pieceCounts[0]; i++) {
					
					System.out.print("G ");
				}
				System.out.println("");
				
				for(int i = 0; i < pieceCounts[1]; i++) {
					
					System.out.print("Y ");
				}
				System.out.println("");
				
				for(int i = 0; i < pieceCounts[2]; i++) {
					
					System.out.print("O ");
				}
				System.out.println("");
				
				playerPlay(pieceCounts);
				
				if(pieceCounts[0] == 0 && pieceCounts[1] == 0 && pieceCounts[2] == 0) {
					System.out.println("Player Wins!");
					isPlaying = false;
					break;
				}
				
			}else {
				playerPlay(pieceCounts);
				if(pieceCounts[0] == 0 && pieceCounts[1] == 0 && pieceCounts[2] == 0) {
					System.out.println("Player Wins!");
					isPlaying = false;
					break;
				}
				
				playTurn(pieceCounts);
				
				if(pieceCounts[0] == 0 && pieceCounts[1] == 0 && pieceCounts[2] == 0) {
					System.out.println("CPU Wins!");
					isPlaying = false;
					break;
				}
				
				
			}
			
		}
	}
}

