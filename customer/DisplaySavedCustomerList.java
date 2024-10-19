import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplaySavedCustomerList {
	public static void main(String args[]) {
		try {
			File records = new File("records");
			Scanner filein = new Scanner(records);

			while (filein.hasNext()) {
				int id = filein.nextInt();
				String fname = filein.next();
				String lname = filein.next();
				int bal = filein.nextInt();

				System.out.printf("ID: %d FNAME: %s LNAME: %s BALANCE: %s\n", id, fname, lname, bal);
			}

			filein.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("file not found, perchance");
		}
	}
}
