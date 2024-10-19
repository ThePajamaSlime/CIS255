import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteCustomerList {
	public static void main(String args[]) {
		FileWriter records;

		try {
			records = new FileWriter("records", true);
		}
		catch (IOException e) {
			System.err.println("error");
			e.printStackTrace();
			return;
		}
		Scanner stdin = new Scanner(System.in);

		System.out.println("Type -1 to exit. Enter records in format:\nID FNAME LNAME BALANCE\n");

		while (true) {
			String record = "";

			try {
				int id = stdin.nextInt();
				if (id == -1) break;
				String fname = stdin.next();
				String lname = stdin.next();
				int bal = stdin.nextInt();

				record = String.format("%d %s %s %d\n", id, fname, lname, bal);
			}
			catch (Exception e) {
				System.err.println("Did not parse.");
				stdin.nextLine();
				stdin.reset();
				continue;
			}
			
			try {
				records.write(record);
			}
			catch (IOException e) {
				System.err.println("error");
				e.printStackTrace();
			}
		
		}
		try {
			records.close();
		}
		catch (IOException e) {
			System.err.println("err while closing\n");
			e.printStackTrace();
		}
	}
}
