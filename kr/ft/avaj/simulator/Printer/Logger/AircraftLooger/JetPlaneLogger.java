package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

enum JETPLANE_MESSAGE_FORMAT implements MESSAGEFORMAT {
    SUN(WEATHER.SUN, "It's sunny. Let's enjoy the good weather and take some pics."),
    RAIN(WEATHER.RAIN, "It's raining. Better watch out for lightings."),
    FOG(WEATHER.FOG, "It's foggy. Be careful not to crash."),
    SNOW(WEATHER.SNOW, "OMG! Winter is coming!");

    private WEATHER weather;
    private String message;

    JETPLANE_MESSAGE_FORMAT(WEATHER weather, String message) {
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
        for (JETPLANE_MESSAGE_FORMAT format : JETPLANE_MESSAGE_FORMAT.values()) {
            if (format.getWeather().equals(weather)) {
                return format.getMessage();
            }
        }
        return "Unknown weather";
    }

}

public class JetPlaneLogger extends AircraftLogger {
    protected String getLogMessageByWeather(Coordinates co) {
        return JETPLANE_MESSAGE_FORMAT.getMessageByCurrentWeather(co.getWeather());
    }
}