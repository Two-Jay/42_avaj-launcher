package kr.ft.avaj.simulator.WeatherTower;

import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;
import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public class WeatherTower extends Tower {
    private static WeatherProvider weatherProvider = WeatherProvider.getProvider();

    public String getWeather(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        weatherProvider.updateWeather();
    }
}
