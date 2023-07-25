package kr.ft.avaj.simulator.Exception;

public class UnsupportedWeatherException extends RuntimeException {
    public UnsupportedWeatherException() {
        super(ErrorMessage.of("Unsupported weather"));
    }
}
