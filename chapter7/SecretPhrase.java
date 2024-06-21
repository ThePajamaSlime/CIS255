/* Khamanei Ainsworth
 * Fri, June 21, 2024
 * SecretPhrase.Java
 * Hangman, but with infinite attempts
 * and also with German words
 * Errors:
 * program expects you to enter only 1 lowercase character at a time
 */
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class SecretPhrase {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		String phrases[] = { "Apfelsaft", "Schuh", "Schreibtisch", "Videospiel", "Geige", "Ausweis", "Museum", "Fahrrad" };

		String s = phrases[rand.nextInt(phrases.length)];
		char[] phrase = new char[s.length()];
		s.getChars(0, s.length(), phrase, 0);
		char[] guess = new char[s.length()];
		boolean[] known = new boolean[phrase.length];

		for (int i = 0; i < known.length; i++)
			known[i] = false;

		for (int i = 0; i < phrase.length; i++) {
			guess[i] = known[i] ? phrase[i] : '*';
		}

		while (!Arrays.equals(guess, phrase)) {
			System.out.println(guess);

			char in = input.next().charAt(0);

			for (int i = 0; i < phrase.length; i++) {
				if (in == Character.toLowerCase(phrase[i])) known[i] = true;
			}
			for (int i = 0; i < phrase.length; i++) {
				guess[i] = known[i] ? phrase[i] : '*';
			}

		}

		System.out.println(guess);
		System.out.println("Congrats on your big win.");
	}
}
