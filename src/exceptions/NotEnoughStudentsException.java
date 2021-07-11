package exceptions;

/**
 * Called when there isn't enough students in Group.students.
 *
 * @author Kostenko Roman
 */
public class NotEnoughStudentsException extends WrongStudentsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough students. ";
    }
}
