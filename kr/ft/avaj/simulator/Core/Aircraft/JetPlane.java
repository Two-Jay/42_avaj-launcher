package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.WeatherProvider.WeatherProvider;
import kr.ft.avaj.simulator.Printer.Logger.AircraftLooger.JetPlaneLogger;

public class JetPlane extends Aircraft {
    private JetPlaneLogger logger = new JetPlaneLogger();

    public JetPlane(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        this.coordinates.setWeather(WeatherProvider.getInstance().getRandomWeather());
        logger.logCurrentWeather(this, coordinates);
    }
}
