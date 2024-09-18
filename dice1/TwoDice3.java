import java.util.Scanner;

public class TwoDice3 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		Die Dice = new Die();

		System.out.printf("Choose a number (0-12): ");
		// Error checking? Never heard of 'er!

		int choice = stdin.nextInt();

		int roll = 0;
		for (int i = 0; i < 3; i++) {
			System.out.printf("You rolled %d.\n", roll = Dice.roll() + Dice.roll());
			if (roll == choice) {
				 System.out.println("You win!");
				 break;
			}
		}

		if (roll != choice) {
			System.out.println("Out of rolls. You lose!");
		}
	}
}
