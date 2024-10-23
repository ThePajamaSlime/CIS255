import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class QuizUsingFile {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Usage: QuizUzingFile quizname\nquizname - name of quiz file");
			return;
		}


		try {
			FileWriter stats = new FileWriter("stats", true);
			String strStats = "";
			/* read stats */ {
				FileReader bstats = new FileReader("stats");
				Scanner rstats = new Scanner(bstats);
				try {
					strStats = rstats.useDelimiter("\\A").next();
				}
				catch (NoSuchElementException e) { }
				finally { rstats.close(); }
			}
			BufferedReader quiz = new BufferedReader(new FileReader(args[0]));
			Scanner quizin = new Scanner(quiz);
			Scanner stdin  = new Scanner(System.in);

			boolean found = false;
			int highScore = 0;
			long qpos = 0;
			String qname = quizin.nextLine();

			String[] tokens = strStats.split(args[0]);
			if (tokens.length == 1) 
				System.out.println("No scores recorded for this quiz.");
			else {
				Scanner sc = new Scanner(tokens[1]);
				highScore = sc.nextInt();
				tokens[1] = sc.useDelimiter("\\A").next();
				sc.close();
				System.out.printf("Highest Score for \"%s\": %d\n", qname, highScore);
			}

			int qnum  = 0;
			int score = 0;
			while (quizin.hasNext()) {
				String question = quizin.nextLine();
				String a1 = quizin.nextLine();
				String a2 = quizin.nextLine();
				String a3 = quizin.nextLine();
				String a4 = quizin.nextLine();
				String a = quizin.nextLine();

				System.out.printf("Qustion #%d: %s\n", ++qnum, question);
				System.out.printf("a) %s\nb) %s\nc) %s\nd) %s\n> ", a1, a2, a3, a4);

				char r = stdin.next().charAt(0);
				stdin.nextLine();

				if (r == a.charAt(0)) {
					 System.out.println("Correct!");
					 score++;
				}
			}

			System.out.printf("You got %d correct.\n", score);

			if (tokens.length == 1) {
				stats.write(args[0] + ' ' + score + '\n');
			}
			if (tokens.length > 1 && score > highScore) {
				FileWriter ostats = new FileWriter("stats", false);
				System.out.println("New High Score!");
				ostats.write(tokens[0] + args[0] + ' ' + score + '\n' + tokens[1]);
				ostats.close();
			}

			stats.close();
			quiz.close();
		}
		catch (FileNotFoundException e) {
			System.err.printf("File %s not found\n", args[0]);
			return;
		}
		catch (IOException e) {
			System.err.println("ioeception");
			e.printStackTrace();
		}
		catch (NoSuchElementException e) { 
			System.out.println("exit");
			// e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("other");
			e.printStackTrace();
		}
	}
}

