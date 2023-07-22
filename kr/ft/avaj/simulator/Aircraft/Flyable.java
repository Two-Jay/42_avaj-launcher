package kr.ft.avaj.simulator.Aircraft;

import kr.ft.avaj.simulator.WeatherTower.WeatherTower;
import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public abstract void registerTower(WeatherTower weatherTower);

    public abstract String getAircraftBarcode();

    public abstract Coordinates getCoordinates();

    public abstract void land(WeatherTower weatherTower);
}
