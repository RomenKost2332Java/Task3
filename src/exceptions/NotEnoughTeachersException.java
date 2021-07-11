package exceptions;

/**
 * Called when there isn't enough teachers in Department.teachers.
 *
 * @author Kostenko Roman
 */
public class NotEnoughTeachersException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough teachers. ";
    }
}
