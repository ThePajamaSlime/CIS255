/* Khamanei Ainsworth
 * Fri. June 21, 2024
 * Die.java
 * sorta like Yachtzee,
 * roll some dice and whoever
 * rolls more of a kind wins
 * (e.x. 3-of-a-kind beats 2-of-a-kind)
 * uses weird RNG because i thought it'd be easier to program
 * suffice to say, unlike in real life, all die matches (from 0 to 5-of-a-kind)
 * are equally likely to occur (1/5 chance each)
 */
import java.util.Random;
import java.util.Arrays;

public class Die {
	static final int DICE_COUNT = 5;

	static String dice(int pull) {
		Random rand = new Random();
		int num = rand.nextInt(6) + 1;
		int r = rand.nextInt(6) + 1;

		int[] x = new int[DICE_COUNT];
		for (int i = 0; i < DICE_COUNT; i++) {
			do { r = (r == 6) ? 1 : ++r; } while (r == num);

			x[i] = (pull-- >= 0) ? num : r;
		}

		return Arrays.toString(x);
	}

	public static void main(String[] args) {
		Random rand = new Random();

		int pull1 = rand.nextInt(5);
		int pull2 = rand.nextInt(5);

		/* 0 = no pairs
		 * 1 = 2-of-a-kind
		 * 2 = 3..
		 * 3 = 4...
		 * 4 = all die matching
		 */

		System.out.printf("CMP rolled(%d)\t%s\n", pull1+1, dice(pull1));
		System.out.printf("YOU rolled(%d)\t%s\n", pull2+1, dice(pull2));

		if (pull1 > pull2) { // computer win
			System.out.println("You lose!");
		}
		else if (pull1 < pull2) {
			System.out.println("You win!");
		}
		else {
			System.out.println("A draw!?");
		}
	}
}
