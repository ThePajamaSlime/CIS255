/* Khamanei Ainsworth
 * Fri, June 21, 2024
 * it's rock paper scissors.
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors2 {
	static String option(int play, boolean win) {
		/*
		int ro = 1;
		int pa = 2;
		int sc = 4;
		*/

		switch (play) {
			case 1:
				return win ? "Scissors" : "Paper";
			case 2:
				return win ? "Rock" : "Scissors";
			case 4:
				return win ? "Paper" : "Rock";
		}

		return "error";
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int play = 0;

		int wins = 0, losses = 0, draws = 0;
			
		int i = 0;
		while (i < 10) {
			System.out.printf("Round #%d\n", i+1);
			String choice = input.nextLine();
			choice = choice.substring(0, 2);
			choice = choice.toLowerCase();

			switch (choice) {
				case "ro":
					play = 1;
					break;
				case "pa":
					play = 2;
					break;
				case "sc":
					play = 4;
					break;
			}

			if (rand.nextInt(3) == 1) {
				System.out.printf("%s.\nI win!\n", option(play, false));
				losses++;
			}
			else if (rand.nextInt(2) == 1) {
				System.out.printf("%s.\nYou win!\n", option(play, true));
				wins++;
			}
			else {
				System.out.println("Me too. Draw!");
				draws++;
			}

			i++;
		}

		System.out.printf("\nWins: %d\nLosses: %d\nDraws: %d\n", wins, losses, draws);
	}
}
