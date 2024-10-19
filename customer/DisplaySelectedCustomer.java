import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplaySelectedCustomer {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Usage: DisplaySelectedCustomer id\nid - an integer");
			return;
		}

		int id = 0;
		try { id = Integer.parseInt(args[0]); }
		catch (NumberFormatException e) {
			System.out.println("Usage: DisplaySelectedCustomer id\nid - an integer");
			return;
		}
		
		try {
			File records = new File("records");
			Scanner filein = new Scanner(records);

			boolean found = false;
			String fname = "";
			String lname = "";
			int bal = 0;
			while (filein.hasNext()) {
				int rid = filein.nextInt();
				fname = filein.next();
				lname = filein.next();
				bal   = filein.nextInt();

				if (rid == id) {
					found = true;
					break;
				}
			}

			if (found) 
				System.out.printf("ID: %d FNAME: %s LNAME: %s BALANCE: %d", id, fname, lname, bal);
			else 
				System.out.println("No customer with that ID found.");

			filein.close();
		}
		catch (IOException e) {
			System.err.println("huh?");
		}
		catch (Exception e) {
			System.err.println("what?");
		}
	}
}
