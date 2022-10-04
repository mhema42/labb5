package edu.lernia.labb5;

import java.util.Scanner;

public class Game {
	private static Die[] dice;
	static String q = null;
	
		
	protected static void runGame() {
		int turn = 0;
		
		System.out.println("Welcome to Yatzi!\n");
		
		while (turn < 3) {
			System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
			gameEngine(turn);
			turn++;		
				
			if (turn == 3) {
				System.out.println("\nGame over! Want to Play again?");
				if (ask(q) == "yes") {
					runGame();      	
				}
				break;
			} 

			System.out.println("\nWant to throw again? (y for yes, anything else for no)");
			if (ask(q) == "no") {
				break;
			}
		}
		endGame();
	}
	
	
	private static void gameEngine(int turn) {   	   	
        dice = new Die[5];
        
        for(int i = 0; i < 5; i++) {
            dice[i] = new Die();
            dice[i].DieRoll(); //random # on dices
            
//            dice[i].value = 5; //same # to test if yatzi work
            
            System.out.println(i + ": " + dice[i].getString());
        }    	     
        yatzi();
    }
    
    
	private static void yatzi() {
    	boolean yatzi = true;
        
        for(int j = 1; j < 5; j++) {
        	if(dice[j].value != dice[j-1].value) {
        		yatzi = false;
        		break;
        	}
        }
        
        if (yatzi == true) {
			System.out.println("You got YATZI! in " + dice[0].value + "'s" + "\n\nWant to Play again?");
			if (ask(q) == "yes") {
				runGame();
			}
			endGame();
		}
    }
    
    
	private static String ask(String q) {
    	Scanner sc = new Scanner(System.in); {
				if (sc.nextLine().equals("y")) {
					return "yes";
				}
		} 
		return "no";    	
    }
    
    
	private static void endGame() {
    	System.out.println("Tack för att du spelade!");
    	System.exit(0);
    }
}