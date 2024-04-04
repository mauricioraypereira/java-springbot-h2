package ray.mauricio.spring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import ray.mauricio.spring.services.exceptions.DatabaseException;
import ray.mauricio.spring.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não foi encontrado";
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), 
				httpStatus.value(), 
				error, 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Erro de banco de dados";
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), 
				httpStatus.value(), 
				error, 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
}
