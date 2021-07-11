package exceptions;

/**
 * Called when there is wrong students amount in Group.students.
 *
 * @author Kostenko Roman
 */
public class WrongStudentsAmountException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Wrong students amount. ";
    }
}
