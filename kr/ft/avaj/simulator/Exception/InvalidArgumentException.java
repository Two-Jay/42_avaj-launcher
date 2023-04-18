package kr.ft.avaj.simulator.Exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {
        super(buildExceptionMessage());
    }

    private static String buildExceptionMessage() {
        return "Exception : invalid argument in senario file.";
    }
}
