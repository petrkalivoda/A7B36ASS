package visitorChallenge.exception;

import visitorChallenge.ExceptionVisitor;


public class SearchException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public SearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchException(String message) {
        super(message);
    }
    
    public void accept(ExceptionVisitor v) {
        v.visit(this);
    }
}
