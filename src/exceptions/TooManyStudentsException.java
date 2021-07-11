package exceptions;

/**
 * Called when there is too many students in Group.students.
 *
 * @author Kostenko Roman
 */
public class TooManyStudentsException extends WrongStudentsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Too many students. ";
    }
}
