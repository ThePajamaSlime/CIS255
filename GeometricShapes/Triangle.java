public class Triangle extends GeometricFigure {
	double area;

	public Triangle(double b, double h) { area = (b*h)/2.0; }

	public double area() { return area; }
	public String displaySides() { return "A triangle has 3 sides."; }

	public String toString() { return "Triangle(Area=" + area + ")"; }

}
