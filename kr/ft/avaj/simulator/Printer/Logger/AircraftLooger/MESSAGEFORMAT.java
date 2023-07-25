package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

public interface MESSAGEFORMAT {
    public static String getMessageByCurrentWeather(WEATHER weather) throws Exception {
        throw new UnsupportedOperationException();
    }

    public String getMessage();
}