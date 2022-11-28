package uz.atm.exceptions;

public class AppBadRequestException extends RuntimeException {

    public AppBadRequestException(String message) {
        super(message);
    }
}
