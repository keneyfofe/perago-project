package za.co.perago.exceptions;

/**
 * Implement or modify this class as you see fit
 *
 */
public class DiffException extends RuntimeException {

	private static final long serialVersionUID = -7698912729249813850L;
	
	 public DiffException() {
	        super("Unsupported diffing occured.");
	    }

}
