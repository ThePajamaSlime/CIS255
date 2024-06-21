/* Khamanei Ainworth
 * Fri, June 21, 2024
 * some sort of card game,
 * both players choose a card,
 * the card with the higher value wins
 */

import java.util.Random;

public class War2 {
	public static void main(String[] args) {
		Random rand = new Random();

		int pull1 = rand.nextInt(13) + 1;
		int pull2 = rand.nextInt(13) + 1;

		Card card1 = new Card(pull1);
		Card card2 = new Card(pull2);

		if (pull1 > pull2) {
			System.out.printf("I got %s\nYou got %s\nYou-da loser!", card1, card2);
		}
		else if (pull1 < pull2) {
			System.out.printf("I got %s\nYou got %s\nYou-da winner!", card1, card2);
		}
		else {
			System.out.printf("I got %s\nYou got %s\nAt-odds!", card1, card2);
		}
	}
}
