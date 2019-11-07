package hibernate.reference.demohibernate.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException {

    private final Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);

    public CustomerNotFoundException(String message) {
        super(message);
        logger.info(message);
    }

}
