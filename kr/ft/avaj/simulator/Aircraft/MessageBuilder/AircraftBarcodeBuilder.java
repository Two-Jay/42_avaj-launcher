package kr.ft.avaj.simulator.Aircraft.MessageBuilder;

public class AircraftBarcodeBuilder {
    String code;

    public AircraftBarcodeBuilder(String type, String name, long id) {
        code = type + "#" + name + "(" + id + ")";
    }

    public String getCode() {
        return code;
    }
}
