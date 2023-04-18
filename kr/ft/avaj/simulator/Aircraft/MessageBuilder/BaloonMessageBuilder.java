package kr.ft.avaj.simulator.Aircraft.MessageBuilder;

import kr.ft.avaj.simulator.Aircraft.Aircraft;

public class BaloonMessageBuilder extends AircraftMessageBuilder {
    public BaloonMessageBuilder(Aircraft aircraft) {
        super(aircraft);
    }

    @Override
    protected String buildReportMessageByWeather(String weather) {
        switch (weather) {
            case "RAIN":
                return "Damn you rain! You messed up my baloon.";
            case "FOG":
                return "I can't see anything!. We are going down.";
            case "SUN":
                return "Let's enjoy the good weather and take some pics.";
            case "SNOW":
                return "It's snowing. We're gonsna crash.";
            default:
                return "Unknown weather";
        }
    }

    @Override
    public String buildMessage(String weather) {
        return String.format(
                "%s: %s %s",
                this.barcodeBuilder.getCode(),
                this.buildReportMessageByWeather(weather),
                this.coordinatesMessageBuilder.getCode());
    }
}
