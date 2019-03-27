package test;

import by.kolbun.algorythms.dijkstra.algo.Graph;
import by.kolbun.algorythms.dijkstra.algo.Path;
import by.kolbun.algorythms.dijkstra.algo.Point;

@SuppressWarnings("Duplicates")
public class Main {

	public static void main(String[] args) {

		//		Dijkstra algorithm = new Dijkstra();
		Graph graph = new Graph();

		Point p1 = new Point("point1", 10, 10);
		Point p2 = new Point("point2", 10, 20);
		Point p3 = new Point("point3", 30, 20);
		Point p4 = new Point("point4", 20, 30);
		Point p5 = new Point("point5", 40, 30);
		Point p6 = new Point("point6", 20, 40);
		Point p7 = new Point("point7", 30, 40);
		Point p8 = new Point("point8", 20, 60);
		Point p9 = new Point("point9", 30, 60);
		Point p10 = new Point("point10", 30, 70);
		Point p11 = new Point("point11", 50, 60);
		Point p12 = new Point("point12", 60, 40);
		Point p13 = new Point("point13", 40, 50);
		Point p14 = new Point("point14", 60, 10);
		Point p15 = new Point("point15", 50, 20);

		graph.connect(p1, p2, p14);
		graph.connect(p2, p1, p3, p4);
		graph.connect(p3, p2, p5, p15);
		graph.connect(p4, p2, p6);
		graph.connect(p5, p3, p7, p12, p13);
		graph.connect(p6, p4, p7, p8);
		graph.connect(p7, p5, p6, p9);
		graph.connect(p8, p6, p10);
		graph.connect(p9, p7, p10, p13);
		graph.connect(p10, p8, p9, p11);
		graph.connect(p11, p10, p12, p13, p15);
		graph.connect(p12, p5, p11, p14);
		graph.connect(p13, p5, p9, p11);
		graph.connect(p14, p1, p12);
		graph.connect(p15, p3, p11);
/*

		Path shortestPath = graph.getShortestPath(p1, p11);
		System.out.println(shortestPath.getPath().size() == 6);
		shortestPath = graph.getShortestPath(p6, p6);
		System.out.println(shortestPath.getPath().size() == 1 && shortestPath.getDistance() == 0);
		shortestPath = graph.getShortestPath(p6, p7);
		System.out.println(shortestPath.getPath().size() == 2 && shortestPath.getDistance() == 10);
		shortestPath = graph.getShortestPath(p8, p14);
		System.out.println(shortestPath.getPath().size() == 5 && (int)(shortestPath.getDistance()) == 88);
*/
		/*p5.setCoef(10);
		p11.setCoef(10);
		p13.setCoef(10);
		Path path = graph.getShortestPath(p9, p12);
		System.out.println(path);*/

	}
}
