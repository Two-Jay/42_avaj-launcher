package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;
import kr.ft.avaj.simulator.Printer.Logger.Logger;

enum AIRCRAFT_MESSAGE_FORMAT implements MESSAGEFORMAT {
    SUN(WEATHER.SUN, "sunny"),
    RAIN(WEATHER.RAIN, "raining"),
    FOG(WEATHER.FOG, "foggy"),
    SNOW(WEATHER.SNOW, "snowing");

    private WEATHER weather;
    private String message;

    AIRCRAFT_MESSAGE_FORMAT(WEATHER weather, String message) {
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
        for (AIRCRAFT_MESSAGE_FORMAT format : AIRCRAFT_MESSAGE_FORMAT.values()) {
            if (format.getWeather().equals(weather)) {
                return format.getMessage();
            }
        }
        return null;
    }
}

enum AIRCRAFT_LANDING_MESSAGE_FORMAT implements MESSAGEFORMAT {
    LAND("landing");

    private String message;

    AIRCRAFT_LANDING_MESSAGE_FORMAT(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class AircraftLogger extends Logger {
    protected String getLogMessageByWeather(Coordinates co) {
        return AIRCRAFT_MESSAGE_FORMAT.getMessageByCurrentWeather(co.getWeather());
    }

    public void logCurrentWeather(Flyable f, Coordinates co) {
        log(String.format("%s: %s %s", f, this.getLogMessageByWeather(co), co));
    }

    public void logLanding(Flyable f, Coordinates co) {
        log(String.format("%s: %s %s", f, AIRCRAFT_LANDING_MESSAGE_FORMAT.LAND.getMessage(), co));
    }
}
