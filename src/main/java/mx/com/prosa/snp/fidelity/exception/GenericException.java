package mx.com.prosa.snp.fidelity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GenericException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 718782461106555825L;
	HttpStatus status;
	public GenericException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
	public HttpStatus getStatus() {
		return status;
	}

}
