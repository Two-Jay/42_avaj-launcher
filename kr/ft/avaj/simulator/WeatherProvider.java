package kr.ft.avaj.simulator;

public class WeatherProvider {
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static Field field = new Field(300, 300, weather);

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final WeatherProvider INSTANCE = new WeatherProvider();
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        return field.getWeather(coordinates);
    }

    public static void updateWeather() {
        field.updateWeather(weather);
    }

    public static void printField() {
        field.printWeather();
    }
}