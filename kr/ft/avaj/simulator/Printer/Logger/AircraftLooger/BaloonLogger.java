package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

enum BALOON_MESSAGE_FORMAT implements MESSAGEFORMAT {
    SUN(WEATHER.SUN, "sunny"),
    RAIN(WEATHER.RAIN, "raining"),
    FOG(WEATHER.FOG, "foggy"),
    SNOW(WEATHER.SNOW, "snowing");

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

    public static String getMessageByCurrentWeather(WEATHER weather) {
        for (BALOON_MESSAGE_FORMAT format : BALOON_MESSAGE_FORMAT.values()) {
            if (format.getWeather().equals(weather)) {
                return format.getMessage();
            }
        }
        return null;
    }
}

public class BaloonLogger extends AircraftLogger {
    @Override
    protected String getLogMessageByWeather(Coordinates co) {
        return BALOON_MESSAGE_FORMAT.getMessageByCurrentWeather(co.getWeather());
    }
}
