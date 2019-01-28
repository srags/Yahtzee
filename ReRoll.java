/**
* ReRoll class accounts for re-rolling the dice and computing the player's score in each round
* @author Shreyaa Raghavan and Elizabeth Song
* @version 2018.11.28
*/

import java.util.Scanner;
import java.util.Arrays;

public class ReRoll {

	//fields that initialize the re-roll counter and a String that stores the four values of the dice
	static int counter = 3;
	static String diceNew;
	
	//constructor that initializes the value of diceNew
	public ReRoll(String dice){
		diceNew = dice;
	}
	
	//method that keeps track of the number of rolls left and returns new hand
	public static String yesRoll(String dice) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the dice number you would like to re-roll: ");
		
		int changeIndex;
		int newRoll;	
		changeIndex = keyboard.nextInt() - 1;		//accounts for zero-index 
		newRoll = (int)(Math.random() * 6 + 1);		//re-rolls a particular dice
		
		diceNew = dice.substring(0, changeIndex) + newRoll + dice.substring(changeIndex+1, 4);		//creates new String with updated dice value
		System.out.println("This is your new hand: " + diceNew);
		
		counter -= 1;		//allows for a maximum of three rolls
		System.out.println("You have at most " + counter + " rolls left.");
		
		return diceNew;		
	}
	
	//method that resets the counter
	public void setCounter(int value){
		counter = value;
	
	}
	
	//method that re-rolls the dice during each round based on user input
	public void Roll(String dice){
		while (counter > 0) {
		
			if (decision().equals("Y")) {
				Roll(yesRoll(dice));			//recursion - to account for re-rolling until the user wants to stop
			}					
			else {
				counter = 0;
				diceNew = dice;		
			}
			
		}
	}
	
	//method that determines whether the user wants to re-roll or not
	public static String decision(){
		System.out.print("Would you like to re-roll any other dice? ");
		Scanner keyboard = new Scanner(System.in);
		String nextDecision = keyboard.next();
		return nextDecision;
	}
	
	//returns value of diceNew
	public String getDiceNew(){
		return diceNew;
	}
	
	//computes score for straights and chance (points = sum of dice values)
	public int computeDiceSum(){
		int dice = Integer.parseInt(diceNew);		//converts String to dice to compute score
		int sum = dice % 10 + (dice / 10) % 10 + (dice / 100) % 10 + (dice / 1000);
		return sum; 
	}
	
	//computes score for yahtzee (30 points regardless of combination)
	public int computeYahtzeeSum(){
		return 30; 
	}
	
	//computes score for category 1-6 (points = sum of dice values that equal category value)
	public int computeCatSum(int userChoice){
		int sum = 0;
		int dice = Integer.parseInt(diceNew);
		for (int i = 4; i > 0; i--) {
			if (dice % 10 == userChoice) {
				sum += userChoice;
				dice /= 10;
			}
			else {
				dice /= 10;
			}
		}
		return sum;
	}
	
	
	
}