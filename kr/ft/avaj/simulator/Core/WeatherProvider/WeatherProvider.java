package kr.ft.avaj.simulator.Core.WeatherProvider;

import java.lang.Math;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.WEATHER;

public class WeatherProvider {
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final WeatherProvider INSTANCE = new WeatherProvider();
    }

    public WEATHER getRandomWeather() {
        int randIndex = (int) Math.floor(Math.random() * weather.length);
        return WEATHER.of(weather[randIndex]);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return coordinates.getWeather().toString();
    }
}
