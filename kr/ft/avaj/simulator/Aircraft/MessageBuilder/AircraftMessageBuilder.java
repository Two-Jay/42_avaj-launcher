package kr.ft.avaj.simulator.Aircraft.MessageBuilder;

import kr.ft.avaj.simulator.Aircraft.Aircraft;

public abstract class AircraftMessageBuilder implements MessageBuilderInterface {
    protected AircraftBarcodeBuilder barcodeBuilder;
    protected CoordinatesMessageBuilder coordinatesMessageBuilder;

    public AircraftMessageBuilder(Aircraft aircraft) {
        barcodeBuilder = new AircraftBarcodeBuilder(aircraft.getType(), aircraft.getName(), aircraft.getId());
        coordinatesMessageBuilder = new CoordinatesMessageBuilder(aircraft.getCoordinates());
    }

    protected abstract String buildReportMessageByWeather(String weather);

    public abstract String buildMessage(String weather);

    public String buildAircraftBarcode() {
        return barcodeBuilder.getCode();
    }
}