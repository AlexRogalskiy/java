/**
*
*   Custom EmptyStackException implementation
*
*/
public class EmptyStackException extends Exception {
    public EmptyStackException() {}

    public EmptyStackException (String message) {
        super(message);
    }

    public EmptyStackException (Throwable cause) {
        super(cause);
    }

    public EmptyStackException (String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
    	return super.toString();
    	//return "EmptyStackException {message: " + this.getMessage() + "}";
    }

    @Override
    public String getMessage() {
    	return super.getMessage();
    }
 }