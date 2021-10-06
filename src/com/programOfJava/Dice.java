package com.programOfJava;

import java.util.Random;

public class Dice {

	static final int[] DICE = {1, 2, 3, 4, 5, 6};

	public static void main(String[] args) {


		Random random1 = new Random();
				
		int throwDice1 = random1.nextInt(DICE.length);
		int throwDice2 = random1.nextInt(DICE.length);
				
		int sum = DICE[throwDice1] + DICE[throwDice2];

		System.out.println("DICE 1 got number : " + DICE[throwDice1] + "\t" + "DICE 2 got number : " + DICE[throwDice2] + "\n");
		System.out.println("Sum of 2 Dices is : " + sum + "\n");

		if (sum == 7 || sum == 11) {
			System.out.println("You Won!!!");
		} else {
			System.out.println("Oops!!! you lost");
		}
	}
}