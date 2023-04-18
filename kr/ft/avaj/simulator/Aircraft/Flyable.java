package kr.ft.avaj.simulator.Aircraft;

import kr.ft.avaj.simulator.WeatherTower.WeatherTower;

public interface Flyable {
    public abstract void updateConditions();

    public abstract void registerTower(WeatherTower weatherTower);
}
