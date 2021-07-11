package exceptions;

/**
 * Called when there isn't enough departments in Faculty.departments.
 *
 * @author Kostenko Roman
 */
public class NotEnoughDepartmentsException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough departments. ";
    }
}

