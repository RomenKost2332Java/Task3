package exceptions;

public class NoCuratorException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage() + "Every group must have a curator. ";
    }
}
