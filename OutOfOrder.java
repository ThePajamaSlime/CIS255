import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class OutOfOrder {
	static void display(String list[]) {
		System.out.println("Type the index of the first element that appears out of order!");
		for (int i = 0; i < list.length; i++) System.out.print(list[i] + ' ');
		System.out.println();
	}

	static boolean checkAnswer(int answer) {
		Scanner stdin = new Scanner(System.in);
		boolean fail = false;
		do {
			try {
				if (answer+1 == stdin.nextInt()) {
					System.out.print("YES!");
					return false;
				}
				else {
					System.out.println("Get your eyes checked!");
					return true;
				}
			}
			catch (InputMismatchException e) {
				System.err.println("Integers only, please!");
				stdin.nextLine();
				fail = true;
			}
		}
		while (fail);
		return false;
	}

	public static void main(String args[]) {
		String lists[][] = {
			{ "A", "B", "C", "D", "E", "F", "G"},
			{ "10","20","30","40","50","60","70","80","90"},
			{ "two", "four", "six", "eight", "ten", "twelve"},
		};

		Random rand = new Random();

		String list[] = lists[(rand.nextInt(lists.length))];
		int answer = rand.nextInt(list.length);
		/* swap two elements at random */ {
			int swap = 0;
			while ((swap = rand.nextInt(list.length)) == answer);
			String tmp 	 = list[answer];
			list[answer] = list[swap];
			list[swap]   = tmp;

			// if the swapped variable appears earlier in the list,
			// change answer to it
			if (swap < answer) {
				answer += swap;
				swap = answer - swap;
				answer -= swap;
			}
		}

		display(list);
		while (checkAnswer(answer));

	}
}
