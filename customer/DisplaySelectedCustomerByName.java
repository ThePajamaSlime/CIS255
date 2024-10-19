import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DisplaySelectedCustomerByName {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Usage: DisplaySelectedCustomerByName lname\nlname - last name (string)");
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

				if (customer.lname.equals(args[0])) {
					found = true;
					customers.add(new Customer(customer));
				}
			}

			if (found) { 
				for (int i = 0; i < customers.size(); i++)
					System.out.print(customers.get(i).toString() + '\n');
			}
			else 
				System.out.println("No customer with that name found.");

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
