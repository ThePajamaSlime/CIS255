import java.util.Scanner;

public class UseGeometric {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		SidedObject figures[] = new SidedObject[5];

		System.out.println("Create 5 shapes by entering side lengths. Enter 1-character name (s=square, t=triangle) followed by the appropiate number of sides.");
		for (int i=0; i < 5; i++) {
			char c = stdin.next().charAt(0);

			double h = stdin.nextDouble();
			if (c == 't') {
				double b = stdin.nextDouble();
				figures[i] = new Triangle(b, h);
			} 
			else {
				figures[i] = new Square(h);
			}
		}

		for (int i=0; i < 5; i++) {
			System.out.printf("\n%s\n", figures[i]);
		}
	}
}
