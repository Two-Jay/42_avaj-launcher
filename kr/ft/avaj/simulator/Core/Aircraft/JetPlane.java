package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.WeatherProvider.WeatherProvider;
import kr.ft.avaj.simulator.Printer.Logger.AircraftLooger.JetPlaneLogger;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;
import kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy.JetPlaneMovingStrategy;
import kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy.MovingStrategy;

public class JetPlane extends Aircraft {
    private JetPlaneLogger logger = new JetPlaneLogger();
    private MovingStrategy movingStrategy = new JetPlaneMovingStrategy();

    public JetPlane(Long id, String name, Coordinates coordinates) {
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
