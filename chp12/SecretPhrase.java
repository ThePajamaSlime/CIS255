/* Khamanei Ainsworth
 * Sat, Nov 2, 2024
 * SecretPhrase.Java
 * Hangman, but with infinite attempts
 * and also with German words
 * ...now also modified to take phrases from a phile
 * Errors:
 * program expects you to enter only 1 lowercase character at a time
 */
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class SecretPhrase {
	public static void main(String[] args) {
		FileReader phrases = null;	
		String path = "phrases.txt";

		if (args.length == 0) {
			try {
				phrases = new FileReader(path);
			}
			catch (FileNotFoundException e) {
				System.err.println("No phrases.txt file found");
				return;
			}
		}
		else if (args.length == 1) {
			try {
				path = args[0];
				phrases = new FileReader(path);
			}
			catch (FileNotFoundException e) {
				System.err.printf("File %s not found\n", args[0]);
				return;
			}
		}
		else {
			System.err.println("Usage: SecretPhraseUsingFile [file]\nfile - a file containing line-seperated phrases. Defaults to phrases.txt if not specified.");
			return;	
		}
		
		long lineCo = 0;
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			lineCo = stream.count();
		}
		catch (IOException e) { }

		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		String s = "";
		try {
			s = Files.readAllLines(Paths.get(path)).get(rand.nextInt((int)lineCo));
		}
		catch (IOException e) { }
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
