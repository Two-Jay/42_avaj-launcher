package kr.ft.avaj.simulator.WeatherProvider;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;

public class WeatherProvider {
    private static SimulationMetaData metaData = new SimulationMetaData();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
    private static Field field;

    private WeatherProvider() {
        field = new Field(metaData.latitudeMaximum, metaData.longitudeMaximum, weather);
    }

    public static WeatherProvider getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final WeatherProvider INSTANCE = new WeatherProvider();
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return field.getWeather(coordinates);
    }

    public void updateWeather() {
        field.updateWeather(weather);
    }
}