/**
* Scorecard keeps track of the player's scores during the game
* @author Shreyaa Raghavan and Elizabeth Song
* @version 2018.11.28
*/

import java.util.Arrays;
import java.util.Scanner;

public class Scorecard {

	//fields that initialize the Scorecard array and number of categories for the Scorecard
	private final int CATEGORIES = 9; 
	private int[] card;
	
	//scorecard constructor initializes card field with a 0 in each index of the int array
	public Scorecard() {
		card = new int[CATEGORIES];
		Arrays.fill(card, 0);
	}
	
	//method that returns a String representation of the scorecard to print on user console
	public String displayCard() {
		String name = "Scorecard: \n";
		name += "Ones(1)\t\t|" +  this.card[0] + "\n";
		name += "Twos(2)\t\t|" + this.card[1]+ "\n";
		name += "Threes(3)\t|" + this.card[2]+ "\n";
		name += "Fours(4)\t|" + this.card[3]+ "\n";
		name += "Fives(5)\t|" + this.card[4]+ "\n";
		name += "Sixes(6)\t|" + this.card[5]+ "\n";
		
		name += "Yahtzee(7)\t|" + this.card[6]+ "\n";
		
		name += "Straight(8)\t|" + this.card[7]+ "\n";
		name += "Chance(9)\t|" + this.card[8]+ "\n";
		
		return name;
		
	}
	
	//method that asks (and returns) the category the player wants to enter their score in
	public int getCategory(){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the category number you would like to enter your score in: ");
		int choice = keyboard.nextInt();
		
		while (this.card[choice - 1] != 0) {		//catch error - doesn't allow player to enter score in a non-zero category
			System.out.println("Category already occupied. Try again! ");
			System.out.print("Enter the category number you would like to enter your score in: ");
			choice = keyboard.nextInt();
		}
		
		return choice;
	}
	
	//method that updates the index of the scorecard with the corresponding score
	public void updateCardTest(int value, int userChoice) {
		this.card[userChoice - 1] = value;
	}
	
	//method that tests for whether or not the player actually has a straight
	public boolean testForStraight(String dice) { 
		
		int diceValue = Integer.parseInt(dice);
		int [] diceSort = {diceValue / 1000, diceValue % 1000 /100, diceValue % 100 /10, diceValue % 10};
		boolean straight = false;
		int i, j, temp;
		
		for (i = 1; i < diceSort.length; i++) {			//some insertion sort here
        	j = i - 1;
       		while (j >= 0 && diceSort[j] > diceSort[i] ) {
            	temp = diceSort[i];
            	diceSort[i] = diceSort[j];
            	diceSort[j] = temp;
            	i = j;
            	j--;
        	}
    	}
    	
    	diceValue = 0;
    	
		for(int x = 0; x < diceSort.length; x++){		//dice sorted in ascending order
    		diceValue += diceSort[x] * Math.pow(10, 3-x); 
    		}
    		
    	if (diceValue == 1234 || diceValue == 2345 || diceValue == 3456) {
    		straight = true;
    	}
    	return straight;
    }
		
	//method that tests for whether or not the player actually has Yahtzee
	public boolean testForYahtzee(String dice) {
		int diceValue = Integer.parseInt(dice);
		boolean yahtzee = false;
		
		if (diceValue % 1111 == 0) {
			yahtzee = true;
		}
		
		return yahtzee;
	}
	
	//method that computes the player's final score
	public int computeFinalScore() {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += this.card[i];
		}
		return sum;
	}	
		
		
}