package by.kolbun.algorythms.dijkstra.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static by.kolbun.algorythms.dijkstra.algo.Graph.E;
import static by.kolbun.algorythms.dijkstra.algo.Graph.EPS;

public class Point {

	private String title = "";

	private final double x, y;

	private final Set<Point> connected;

	private double coef = 1;

	Point(double x, double y, Set<Point> connected) {

		this.x = x;
		this.y = y;

		this.connected = connected;
	}

	public Point(double x, double y) {

		this(x, y, new HashSet<>());
	}

	public Point(String title, double x, double y) {

		this(x, y);

		this.title = title;
	}

	public Point(String title, double x, double y, Set<Point> connected) {

		this(x, y, connected);

		this.title = title;
	}

	//
	void addConnectedPoint(Point... c) {

		connected.addAll(Arrays.asList(c));
	}

	double distance(Point p) {

		return this.distance(p.getX(), p.getY());
	}

	double mDistance(Point p) {

		return this.mDistance(p.getX(), p.getY());
	}

	private double mDistance(double x, double y) {

		double dx = Math.abs(this.x - x);
		double dy = Math.abs(this.y - y);

		return (dx + dy) * 0.8;
	}

	private double distance(double x, double y) {

		double dx = Math.abs(this.x - x);
		double dy = Math.abs(this.y - y);

		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	@Override
	public String toString() {

		return String.format("%s [%.3f,%.3f]", title.equals("") ? "Point" : title, x, y);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Point))
			return false;
		Point p = (Point) o;

		return Math.abs(this.getX() - p.getX()) <= EPS && Math.abs(this.getY() - p.getY()) <= EPS;
	}

	@Override
	public int hashCode() {

		return (int) ((Math.round(this.getX() * E) * 71 + Math.round(this.getY() * E)) % Integer.MAX_VALUE);
	}

	double getX() {

		return x;
	}

	double getY() {

		return y;
	}

	Set<Point> getConnected() {

		return connected;
	}

	public String getTitle() {

		return title;
	}

	public void setCoef(double coef) {

		this.coef = coef;
	}

	public double getCoef() {

		return coef;
	}
}
