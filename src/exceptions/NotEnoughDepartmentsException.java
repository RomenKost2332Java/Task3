package exceptions;

public class NotEnoughDepartmentsException extends WrongElementsAmountException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Not enough departments. ";
    }
}

