package exceptions;

public class WrongStudentsAmountException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Wrong students amount. ";
    }
}
