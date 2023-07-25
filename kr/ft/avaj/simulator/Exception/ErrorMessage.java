package kr.ft.avaj.simulator.Exception;

public class ErrorMessage {
    public static String of(String message) {
        return String.format("Error : %s", message);
    }
}
