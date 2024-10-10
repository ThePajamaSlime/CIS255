import java.util.Scanner;

public class DemoBlanket {
	public static void main (String args[]) {
		Scanner stdin = new Scanner(System.in);
		System.out.println("Type -1 to exit");

		System.out.println("Blanket:");
		while (true) {
			Blanket.Size size = Blanket.Size.TWIN;
			Blanket.Material mat = Blanket.Material.WOOL;
			Blanket b = new Blanket(size, mat, 0);
			int choice = 0;

			System.out.print("Size (0-2): ");
			try { choice = stdin.nextInt(); }
			catch (Exception e) { break; }
			if (choice == -1) break;

			switch (choice) {
				case 0: size = Blanket.Size.TWIN;  break;
				case 1: size = Blanket.Size.QUEEN; break;
				case 2: size = Blanket.Size.KING;  break;
				default: size = Blanket.Size.TWIN;
			}

			System.out.print("Material (0-1): ");
			try { choice = stdin.nextInt(); }
			catch (Exception e) { break; }
			if (choice == -1) break;

			switch (choice) {
				case 0: mat = Blanket.Material.WOOL;     break;
				case 1: mat = Blanket.Material.CASHMERE; break;
				default: mat = Blanket.Material.WOOL;
			}

			b.setMaterial(mat);
			b.setSize(size);
			System.out.printf("\n%s\n\n", b);
		}

		System.out.println("\nElectric Blanket:");
		while (true) {
			Blanket.Size size = Blanket.Size.TWIN;
			Blanket.Material mat = Blanket.Material.WOOL;
			int heatOpt = 1;
			boolean auto = false;
			ElectricBlanket b = new ElectricBlanket(heatOpt, auto);
			int choice = 0;

			System.out.print("Size (0-2): ");
			try { choice = stdin.nextInt(); }
			catch (Exception e) { break; }
			if (choice == -1) break;

			switch (choice) {
				case 0: size = Blanket.Size.TWIN;  break;
				case 1: size = Blanket.Size.QUEEN; break;
				case 2: size = Blanket.Size.KING;  break;
				default: size = Blanket.Size.TWIN;
			}

			System.out.print("Material (0-1): ");
			try { choice = stdin.nextInt(); }
			catch (Exception e) { break; }
			if (choice == -1) break;

			switch (choice) {
				case 0: mat = Blanket.Material.WOOL;     break;
				case 1: mat = Blanket.Material.CASHMERE; break;
				default: mat = Blanket.Material.WOOL;
			}

			System.out.print("Heat Options (1-5): ");
			try { choice = stdin.nextInt(); }
			catch (Exception e) { break; }
			heatOpt = choice;

			System.out.print("Auto-Shutoff (0-1):");
			try { choice = stdin.nextInt(); }
			catch (Exception e) { break; }
			auto = choice == 1;

			b.setMaterial(mat);
			b.setSize(size);
			b.setHeatOpt(heatOpt);
			b.setAuto(auto);
			System.out.printf("\n%s\n\n", b);
		}



	}
}
