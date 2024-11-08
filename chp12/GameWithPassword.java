import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GameWithPassword {
	public static void main(String args[]) {
		if (args.length != 2) {
			System.err.println("Please enter a username or password.");
			return;
		}
		
		boolean found = false;
		try {
			FileReader data = new FileReader("players.txt");
			Scanner datain = new Scanner(data);
			while (datain.hasNext()) {
				String tokens[] = datain.nextLine().split("\\s+");
				if (!args[0].equals(tokens[0]) || !args[1].equals(tokens[1])) continue;
				// change this line to use other programs
				else {
					found = true;
					RockPaperScissors2_1.play();
				}
			}
		}
		catch (IOException e) {
			System.err.println("IO error");
			return;
		}
		if (!found) System.err.println("Username not found or wrong password");
	}
}
