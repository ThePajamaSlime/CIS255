import java.util.Scanner;

public class PigDiceGame {
	private static String getName(boolean plr) {
		if (plr) return "CMP";
		else return "YOU";
	}

	public static void main(String[] args) {
		Die Dice = new Die();
		Scanner stdin = new Scanner(System.in);
		boolean plr = false;

		System.out.println("Let's play Pig. First to 100 wins!");

		int YOUscore = 0, CMPscore = 0;

		while (YOUscore < 100 && CMPscore < 100) {
			plr = !plr;
			System.out.printf("%s turn.\n", getName(plr));

			int roll1 = 0, roll2 = 0;
			System.out.printf("%s rolled %d + %d (%d).\n", getName(plr), roll1 = Dice.roll(), roll2 = Dice.roll(), roll1 + roll2);
			if (roll1 == 1 | roll2 == 1) {
				if (roll1 == 1 && roll2 == 1) {
					 System.out.printf("Snake eyes! %s score reset to 0!\n", getName(plr));
					 if (plr) CMPscore = 0;
					 else YOUscore = 0;
				}
				else System.out.println("Rolled a 1. Turn ended!\n");
				continue;
			}


			if (plr) CMPscore += roll1 + roll2;
			else YOUscore += roll1 + roll2;

			System.out.printf("CMP Score: %d\nYOU score: %d\n", CMPscore, YOUscore);
			if (YOUscore >= 100 | CMPscore >= 100) break;


			if (plr) {// computer 
				if (Dice.roll() % 2 == 0) plr = !plr;
				else System.out.println("Turn ended!\n");
			}
			else {
				System.out.printf("Roll again? (y/n) ");

				if (stdin.next().charAt(0) == 'y') plr = !plr;
				System.out.println("Turn ended!\n");
			}
		}

		System.out.printf("%s WON!\n", getName(plr));
	}
}
