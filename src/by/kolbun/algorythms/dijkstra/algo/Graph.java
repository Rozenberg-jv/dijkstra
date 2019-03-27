package by.kolbun.algorythms.dijkstra.algo;

import java.util.HashSet;
import java.util.Set;

public class Graph {

	private static final int PRECISION = 4;
	static final double E = Math.pow(10, PRECISION);
	static final double EPS = 1 / E;

	private Set<Point> graph = new HashSet<>();

	public void connect(Point in, Point... what) {

		in.addConnectedPoint(what);

		graph.add(in);
	}

	public Path getShortestPath(Point p1, Point p2) {

		return new Dijkstra().getShortestPath(p1, p2);
	}

	public Point getPoint(double x, double y) {

		Point lookFor = new Point(x, y);
		return graph.stream().filter(p -> p.equals(lookFor)).findAny().orElse(null);
	}

	public Point getNearestPoint(double x, double y) {

		Point p = new Point(x, y);
		double minDistance = Double.MAX_VALUE;
		Point nearest = null;

		for (Point point : graph) {
			double distance = point.distance(p);
			if (distance < minDistance) {
				minDistance = distance;
				nearest = point;
			}
		}

		return nearest;
	}

	public Set<Point> getGraph() {

		return graph;
	}
}
