package by.kolbun.algorythms.dijkstra.algo;

import by.kolbun.algorythms.dijkstra.exception.NoSuchPointInGraphException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static by.kolbun.algorythms.dijkstra.algo.Graph.E;
import static by.kolbun.algorythms.dijkstra.algo.Graph.EPS;

class Dijkstra {

	private Comparator<Node> nodeComparator = Comparator.comparingDouble(n -> n.F);

	private HashSet<Node> opened = new HashSet<>();
	private HashSet<Node> closed = new HashSet<>();

	Path getShortestPath(Point from, Point to) {

		Node current;

		opened.add(new Node(from));
		Node toNode = new Node(to);

		while (!opened.contains(toNode) && !opened.isEmpty()) {

			current = opened.stream().min(nodeComparator).get();

			opened.remove(current);

			closed.add(current);

			Node sibl;
			for (Point point : current.getConnected()) {

				sibl = new Node(point);

				if (closed.contains(sibl))
					continue;

				double dG = current.G + current.distance(sibl) * sibl.getCoef();

				if (!opened.contains(sibl)) {

					opened.add(sibl);
					sibl.G = dG;
					sibl.H = to.mDistance(sibl);
					sibl.reF();
					sibl.parent = current;
				} else {
					Node oldSibl = new Node(new Point(sibl.getX(), sibl.getY()));
					sibl = opened.stream().filter(n -> n.equals(oldSibl)).findAny().orElseThrow(() -> new NoSuchPointInGraphException(""));
					if (sibl.G > dG) {
						sibl.G = dG;
						sibl.reF();
						sibl.parent = current;
					}
				}
			}
		}

		if (opened.isEmpty())
			throw new NoSuchPointInGraphException("Point does not belong to the graph");

		Node tempNode = opened.stream().filter(n -> n.equals(toNode)).findFirst().orElseThrow(RuntimeException::new);

		List<Point> result = new ArrayList<>();

		result.add(tempNode);
		while (tempNode.parent != null) {
			result.add(tempNode.parent);
			tempNode = tempNode.parent;
		}
		//		System.out.printf("distance: %.3f\n", ((Node) result.get(0)).G);

		return new Path(result);
	}

	class Node extends Point {

		/**
		 * passed path from start
		 */
		private double G;
		/**
		 * heuristic path to goal
		 */
		private double H;
		/**
		 * sum G + H
		 */
		private double F;

		/**
		 * parent node on path
		 */
		private Node parent;

		Node(Point point) {

			super(point.getTitle(), point.getX(), point.getY(), point.getConnected());

			this.setCoef(point.getCoef());

			G = 0;
			H = 0;
			F = G + H;
		}

		@Override
		public boolean equals(Object o) {

			if (this == o)
				return true;
			if (!(o instanceof Node))
				return false;
			Node node = (Node) o;

			return Math.abs(this.getX() - node.getX()) <= EPS && Math.abs(this.getY() - node.getY()) <= EPS;
		}

		@Override
		public int hashCode() {

			return (int) ((Math.round(this.getX() * E) * 71 + Math.round(this.getY() * E)) % Integer.MAX_VALUE);
		}

		private void reF() {

			this.F = G + H;
		}

		@Override
		public String toString() {

			return super.toString() + " F = " + F;
		}

	}

}
