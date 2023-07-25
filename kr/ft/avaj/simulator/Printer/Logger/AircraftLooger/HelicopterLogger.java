package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

enum HELICOPTER_MESSAGE_FORMAT implements MESSAGEFORMAT {
    SUN(WEATHER.SUN, "This is hot like our roters."),
    RAIN(WEATHER.RAIN, "It's raining. Better watch out for lightings."),
    FOG(WEATHER.FOG, "It's foggy. Be careful not to crash."),
    SNOW(WEATHER.SNOW, "My rotor is going to freeze!");

    private WEATHER weather;
    private String message;

    HELICOPTER_MESSAGE_FORMAT(WEATHER weather, String message) {
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
        for (HELICOPTER_MESSAGE_FORMAT format : HELICOPTER_MESSAGE_FORMAT.values()) {
            if (format.getWeather().equals(weather)) {
                return format.getMessage();
            }
        }
        return "Unknown weather";
    }
}

public class HelicopterLogger extends AircraftLogger {
    protected String getLogMessageByWeather(Coordinates co) {
        return HELICOPTER_MESSAGE_FORMAT.getMessageByCurrentWeather(co.getWeather());
    }
}