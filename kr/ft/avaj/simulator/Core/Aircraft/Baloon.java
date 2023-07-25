package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.WeatherProvider.WeatherProvider;
import kr.ft.avaj.simulator.Printer.Logger.AircraftLooger.BaloonLogger;
import kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy.BaloonMovingStrategy;
import kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy.MovingStrategy;

public class Baloon extends Aircraft {
    private BaloonLogger logger = new BaloonLogger();
    private MovingStrategy movingStrategy = new BaloonMovingStrategy();

    public Baloon(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        this.coordinates.setWeather(WeatherProvider.getInstance().getRandomWeather());
        movingStrategy.move(this.coordinates);
        logger.logCurrentWeather(this, coordinates);
    }
}
