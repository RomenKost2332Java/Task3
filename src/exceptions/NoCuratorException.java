package exceptions;

/**
 * Called when Student.curator are set null.
 *
 * @author Kostenko Roman
 */
public class NoCuratorException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage() + "Every group must have a curator. ";
    }
}
