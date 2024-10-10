public class Square extends GeometricFigure {
	double area;

	public Square(double h) { area = h*h; }

	public double area() { return area; }
	public String displaySides() { return "A square has 4 sides.";}

	public String toString() { return "Square(Area=" + area + ")"; }
}
