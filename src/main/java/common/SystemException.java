package common;

public class SystemException extends Exception {

	private Throwable cause;

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public SystemException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

}
