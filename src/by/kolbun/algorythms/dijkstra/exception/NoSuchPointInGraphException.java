package by.kolbun.algorythms.dijkstra.exception;

public class NoSuchPointInGraphException extends RuntimeException {

	public NoSuchPointInGraphException(Exception e) {

		super(e);
	}

	public NoSuchPointInGraphException(String message) {

		super(message);
	}
}
