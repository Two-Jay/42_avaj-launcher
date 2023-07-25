package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.WeatherProvider.WeatherProvider;
import kr.ft.avaj.simulator.Printer.Logger.AircraftLooger.HelicopterLogger;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;
import kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy.HelicopterMovingStrategy;
import kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy.MovingStrategy;

public class Helicopter extends Aircraft {
    private HelicopterLogger logger = new HelicopterLogger();
    private MovingStrategy movingStrategy = new HelicopterMovingStrategy();

    public Helicopter(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        this.coordinates.setWeather(WeatherProvider.getInstance().getRandomWeather());
        movingStrategy.move(this.coordinates);
        if (this.coordinates.getHeight() <= SimulationMetaData.heightMinimum) {
            this.land();
        } else {
            logger.logCurrentWeather(this, coordinates);
        }
    }

    private void land() {
        logger.logLanding(this, coordinates);
        this.weatherTower.unregister(this);
    }
}
