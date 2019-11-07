package hibernate.reference.demohibernate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HibernateExceptionHandler {

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException() {
        return new ResponseEntity<String>("Customer Not Found", HttpStatus.NOT_FOUND);
    }

}
