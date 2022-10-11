package menus.excepctions;

public class ObjectIsBlankException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectIsBlankException (String msg) {
		super(msg);
	}
}
