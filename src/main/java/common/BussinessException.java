package common;

public class BussinessException extends Exception {

	private Throwable cause;

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public BussinessException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

}
