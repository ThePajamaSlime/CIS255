public class Blanket {
	public enum Size {
		TWIN,
		QUEEN,
		KING,
	}

	public enum Material {
		WOOL,
		CASHMERE,
	}

	private static final int C_WHITE  = 0;
	private static final int C_RED    = 1;
	private static final int C_ORANGE = 2;
	private static final int C_YELLOW = 3;
	private static final int C_BLUE   = 4;
	private static final int C_PURPLE = 5;
	private static final int C_GREEN  = 6;
	private static final int C_BLACK  = 7;

	protected Size size;
	protected Material material;
	protected int color;

	public Blanket(Size s, Material m, int c) {
		size = s;
		material = m;
		color = (c < C_WHITE || c > C_BLACK) ? C_WHITE : c;
	}
	
	public Blanket() {
		size = Size.TWIN;
		material = Material.WOOL;
	}

	public double getCost() {
		double cost = 30;
		
		switch (material) {
			case Material.WOOL:     cost += 20; break;
			case Material.CASHMERE: cost += 45; break;
		}

		switch (size) {
			case Size.TWIN:  cost += 10; break;
			case Size.QUEEN: cost += 25; break;
			case Size.KING:  cost += 40; break;
		}

		return cost;
	}

	public void setSize(Size s) { size = s;	}
	public void setMaterial(Material s) { material = s; }
	public void setColor(int c) { color = (c < C_WHITE || c > C_BLACK) ? C_WHITE : c; }

	public String toString() {
		return "Size: " + size.name() + "\nMaterial: " + material.name() + "\nCost: " + getCost();
	}
}
