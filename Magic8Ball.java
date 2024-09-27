import java.util.Scanner;
import java.util.Random;

public class Magic8Ball {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		Random rand = new Random();

		String responses[] = {
			"I have a ball. Perhaps you could bounce it.",
			"Hm? Oh, yeah, sure, definitely, totally, for sure. Yeah.",
			"What? No.",
			"When pigs fly.",
			"Ask again less stupidly.",
			"Not with that attitude.",
			"Tough question.",
			"Ask your mother.",
			"No, that's dumb.",
			"Yes, that could feasibly occur.",
			"I can guarantee it for a small fee.",
			"Ha. Haha! HAHAHAH! AAHAHAHHA! ...No.",
			"You don't want to know the answer to that.",
			"With a little bit of luck, it just might happen.",
			"I dunno.",
			"I don't see why not.",
			"Perhaps you'd prefer to lie down a while.",
			"I think you already know the answer to that.",
			"What're you asking me for?",
			"Don't get your hopes up."
		};

		while (true) {
			if (stdin.nextLine() == "") break;
			System.out.println(responses[rand.nextInt(20)]);
		}
	}
}
