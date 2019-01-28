/**
* Yahtzee creates instances of the ReRoll and Scorecard objects
* @author Shreyaa Raghavan and Elizabeth Song
* @version 2018.11.28
*/

import java.util.Scanner;

public class Yahtzee {
	
	//fields include the four dice that the player can "roll" and a String that stores all four values of the dice
	private int dice1;
	private int dice2;
	private int dice3;
	private int dice4;
	private String dice;
	
	//constructor that initializes the values of the dice
	public Yahtzee(){
		dice1 = 0;
		dice2 = 0;
		dice3 = 0;
		dice4 = 0;
		dice = "";		
	}	
	
	Scorecard card = new Scorecard();
	ReRoll game = new ReRoll(dice);

	//randomizes the dice rolls for rounds 2-9
	public void randomizeDice() {
		dice1 = (int)(Math.random() * 6 +1);
		dice2 = (int)(Math.random() * 6 +1);
		dice3 = (int)(Math.random() * 6 +1);
		dice4 = (int)(Math.random() * 6 +1);
		dice = Integer.toString(dice1) + Integer.toString(dice2) + Integer.toString(dice3) + Integer.toString(dice4);
		
	}
	
	//executes the re-rolling of the dice, resets the counter, and computes the score
	public void reRoll() {
		Scanner keyboard = new Scanner(System.in); 
		
		System.out.println();
		game.setCounter(3);	
		game.Roll(dice);
		game.getDiceNew();
		game.computeDiceSum();
	}
	
	//prints the current dice value
	public void printTest(){ 
		System.out.println(dice);
	}
	
	//updates Scorecard based on category choice of the player
	public void updateScorecard() {
		System.out.println(card.displayCard());
		int choice = card.getCategory();
		
		if (choice == 1 ||choice == 2||choice == 3||choice == 4||choice == 5||choice == 6){
			card.updateCardTest(game.computeCatSum(choice), choice);
		} else if (choice == 8 && card.testForStraight(game.getDiceNew()) == true) {
			card.updateCardTest(game.computeDiceSum(), choice);
		} else if (choice == 9) {
			card.updateCardTest(game.computeDiceSum(), choice);
		} else if (choice == 7 && card.testForYahtzee(game.getDiceNew()) == true){
			card.updateCardTest(game.computeYahtzeeSum(), choice);
		} else {
			System.out.println("Not a valid category!");
		}
		System.out.println(card.displayCard());
	}
	
	//returns the final score from the Scorecard object (final score = sum of the points in all the categories)
	public int getFinalScore() {
		return card.computeFinalScore();
	}
}