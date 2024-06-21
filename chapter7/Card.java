import java.util.Random;

public class Card {
	private String suit;
	private String rank_str;
	private int rank;
	private Random rand = new Random();

	public void setValue(int val) {
		rank = val;

		switch (val) {
			case 1:
				rank_str = "Ace";
				break;
			case 11:
				rank_str = "Jack";
				break;
			case 12:
				rank_str = "Queen";
				break;
			case 13:
				rank_str = "King";
				break;
			default:
				rank_str = Integer.toString(val);
				break;
		}

	}

	public Card(int val) {
		setValue(val);

		switch (rand.nextInt(4)) {
			case 0:
				suit = "Clubs";
				break;
			case 1:
				suit = "Spades";
				break;
			case 2:
				suit = "Diamonds";
				break;
			case 3:
				suit = "Hearts";
				break;
		}
	}


	public String toString() {
		return rank_str + " of " + suit;
	}
}
