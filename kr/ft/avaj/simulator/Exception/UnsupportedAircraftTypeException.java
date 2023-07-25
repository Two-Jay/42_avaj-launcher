package kr.ft.avaj.simulator.Exception;

public class UnsupportedAircraftTypeException extends RuntimeException {
    public UnsupportedAircraftTypeException() {
        super(ErrorMessage.of("Unsupported aircraft type"));
    }
}
