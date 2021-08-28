package by.mikhed.ITS.exception;

public class CountryAlreadyExistException extends RuntimeException {

    public CountryAlreadyExistException(String message) {
        super(message);
    }
}
