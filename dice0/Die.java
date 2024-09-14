import java.util.Random;

public class Die {
	static final int LO_VAL = 1;
	static final int HI_VAL = 6;

	int value;
	Random rand = new Random();

	public Die() {

		value = rand.nextInt(HI_VAL) + 1;
	}

	public int roll() {

		return value = rand.nextInt(HI_VAL) + 1;

	}

	public int get() { return value; }

}
