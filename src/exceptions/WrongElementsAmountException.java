package exceptions;

public class WrongElementsAmountException extends Exception {
    @Override
    public String getMessage(){
        return super.getMessage() + "- Wrong elements amount. ";
    }
}

