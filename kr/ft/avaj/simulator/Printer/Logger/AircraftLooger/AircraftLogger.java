package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;
import kr.ft.avaj.simulator.Printer.Logger.Logger;

enum AIRCRAFT_LANDING_MESSAGE_FORMAT implements MESSAGEFORMAT {
    LAND("We are happy to announce that we have landed.");

    private String message;

    AIRCRAFT_LANDING_MESSAGE_FORMAT(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageByWeather(WEATHER we) {
        throw new UnsupportedOperationException();
    }
}

public class AircraftLogger extends Logger {
    protected String getLogMessageByWeather(Coordinates co) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void logCurrentWeather(Flyable f, Coordinates co) {
        log(String.format("%s: %s %s", f, this.getLogMessageByWeather(co), co));
    }

    public void logLanding(Flyable f, Coordinates co) {
        log(String.format("%s: %s %s", f, AIRCRAFT_LANDING_MESSAGE_FORMAT.LAND.getMessage(), co));
    }
}
