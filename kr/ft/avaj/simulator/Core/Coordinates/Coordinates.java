package kr.ft.avaj.simulator.Core.Coordinates;

enum WEATHER {
    SUN("SUN"),
    RAIN("RAIN"),
    FOG("FOG"),
    SNOW("SNOW");

    private String weather;

    WEATHER(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public static WEATHER of(String weather) {
        for (WEATHER w : WEATHER.values()) {
            if (w.getWeather().equals(weather)) {
                return w;
            }
        }
        return null;
    }

    public String toString() {
        return weather;
    }
}

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    private WEATHER weather;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public WEATHER getWeather() {
        return weather;
    }

    public String getWeatherByString() {
        return weather.toString();
    }

    public void setWeather(WEATHER weather) {
        this.weather = weather;
    }

    public void setWeather(String weather) {
        this.weather = WEATHER.of(weather);
    }
}
