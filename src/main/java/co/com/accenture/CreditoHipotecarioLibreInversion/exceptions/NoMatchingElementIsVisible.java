package co.com.accenture.CreditoHipotecarioLibreInversion.exceptions;

/**
 * We extend the AssertionError exception to indicate an application failure and
 * not a test failure
 */

public class NoMatchingElementIsVisible extends AssertionError {

	/**
	 * serialVersionUID which is used for versioning when you serialize instances of
	 * your class
	 */

	private static final long serialVersionUID = -8332498181674105791L;

	public NoMatchingElementIsVisible(String message, Throwable cause) {
		super(message, cause);
	}

}
