public class ElectricBlanket extends Blanket {
	int heatOpt;
	boolean auto;

	public ElectricBlanket() {
		heatOpt = 1;
		auto = false;
	}

	public ElectricBlanket(int o, boolean a) {
		heatOpt = (o < 1 || o > 5) ? 1 : o;
		auto = a;
	}

	public int     getHeatOpt() { return heatOpt; }
	public boolean getAuto()    { return auto; }
	public double  getCost()    { return super.getCost() + (auto ? 5.75 : 0); }

	public void setHeatOpt(int o)  { heatOpt = (o < 1 || o > 5) ? 1 : o; }
	public void setAuto(boolean a) { auto = a; }

	public String toString() {
		return super.toString() + "\nHeat Settings: " + heatOpt + "\nAuto-Shutoff: " + auto;
	}


}
