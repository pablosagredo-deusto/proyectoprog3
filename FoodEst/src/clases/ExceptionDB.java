package clases;

public class ExceptionDB extends Exception{
	private static final long serialVersionUID = 1L;

	public ExceptionDB(String message) {
		super(message);
	}
	
	public ExceptionDB(String message, Throwable e) {
		super(message, e);
	}
}
