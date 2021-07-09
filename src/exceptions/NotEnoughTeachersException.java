package exceptions;

public class NotEnoughTeachersException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough teachers. ";
    }
}
