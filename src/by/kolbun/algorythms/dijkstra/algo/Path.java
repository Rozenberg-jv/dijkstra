package by.kolbun.algorythms.dijkstra.algo;

import java.util.List;

public class Path {

	private final List<Point> path;

	//
	private double straightDistance;

	private double distance;

	Path(List<Point> path) {

		this.path = path;
		recalc(path);
	}

	private void recalc(List<Point> path) {

		int l = path.size();

		Point last = path.get(l - 1);
		Point first = path.get(0);

		this.straightDistance = last.distance(first);

		double dist = 0;
		for (int i = 1; i < l; i++) {
			Point prev = path.get(i - 1);
			Point cur = path.get(i);

			dist += cur.distance(prev);
		}

		this.distance = dist;
	}

	public List<Point> getPath() {

		return path;
	}

	public double getStraightDistance() {

		return straightDistance;
	}

	public double getDistance() {

		return distance;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Path:\n").append("distance: ").append(String.format("%.3f", distance)).append("\nstraight: ").append(String.format("%.3f", straightDistance))
				.append("\npoints: ");

		for (Point p : path) {
			sb.append("\n").append(p);
		}

		return sb.toString();
	}
}
