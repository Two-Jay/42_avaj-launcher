package kr.ft.avaj.simulator.Core.WeatherProvider;

import java.lang.Math;

import kr.ft.avaj.simulator.Core.Coordinates.Coordinates;

public class WeatherProvider {
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {
    }

    public WeatherProvider getINSTANCE() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final WeatherProvider INSTANCE = new WeatherProvider();
    }

    public String getRandomWeather() {
        int rand = (int) Math.floor(Math.random() * 4);
        return weather[rand];
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return coordinates.getWeatherByString();
    }
}
