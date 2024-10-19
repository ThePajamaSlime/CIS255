import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer {
	public int id;
	public int balance;
	public String lname;
	public String fname;

	public Customer() {
		id = 0;
		balance = 0;
		lname = "";
		fname = "";
	}

	public Customer(int i, String l, String f, int b) {
		id = i;
		lname = l;
		fname = f;
		balance = b;
	}

	public Customer(Customer c) {
		this.id = c.id;
		this.balance = c.balance;
		this.lname = c.lname;
		this.fname = c.fname;
	}

	public String toString() {
		return "ID: " + id + " FNAME: " + fname + " LNAME: " + lname + " BALANCE: " + balance;
	}
}
