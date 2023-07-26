package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

enum BALOON_MESSAGE_FORMAT {
    SUN(WEATHER.SUN, "Let's enjoy the good weather and take some pics."),
    RAIN(WEATHER.RAIN, "Damn you rain! You messed up my baloon."),
    FOG(WEATHER.FOG, "I can't see anything!. We are going down."),
    SNOW(WEATHER.SNOW, "It's snowing. We're gonsna crash.");

    private WEATHER weather;
    private String message;

    BALOON_MESSAGE_FORMAT(WEATHER weather, String message) {
        this.weather = weather;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public WEATHER getWeather() {
        return weather;
    }

    public static String getMessageByCurrentWeather(WEATHER weather) throws UnsupportedOperationException {
        for (BALOON_MESSAGE_FORMAT format : BALOON_MESSAGE_FORMAT.values()) {
            if (format.getWeather().equals(weather)) {
                return format.getMessage();
            }
        }
        throw new UnsupportedOperationException();
    }

}

public class BaloonLogger extends AircraftLogger {
    protected String getLogMessageByWeather(Coordinates co) {
        return BALOON_MESSAGE_FORMAT.getMessageByCurrentWeather(co.getWeather());
    }
}