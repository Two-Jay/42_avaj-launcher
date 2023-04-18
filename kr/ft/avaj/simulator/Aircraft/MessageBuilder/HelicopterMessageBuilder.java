package kr.ft.avaj.simulator.Aircraft.MessageBuilder;

import kr.ft.avaj.simulator.Aircraft.Aircraft;

public class HelicopterMessageBuilder extends AircraftMessageBuilder {
    public HelicopterMessageBuilder(Aircraft aircraft) {
        super(aircraft);
    }

    @Override
    protected String buildReportMessageByWeather(String weather) {
        switch (weather) {
            case "RAIN":
                return "It's raining. Better watch out for lightings.";
            case "FOG":
                return "It's foggy. Be careful not to crash.";
            case "SUN":
                return "This is hot.";
            case "SNOW":
                return "My rotor is going to freeze!";
            default:
                return "Unknown weather.";
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
