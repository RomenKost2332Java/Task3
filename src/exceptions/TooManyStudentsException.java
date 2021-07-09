package exceptions;

public class TooManyStudentsException extends WrongStudentsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Too many students. ";
    }
}
