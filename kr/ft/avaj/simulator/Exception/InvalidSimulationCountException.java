package kr.ft.avaj.simulator.Exception;

public class InvalidSimulationCountException extends RuntimeException {
    public InvalidSimulationCountException(String parsed) {
        super(buildLengthExceptionMessage(parsed));
    }

    private static String buildLengthExceptionMessage(String parsed) {
        return "Exception : invalid simulation count. (" + parsed + ")";
    }
}
