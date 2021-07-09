package exceptions;

public class NotEnoughGroupsException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough groups. ";
    }
}
