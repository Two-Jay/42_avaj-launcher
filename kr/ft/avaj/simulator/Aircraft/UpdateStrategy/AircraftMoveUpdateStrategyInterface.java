package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.WeatherTower.WeatherTower;

public interface AircraftMoveUpdateStrategyInterface {
    public void update(Coordinates coordinates, WeatherTower followTower);
}
