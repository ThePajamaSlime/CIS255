public class FiveDice {
	public static void main(String[] args) {
		Die dice = new Die();

		for (int i = 0; i < 10; i++) {
			String plr = (i > 4) ? "YOU" : "CMP";
			System.out.printf("%s Roll #%d: %d\n", plr, i+1, dice.roll());
		}
	}
}
