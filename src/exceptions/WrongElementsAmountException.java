package exceptions;

/**
 * Called when there is wrong elements amount in any elements container.
 *
 * @author Kostenko Roman
 */
public class WrongElementsAmountException extends Exception {
    @Override
    public String getMessage(){
        return super.getMessage() + "- Wrong elements amount. ";
    }
}

