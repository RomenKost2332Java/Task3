package exceptions;

/**
 * Called when there isn't enough groups in Department.groups.
 *
 * @author Kostenko Roman
 */
public class NotEnoughGroupsException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough groups. ";
    }
}
