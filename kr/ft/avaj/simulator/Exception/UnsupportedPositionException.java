package kr.ft.avaj.simulator.Exception;

public class UnsupportedPositionException extends RuntimeException {
    public UnsupportedPositionException() {
        super(ErrorMessage.of("Unsupported position"));
    }
}
