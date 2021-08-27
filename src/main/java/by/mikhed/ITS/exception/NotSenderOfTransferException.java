package by.mikhed.ITS.exception;

public class NotSenderOfTransferException extends RuntimeException {

    public NotSenderOfTransferException(String message) {
        super(message);
    }
}
