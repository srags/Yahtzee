/**
* YahtzeeRunner is the runner class of Yahtzee which provides the player with game rules and runs the game
* @author Shreyaa Raghavan and Elizabeth Song
* @version 2018.11.28
*/

import java.util.Scanner;

public class YahtzeeRunner {

	//field includes the name entered by the player 
	static private String name;

	//main method
	public static void main(String[] args) {
		intro();
		int rounds = 8;			//total of 9 rounds but one is accounted for by constructor
		Yahtzee game = new Yahtzee();
		game.randomizeDice();
		System.out.println("Here is your first roll for the round: ");
		game.printTest();
		game.reRoll();
		game.updateScorecard();
		
		while (rounds > 0) {
			game.randomizeDice();
			System.out.println("Here is your first roll for the round: ");
			game.printTest();
			game.reRoll();
			game.updateScorecard();
			rounds -= 1;
		}
		
		//prints the user's final score
		System.out.println("Your final score is: " + game.getFinalScore());
		ending(name);
		
	}
	
	//method that prints game introduction and instructions
	public static void intro() {
		
		//get player's first name
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your first name. Then hit return: ");
		name = keyboard.next();
		
		//game instructions
		System.out.println("\nWelcome to Yahtzee, " + name + ". Here are the instructions for the game: \n");
		System.out.print("There are ten total rounds, each round consisting of three possible rolls. ");
		System.out.print("You start by rolling all four dice. You can then choose to re-roll any particular die up to three times for a better hand. ");
		System.out.println("At the end of at most three rolls, you must choose to enter a score into the scorecard that fits a particular category. \n");
		System.out.print("Your end score is the sum of the scores in all categories. ");
		System.out.print("Only one score can be entered into a particular category. ");
		System.out.print("If the roll at the end of the round doesn't fit any open category, then you do not gain any points for that round. ");
		System.out.println("The object of the game is to get the highest number of points possible. \n\nGood Luck, " + name + "!");

	}
	
	//method that prints the game conclusion
	public static void ending(String name) {
		System.out.println("Thank you for playing, " + name + "!");
	}
}