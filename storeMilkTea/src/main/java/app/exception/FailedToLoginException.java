package app.exception;

public class FailedToLoginException extends Exception {
    public FailedToLoginException(String username) {
        super(username);
    }
}
