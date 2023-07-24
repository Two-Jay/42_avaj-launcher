package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract public void updateConditions();

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
