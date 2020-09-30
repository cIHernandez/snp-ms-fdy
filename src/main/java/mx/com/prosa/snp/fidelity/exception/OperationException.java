package mx.com.prosa.snp.fidelity.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class OperationException {
	private final ZonedDateTime timestamp;
	private final int status;
	private final String error;
	private final String message;
	private final String path;
	


	public OperationException(ZonedDateTime timestamp, int status, String error, String message,String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getPath() {
		return path;
	}
	
	
	

}
