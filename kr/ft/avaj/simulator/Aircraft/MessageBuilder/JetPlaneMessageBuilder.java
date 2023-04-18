package kr.ft.avaj.simulator.Aircraft.MessageBuilder;

import kr.ft.avaj.simulator.Aircraft.Aircraft;

public class JetPlaneMessageBuilder extends AircraftMessageBuilder {
    public JetPlaneMessageBuilder(Aircraft aircraft) {
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
                return "It's sunny. Let's enjoy the good weather and take some pics.";
            case "SNOW":
                return "OMG! Winter is coming!";
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
