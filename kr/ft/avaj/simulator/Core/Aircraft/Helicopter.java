package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.WeatherProvider.WeatherProvider;
import kr.ft.avaj.simulator.Printer.Logger.AircraftLooger.HelicopterLogger;

public class Helicopter extends Aircraft {
    private HelicopterLogger logger = new HelicopterLogger();

    public Helicopter(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        this.coordinates.setWeather(WeatherProvider.getInstance().getRandomWeather());
        logger.logCurrentWeather(this, coordinates);
    }
}
