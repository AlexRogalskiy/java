/**
*
*   Custom EmptyQueueException implementation
*
*/
public class EmptyQueueException extends Exception {
    public EmptyQueueException() {}

    public EmptyQueueException (String message) {
        super(message);
    }

    public EmptyQueueException (Throwable cause) {
        super(cause);
    }

    public EmptyQueueException (String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
    	return super.toString();
    	//return "EmptyQueueException {message: " + this.getMessage() + "}";
    }

    @Override
    public String getMessage() {
    	return super.getMessage();
    }
 }