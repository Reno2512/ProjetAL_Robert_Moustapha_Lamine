package exception;

public class WebServiceException extends Exception{
    public WebServiceException(String errorString) {
        super(errorString);
    }

}
