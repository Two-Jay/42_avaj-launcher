package kr.ft.avaj.simulator.Exception;

public class InvalidArgumentsException extends RuntimeException {
    public InvalidArgumentsException() {
        super(buildExceptionMessage());
    }

    private static String buildExceptionMessage() {
        return "Exception : invalid argument in senario file.";
    }
}
