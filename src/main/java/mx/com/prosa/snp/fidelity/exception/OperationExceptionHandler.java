package mx.com.prosa.snp.fidelity.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice	
public class OperationExceptionHandler {
	
	@ExceptionHandler(value={GenericException.class})
	public ResponseEntity<Object> genericOperationException(GenericException e){
		
		HttpStatus unauthorizedError = e.getStatus();
		OperationException operationException = new OperationException(ZonedDateTime.now(ZoneId.of("Z")), e.getStatus().value(),e.getStatus().getReasonPhrase(),e.getMessage(),"/");
		return new ResponseEntity<Object>(operationException, unauthorizedError);
	}

}
