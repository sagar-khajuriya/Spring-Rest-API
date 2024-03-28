package in.company.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.company.error.ErrorDetails;
import in.company.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorControllerAdvice {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException tnfe){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),tnfe.getMessage(),"404-Not_Found");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"500-Server_Error");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
