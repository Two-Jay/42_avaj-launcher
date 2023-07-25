package kr.ft.avaj.simulator.Core.Tower;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return coordinates.getWeatherByString();
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
