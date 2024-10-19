import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DisplaySelectedCustomerByBalance {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Usage: DisplaySelectedCustomerByBalance bal\nbal - an integer");
			return;
		}

		int id = 0;
		try { id = Integer.parseInt(args[0]); }
		catch (NumberFormatException e) {
			System.out.println("Usage: DisplaySelectedCustomerByBalance bal\nbal - an integer");
			return;
		}

		try {
			File records = new File("records");
			Scanner filein = new Scanner(records);

			boolean found = false;
			Customer customer = new Customer();
			ArrayList<Customer> customers = new ArrayList<>();

			while (filein.hasNext()) {
				customer.id  = filein.nextInt();
				customer.fname = filein.next();
				customer.lname = filein.next();
				customer.balance = filein.nextInt();

				if (customer.balance > Integer.parseInt(args[0])) {
					found = true;
					customers.add(new Customer(customer));
				}
			}

			if (found) { 
				for (int i = 0; i < customers.size(); i++)
					System.out.print(customers.get(i).toString() + '\n');
			}
			else 
				System.out.println("No customer with that balance found.");

			filein.close();
		}
		catch (IOException e) {
			System.err.println("huh?");
		}
		catch (Exception e) {
			System.err.println("what?");
			e.printStackTrace();
		}
	}
}
