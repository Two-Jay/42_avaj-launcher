package kr.ft.avaj.simulator.Printer.Logger.AircraftLooger;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

public interface MESSAGEFORMAT {
    String getMessageByCurrentWeather(WEATHER weather);
}