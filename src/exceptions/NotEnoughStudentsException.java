package exceptions;

public class NotEnoughStudentsException extends WrongStudentsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough students. ";
    }
}
